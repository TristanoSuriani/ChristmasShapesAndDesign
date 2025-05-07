package nl.suriani.christmas.shapes.and.design.sushi.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public record Reservation(String name, LocalDateTime dateTime, int numberOfPeople) {
    public Reservation {
        Objects.requireNonNull(name);
        Objects.requireNonNull(dateTime);
        if (numberOfPeople < 1) {
            throw new IllegalArgumentException("Number of people must be at least 1");
        }
    }
}
