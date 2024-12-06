package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import java.util.Objects;

public record SearchItem(SearchItemId id,
                         String description,
                         Availability availability) {


    public SearchItem {
        Objects.requireNonNull(id);
        Objects.requireNonNull(description);
        Objects.requireNonNull(availability);
    }
}