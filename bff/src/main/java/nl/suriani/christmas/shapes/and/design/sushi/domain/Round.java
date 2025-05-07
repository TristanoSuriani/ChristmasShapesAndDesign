package nl.suriani.christmas.shapes.and.design.sushi.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public record Round(UUID uuid, List<Meal> meals) {

    public Round {
        Objects.requireNonNull(uuid);
        Objects.requireNonNull(meals);
    }
}
