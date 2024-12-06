package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchItemsUseCase {
    private final SearchItemsRepository searchItemsRepository;

    public List<SearchItem> search(SearchItemsQuery query) {
        return searchItemsRepository.search(query);
    }
}
