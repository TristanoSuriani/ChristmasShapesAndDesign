package nl.suriani.christmas.shapes.and.design.usecase.fetch_items;

import nl.suriani.christmas.shapes.and.design.interfaces.search.SearchItem;

import java.util.List;

public interface SearchItemsRepository {
    List<SearchItem> search(SearchItemsQuery query);
}
