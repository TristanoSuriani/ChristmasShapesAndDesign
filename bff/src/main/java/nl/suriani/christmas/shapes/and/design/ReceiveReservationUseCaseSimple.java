package nl.suriani.christmas.shapes.and.design;

import lombok.RequiredArgsConstructor;
import nl.suriani.christmas.shapes.and.design.eventz.Fact;
import nl.suriani.christmas.shapes.and.design.eventz.ReceiveReservationCommand;
import nl.suriani.christmas.shapes.and.design.eventz.Reservation;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.CommandHandler;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.F;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.UseCase;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class ReceiveReservationUseCaseSimple implements UseCase<ReceiveReservationCommand> {
    private final ReservationRepository reservationRepository;

    public void accept(ReceiveReservationCommand command) {

        F<ReceiveReservationCommand, Reservation> f = (existingReservation, cmd) -> {

            if (Optional.ofNullable(existingReservation).isPresent()) {
                return existingReservation;
            }

            return new Reservation(cmd.id(), cmd.mainGuest());
        };

        Supplier<Reservation> stateLoader = () -> reservationRepository.findById(command.id().toString()).orElse(null);

        Consumer<Reservation> stateSaver = reservationRepository::save;

        CommandHandler<ReceiveReservationCommand, Reservation> commandHandler = new CommandHandler<>(
                f,
                stateLoader,
                stateSaver
        );

        commandHandler.accept(command);
    }

    private interface ReservationRepository {
        Optional<Reservation> findById(String id);
        void save(Reservation reservation);
    }
}
