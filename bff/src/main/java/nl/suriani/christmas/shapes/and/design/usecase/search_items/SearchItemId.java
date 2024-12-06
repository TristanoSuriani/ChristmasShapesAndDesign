package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import java.util.Objects;
import java.util.UUID;

public record SearchItemId(UUID value) {
    public SearchItemId {
        Objects.requireNonNull(value);
    }

    public SearchItemId() {
        this(UUID.randomUUID());
    }
}
