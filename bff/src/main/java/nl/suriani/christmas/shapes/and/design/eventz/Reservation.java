package nl.suriani.christmas.shapes.and.design.eventz;

import java.util.Objects;
import java.util.UUID;

public record Reservation(UUID id, String mainGuest) implements Fact {
    public Reservation {
        Objects.requireNonNull(id);
        Objects.requireNonNull(mainGuest);
    }
}
