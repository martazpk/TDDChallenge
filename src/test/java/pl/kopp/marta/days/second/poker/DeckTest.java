package pl.kopp.marta.days.second.poker;

import org.junit.jupiter.api.Test;
import pl.kopp.marta.days.second.poker.model.Deck;


import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {
    @Test
    void shouldCreateDeck() {
        Deck deck = new Deck();

        assertThat(deck.getCards()).hasSize(52);
    }
}