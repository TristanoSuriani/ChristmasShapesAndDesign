package nl.suriani.christmas.shapes.and.design.sushi.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public record RoundDraft(UUID uuid, List<Meal> meals) {

    public RoundDraft {
        Objects.requireNonNull(uuid);
        Objects.requireNonNull(meals);
        if (meals.isEmpty()) {
            throw new IllegalArgumentException("RoundDraft must contain at least one meal");
        }
    }
}
