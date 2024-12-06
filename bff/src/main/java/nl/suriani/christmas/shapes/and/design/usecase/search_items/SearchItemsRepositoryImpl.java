package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchItemsRepositoryImpl implements SearchItemsRepository {
    private final ItemDataToSearchItemMapper itemDataToSearchItemMapper = new ItemDataToSearchItemMapper();
    private final ApiResponseClient apiResponseClient;

    @Override
    public List<SearchItem> search(SearchItemsQuery query) {
        var response = apiResponseClient.fetchApiResponse();
        return response.data().stream()
                .map(itemDataToSearchItemMapper)
                .toList();
    }
}
