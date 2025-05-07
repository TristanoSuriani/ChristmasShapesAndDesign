package nl.suriani.christmas.shapes.and.design.sushi.port;

import nl.suriani.christmas.shapes.and.design.sushi.domain.RoundDraft;

import java.util.Optional;
import java.util.UUID;

public interface RoundDraftRepository {
    Optional<RoundDraft> findById(UUID id);
}
