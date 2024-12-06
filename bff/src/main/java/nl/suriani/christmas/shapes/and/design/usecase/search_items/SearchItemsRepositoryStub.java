package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Service
public class SearchItemsRepositoryStub implements SearchItemsRepository {
    @Override
    public List<SearchItem> search(SearchItemsQuery query) {
        return List.of(
                new SearchItem(new SearchItemId(),
                        "Lightbulb Type A",
                        Availability.forSaleAndForRent(
                                Availability.forSale(
                                        BigDecimal.valueOf(14.05),
                                        BigDecimal.valueOf(3.45),
                                        LocalDate.now().plusDays(2)
                                ),
                                Availability.forRent(
                                        BigDecimal.valueOf(1.05),
                                        BigDecimal.valueOf(3.45),
                                        BigDecimal.valueOf(7.55),
                                        BigDecimal.valueOf(1.10),
                                        LocalDate.now().plusDays(2)
                                )
                        )
                ),
                new SearchItem(new SearchItemId(),
                        "Lightbulb Type B",
                        Availability.none()
                )
        );
    }
}
