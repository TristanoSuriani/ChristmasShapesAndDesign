package nl.suriani.christmas.shapes.and.design.usecase.cart.remove;

import java.util.Objects;
import java.util.UUID;

public record RemoveFromCartCommand(UUID itemId, UUID userId) {
    public RemoveFromCartCommand {
        Objects.requireNonNull(itemId);
        Objects.requireNonNull(userId);
    }
}
