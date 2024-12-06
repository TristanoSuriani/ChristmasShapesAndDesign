package nl.suriani.christmas.shapes.and.design.usecase.cart.add;

import java.util.Objects;
import java.util.UUID;

public record AddToCartCommand(UUID itemId, UUID userId, int amount) {
    public AddToCartCommand {
        Objects.requireNonNull(itemId);
        Objects.requireNonNull(userId);
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}
