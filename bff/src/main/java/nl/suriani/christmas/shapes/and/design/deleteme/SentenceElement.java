package nl.suriani.christmas.shapes.and.design.deleteme;

import java.util.Objects;

public sealed interface SentenceElement {
    record Word(String value) implements SentenceElement {
        public Word {
            Objects.requireNonNull(value);
        }
    }
    
    enum Separator implements SentenceElement {
        COMMA(","),
        DOT("."),
        COLON(":"),
        SEMICOLON(";");

        private String value;

        Separator(String value) {
            this.value = value;
        }
    }
}
