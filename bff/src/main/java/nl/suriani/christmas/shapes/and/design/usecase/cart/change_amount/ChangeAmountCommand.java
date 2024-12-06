package nl.suriani.christmas.shapes.and.design.usecase.cart.change_amount;

import java.util.Objects;
import java.util.UUID;

public record ChangeAmountCommand(UUID itemId, UUID userId, int amount) {
    public ChangeAmountCommand {
        Objects.requireNonNull(itemId);
        Objects.requireNonNull(userId);
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}
