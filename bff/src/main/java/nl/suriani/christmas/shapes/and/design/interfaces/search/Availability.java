package nl.suriani.christmas.shapes.and.design.interfaces.search;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public sealed interface Availability {
    String type();

    static None none() {
        return new None("OutOfStock");
    }

    static ForSale forSale (BigDecimal price,
                            BigDecimal deliveryCosts,
                            LocalDate expectedDeliveryDate) {

        return new ForSale("Buy", price, deliveryCosts, expectedDeliveryDate);
    }

    static ForRent forRent (BigDecimal pricePerDay,
                            BigDecimal pricePerWeek,
                            BigDecimal pricePerMonth,
                            BigDecimal deliveryCosts,
                            LocalDate expectedDeliveryDate) {

        return new ForRent("Rent", pricePerDay, pricePerWeek, pricePerMonth, deliveryCosts, expectedDeliveryDate);
    }

    static ForSaleAndForRent forSaleAndForRent (ForSale forSale, ForRent forRent) {
        return new ForSaleAndForRent("BuyOrRent", forSale, forRent);
    }

    record None(String type) implements Availability {}

    record ForSale(String type,
                   BigDecimal price,
                   BigDecimal deliveryCosts,
                   LocalDate expectedDeliveryDate) implements Availability {

        public ForSale {
            Objects.requireNonNull(type);
            Objects.requireNonNull(price);
            Objects.requireNonNull(deliveryCosts);
            Objects.requireNonNull(expectedDeliveryDate);
        }
    }

    record ForRent(String type,
                   BigDecimal pricePerDay,
                   BigDecimal pricePerWeek,
                   BigDecimal pricePerMonth,
                   BigDecimal deliveryCosts,
                   LocalDate expectedDeliveryDate) implements Availability {

        public ForRent {
            Objects.requireNonNull(type);
            Objects.requireNonNull(pricePerDay);
            Objects.requireNonNull(pricePerWeek);
            Objects.requireNonNull(pricePerMonth);
            Objects.requireNonNull(deliveryCosts);
            Objects.requireNonNull(expectedDeliveryDate);
        }
    }

    record ForSaleAndForRent(String type, ForSale forSale, ForRent forRent) implements Availability {
        public ForSaleAndForRent {
            Objects.requireNonNull(type);
            Objects.requireNonNull(forSale);
            Objects.requireNonNull(forRent);
        }
    }
}