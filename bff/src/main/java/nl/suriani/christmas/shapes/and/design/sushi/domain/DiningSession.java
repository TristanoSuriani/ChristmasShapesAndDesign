package nl.suriani.christmas.shapes.and.design.sushi.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public record DiningSession(UUID sessionId,
                            Optional<Reservation> reservation,
                            PricingProfile pricingProfile,
                            List<TableSession> tableSessions,
                            Optional<String> feedback,
                            Status status) {

    public DiningSession {
        Objects.requireNonNull(sessionId);
        Objects.requireNonNull(reservation);
        Objects.requireNonNull(pricingProfile);
        Objects.requireNonNull(tableSessions);
        Objects.requireNonNull(feedback);
    }
}
