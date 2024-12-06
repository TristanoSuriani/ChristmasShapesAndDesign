package nl.suriani.christmas.shapes.and.design.interfaces.cart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.suriani.christmas.shapes.and.design.usecase.cart.add.AddToCartCommand;
import nl.suriani.christmas.shapes.and.design.usecase.cart.add.AddToCartUseCase;
import nl.suriani.christmas.shapes.and.design.usecase.cart.change_amount.ChangeAmountCommand;
import nl.suriani.christmas.shapes.and.design.usecase.cart.change_amount.ChangeAmountUseCase;
import nl.suriani.christmas.shapes.and.design.usecase.cart.remove.RemoveFromCartCommand;
import nl.suriani.christmas.shapes.and.design.usecase.cart.remove.RemoveFromCartUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("api/cart")
@Slf4j
@RequiredArgsConstructor
public class CartController {
    private final AddToCartUseCase addToCartUseCase;
    private final ChangeAmountUseCase changeAmountUseCase;
    private final RemoveFromCartUseCase removeFromCartUseCase;

    @PostMapping("add")
    void add(@RequestBody AddToCart addToCart) {
        var comand = new AddToCartCommand(addToCart.itemId, UUID.randomUUID(), addToCart.amount());
        addToCartUseCase.add(comand);
    }

    @PostMapping("changeAmount")
    void changeAmount(@RequestBody ChangeAmount changeAmount) {
        var comand = new ChangeAmountCommand(changeAmount.itemId, UUID.randomUUID(), changeAmount.amount());
        changeAmountUseCase.changeAmount(comand);
    }

    @PostMapping("remove")
    void changeAmount(@RequestBody RemoveFromCart removeFromCart) {
        var comand = new RemoveFromCartCommand(removeFromCart.itemId, UUID.randomUUID());
        removeFromCartUseCase.remove(comand);
    }

    record AddToCart(UUID itemId, int amount) {}
    record ChangeAmount(UUID itemId, int amount) {}
    record RemoveFromCart(UUID itemId) {}
}
