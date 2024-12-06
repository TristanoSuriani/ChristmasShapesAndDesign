package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import java.time.Instant;
import java.util.List;

public record ApiResponse(List<ItemData> data) {
    // Data Record
    public record ItemData(
            int id,
            String documentId,
            String itemId,
            Instant createdAt,
            Instant updatedAt,
            Instant publishedAt,
            String description,
            double suggestedSellingPrice,
            double suggestedRentalPricePerDay
    ) {}

}

