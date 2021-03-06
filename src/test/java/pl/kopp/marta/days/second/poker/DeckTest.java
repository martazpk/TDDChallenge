package pl.kopp.marta.days.second.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.Deck;


import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void shouldCreateDeck() {
        assertThat(deck.getCards()).hasSize(52);
    }

    @Test
    void checkIsCardsAreDistinct() {
        List<Card> distinct = deck.getCards().stream().distinct().collect(Collectors.toList());

        assertThat(distinct).hasSize(52);
    }

    @Test
    void shouldShuffleDeck() {
        Deck shuffledDeck = new Deck();

        shuffledDeck.shuffle(50);

        assertThat(deck).isNotEqualTo(shuffledDeck);
        assertThat(shuffledDeck.getCards().size()).isEqualTo(52);
    }

    @Test
    void shouldGetFiveCardFromDeck() {
        List<Card> cards = deck.getCards(5);

        assertThat(cards).hasSize(5);
    }
}