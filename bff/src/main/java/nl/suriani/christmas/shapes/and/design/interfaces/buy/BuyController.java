package nl.suriani.christmas.shapes.and.design.interfaces.buy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/buy")
public class BuyController {

    @GetMapping
    String hello() {
        return "Hello buy!";
    }
}
