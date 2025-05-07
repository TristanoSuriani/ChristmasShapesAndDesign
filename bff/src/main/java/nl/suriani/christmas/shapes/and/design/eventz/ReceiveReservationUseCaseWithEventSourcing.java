package nl.suriani.christmas.shapes.and.design.eventz;

import lombok.RequiredArgsConstructor;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.CommandHandler;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.F;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.UseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class ReceiveReservationUseCaseWithEventSourcing implements UseCase<ReceiveReservationCommand> {
    private final EventStream eventStream;

    public void accept(ReceiveReservationCommand command) {

        F<ReceiveReservationCommand, List<Event>> f = (events, cmd) -> {
            var state = rehydrateEvents(events);

            if (state instanceof Reservation) {
                throw new RuntimeException("Reservation already exists");
            }

            var newEventsStream = new ArrayList<>(events);
            newEventsStream.add(new ReservationReceivedEvent(cmd.id(), cmd.mainGuest()));
            return newEventsStream;
        };

        Supplier<List<Event>> stateLoader = () -> eventStream.loadEventsById(command.id().toString());

        Consumer<List<Event>> stateSaver = events -> eventStream.append(events.getLast());

        CommandHandler<ReceiveReservationCommand, List<Event>> commandHandler = new CommandHandler<>(
                f,
                stateLoader,
                stateSaver
        );

        commandHandler.accept(command);
    }

    private Reservation rehydrateEvents(List<Event> events) {
        var reservationReceivedEvent = events.stream()
                .filter(event -> event instanceof ReservationReceivedEvent)
                .map(event -> (ReservationReceivedEvent) event)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No reservation received event found"));

        return new Reservation(reservationReceivedEvent.id(), reservationReceivedEvent.mainGuest());
    }

    private record ReservationReceivedEvent(
            UUID id,
            String mainGuest
    ) implements Event {
        public ReservationReceivedEvent {
            Objects.requireNonNull(id);
            Objects.requireNonNull(mainGuest);
        }
    }

    private interface Event {}

    private interface EventStream {
        public List<Event> loadEventsById(String id);
        public void append(Event event);
    }

}
