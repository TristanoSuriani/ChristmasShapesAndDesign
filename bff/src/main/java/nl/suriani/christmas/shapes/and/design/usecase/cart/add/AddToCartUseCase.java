package nl.suriani.christmas.shapes.and.design.usecase.cart.add;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddToCartUseCase {
    public void add (AddToCartCommand command) {
        log.info("Add to cart: {}", command);
    }
}
