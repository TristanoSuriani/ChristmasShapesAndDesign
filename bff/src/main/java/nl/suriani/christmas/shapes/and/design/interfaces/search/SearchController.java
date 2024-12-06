package nl.suriani.christmas.shapes.and.design.interfaces.search;

import lombok.RequiredArgsConstructor;
import nl.suriani.christmas.shapes.and.design.usecase.fetch_items.SearchItemsQuery;
import nl.suriani.christmas.shapes.and.design.usecase.fetch_items.SearchItemsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("api/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchItemsUseCase searchItemsUseCase;

    @GetMapping
    List<SearchItem> search() {
        var query = new SearchItemsQuery("lightbulb");
        return searchItemsUseCase.search(query);
    }
}
