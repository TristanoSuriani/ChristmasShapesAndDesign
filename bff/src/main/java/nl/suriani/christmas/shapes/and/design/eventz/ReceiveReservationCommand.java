package nl.suriani.christmas.shapes.and.design.eventz;

import java.util.Objects;
import java.util.UUID;

public record ReceiveReservationCommand(UUID id, String mainGuest) {
    public ReceiveReservationCommand {
        Objects.requireNonNull(id);
        Objects.requireNonNull(mainGuest);
    }
}
