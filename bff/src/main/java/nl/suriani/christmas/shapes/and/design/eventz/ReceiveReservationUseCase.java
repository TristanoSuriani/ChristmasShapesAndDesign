package nl.suriani.christmas.shapes.and.design.eventz;

import lombok.RequiredArgsConstructor;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.CommandHandler;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.F;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.UseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class ReceiveReservationUseCase implements UseCase<ReceiveReservationCommand> {
    private final FactsLog factsLog;

    public void accept(ReceiveReservationCommand command) {

        F<ReceiveReservationCommand, List<Fact>> f = (state, cmd) -> {
            var existingReservation = state.stream()
                    .filter(fact -> fact instanceof Reservation)
                    .findFirst();

            if (existingReservation.isPresent()) {
                throw new RuntimeException("Reservation already exists");
            }

            var reservation = new Reservation(cmd.id(), cmd.mainGuest());
            var newState = new ArrayList<>(state);
            newState.add(reservation);
            return newState;
        };

        Supplier<List<Fact>> stateLoader = () -> factsLog.loadFactsById(command.id().toString());

        Consumer<List<Fact>> stateSaver = facts -> factsLog.append(facts.getLast());

        CommandHandler<ReceiveReservationCommand, List<Fact>> commandHandler = new CommandHandler<>(
                f,
                stateLoader,
                stateSaver
        );

        commandHandler.accept(command);
    }
}
