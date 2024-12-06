package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

public class ItemDataToSearchItemMapper implements Function<ApiResponse.ItemData, SearchItem> {

    @Override
    public SearchItem apply(ApiResponse.ItemData itemData) {
        Objects.requireNonNull(itemData, "ItemData cannot be null");

        var id = new SearchItemId(UUID.fromString(itemData.itemId()));
        var description = itemData.description();
        var availability = determineAvailability(itemData);

        return new SearchItem(id, description, availability);
    }

    private Availability determineAvailability(ApiResponse.ItemData itemData) {
        var sellingPrice = BigDecimal.valueOf(itemData.suggestedSellingPrice());
        var rentalPricePerDay = BigDecimal.valueOf(itemData.suggestedRentalPricePerDay());

        var expectedDeliveryDate = LocalDate.ofInstant(itemData.createdAt(), ZoneId.systemDefault());
        var deliveryCosts = BigDecimal.valueOf(5.00);

        var hasSellingPrice = sellingPrice.compareTo(BigDecimal.ZERO) > 0;
        var hasRentalPrice = rentalPricePerDay.compareTo(BigDecimal.ZERO) > 0;

        if (hasSellingPrice && hasRentalPrice) {
            Availability.ForSale forSale = Availability.forSale(sellingPrice, deliveryCosts, expectedDeliveryDate);
            Availability.ForRent forRent = Availability.forRent(rentalPricePerDay, rentalPricePerDay.multiply(BigDecimal.valueOf(7)), rentalPricePerDay.multiply(BigDecimal.valueOf(30)), deliveryCosts, expectedDeliveryDate);
            return Availability.forSaleAndForRent(forSale, forRent);
        }

        if (hasSellingPrice) {
            return Availability.forSale(sellingPrice, deliveryCosts, expectedDeliveryDate);
        }

        if (hasRentalPrice) {
            return Availability.forRent(rentalPricePerDay, rentalPricePerDay.multiply(BigDecimal.valueOf(7)), rentalPricePerDay.multiply(BigDecimal.valueOf(30)), deliveryCosts, expectedDeliveryDate);
        }

        return Availability.none();
    }
}