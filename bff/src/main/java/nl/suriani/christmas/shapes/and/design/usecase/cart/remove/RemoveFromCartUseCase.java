package nl.suriani.christmas.shapes.and.design.usecase.cart.remove;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RemoveFromCartUseCase {
    public void remove(RemoveFromCartCommand command) {
        log.info("Remove from cart: {}", command);
    }
}
