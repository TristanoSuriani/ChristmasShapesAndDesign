package nl.suriani.christmas.shapes.and.design.interfaces.cart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/cart")
@Slf4j
public class CartController {

    @PostMapping("add")
    void add(@RequestBody AddToCart addToCart) {
        log.info("Add to cart: {}", addToCart);
    }

    @PostMapping("changeAmount")
    void changeAmount(@RequestBody ChangeAmount changeAmount) {
        log.info("Change amount: {}", changeAmount);
    }

    @PostMapping("remove")
    void changeAmount(@RequestBody RemoveFromCart removeFromCart) {
        log.info("Remove from cart: {}", removeFromCart);
    }

    record AddToCart(String itemId, int amount) {}
    record ChangeAmount(String itemId, int amount) {}
    record RemoveFromCart(String itemId) {}
}
