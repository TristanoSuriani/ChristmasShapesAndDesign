package nl.suriani.christmas.shapes.and.design;

import lombok.RequiredArgsConstructor;
import nl.suriani.christmas.shapes.and.design.eventz.EventSourcedCommandHandler;
import nl.suriani.christmas.shapes.and.design.eventz.ReceiveReservationCommand;
import nl.suriani.christmas.shapes.and.design.eventz.algebra.UseCase;

@RequiredArgsConstructor
public class ReceiveReservationUseCaseWithEventSourcingCommandHandler implements UseCase<ReceiveReservationCommand> {
    private final EventSourcedCommandHandler.EventStream eventStream;
    private final EventSourcedCommandHandler.EventListener eventListener;
    private final EventSourcedCommandHandler.Decider decider;

    public void accept(ReceiveReservationCommand command) {

        EventSourcedCommandHandler<ReceiveReservationCommand> eventSourcedCommandHandler = new EventSourcedCommandHandler<>(
                eventStream,
                eventListener,
                decider
        );

        eventSourcedCommandHandler.accept(command);
    }
}
