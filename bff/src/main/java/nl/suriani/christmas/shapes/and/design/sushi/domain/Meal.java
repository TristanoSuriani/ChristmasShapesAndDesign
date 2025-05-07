package nl.suriani.christmas.shapes.and.design.sushi.domain;

import java.util.Objects;
import java.util.Optional;

public record Meal(String name, Optional<Integer> additionalCosts, Optional<Integer> maxPerPersonPerTable) {

    public Meal {
        Objects.requireNonNull(name);
        Objects.requireNonNull(additionalCosts);
        Objects.requireNonNull(maxPerPersonPerTable);
    }
}
