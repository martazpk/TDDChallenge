package pl.kopp.marta.days.second.poker;

import org.junit.jupiter.api.Test;
import pl.kopp.marta.days.second.poker.model.Card;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PokerTest {

    @Test
    void shouldGetFiveCardFromDeck() {
        Poker poker = new Poker();
        List<Card> cards = poker.start();

        assertThat(cards).hasSize(5);
    }
}