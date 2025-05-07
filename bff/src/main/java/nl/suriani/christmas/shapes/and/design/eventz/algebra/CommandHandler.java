package nl.suriani.christmas.shapes.and.design.eventz.algebra;

import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class CommandHandler<C, S> implements Consumer<C> {

    private final F<C, S> f;
    private final Supplier<S> stateLoader;
    private final Consumer<S> stateSaver;

    public void accept(C command) {
        final var state = stateLoader.get();
        final var newState = f.apply(state, command);
        if (!newState.equals(state)) {
            stateSaver.accept(newState);
        }
    }
}
