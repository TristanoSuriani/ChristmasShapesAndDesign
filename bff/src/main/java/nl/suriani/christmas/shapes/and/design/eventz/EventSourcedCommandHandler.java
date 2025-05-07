package nl.suriani.christmas.shapes.and.design.eventz;

import lombok.RequiredArgsConstructor;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.CommandHandler;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.F;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class EventSourcedCommandHandler<C extends Command> implements Consumer<C>{

    private final EventStream eventStream;
    private final EventListener eventListener;
    private final Decider decider;

    @Override
    public void accept(C command) {
        F<C, List<Event>> f = (events, cmd) -> {
            var state = (Reservation) null;
            for (var event : events) {
                state = decider.evolve(state, event);
            }

            var newEvents = decider.decide(state, cmd);

            var newEventsStream = new ArrayList<>(events);
            newEventsStream.addAll(newEvents);
            return newEventsStream;
        };

        Supplier<List<Event>> stateLoader = () -> eventStream.loadEventsById(command.id().toString());

        Consumer<List<Event>> stateSaver = events -> eventStream.updateStream(eventStream.loadEventsById(command.id().toString()),
                events);

        CommandHandler<C, List<Event>> commandHandler = new CommandHandler<>(
                f,
                stateLoader,
                stateSaver
        );

        commandHandler.accept(command);
    }

    public interface EventStream {
        public List<Event> loadEventsById(String id);
        public void updateStream(List<Event> oldStream, List<Event> newStream);
    }

    public interface EventListener {
        void onEvent(Event event);
    }

    public interface Decider {
        List<Event> decide(Reservation reservation, Command command);
        Reservation evolve(Reservation reservation, Event event);
    }
}
