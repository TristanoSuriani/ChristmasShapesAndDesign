package nl.suriani.christmas.shapes.and.design.eventz;

import java.util.List;

public interface FactsLog {
    List<Fact> loadFactsById(String id);
    void append(Fact fact);
}
