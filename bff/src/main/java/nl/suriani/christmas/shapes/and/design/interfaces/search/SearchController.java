package nl.suriani.christmas.shapes.and.design.interfaces.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("api/search")
public class SearchController {

    @GetMapping
    List<SearchItem> search() {
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
