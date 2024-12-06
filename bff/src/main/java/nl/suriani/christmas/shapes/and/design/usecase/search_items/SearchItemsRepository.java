package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import java.util.List;

public interface SearchItemsRepository {
    List<SearchItem> search(SearchItemsQuery query);
}
