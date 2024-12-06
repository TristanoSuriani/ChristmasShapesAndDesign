package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import java.util.Objects;

public record SearchItemsQuery(String text) {
        public SearchItemsQuery {
            Objects.requireNonNull(text);
        }
    }