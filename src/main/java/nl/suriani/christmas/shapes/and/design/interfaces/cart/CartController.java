package nl.suriani.christmas.shapes.and.design.interfaces.cart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/cart")
public class CartController {

    @GetMapping
    String hello() {
        return "Hello cart!";
    }
}
