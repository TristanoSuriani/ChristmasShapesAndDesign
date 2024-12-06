package nl.suriani.christmas.shapes.and.design.usecase.cart.change_amount;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChangeAmountUseCase {
    public void changeAmount(ChangeAmountCommand command) {
        log.info("Change amount: {}", command);
    }
}
