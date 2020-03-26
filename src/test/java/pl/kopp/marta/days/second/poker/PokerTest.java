package pl.kopp.marta.days.second.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.Rank;
import pl.kopp.marta.days.second.poker.model.Suit;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PokerTest {
    private Poker poker;

    @BeforeEach
    void setUp() {
        poker = new Poker();
    }

    @Test
    void shouldGetFiveCardFromDeck() {
        List<Card> cards = poker.game();

        assertThat(cards).hasSize(5);
    }

    @Test
    void shouldReturnTheHighestCard() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.CLUB, Rank.TWO),
                new Card(Suit.CLUB, Rank.FOUR),
                new Card(Suit.CLUB, Rank.FIVE),
                new Card(Suit.CLUB, Rank.JACK),
                new Card(Suit.CLUB, Rank.SEVEN));
        String check = poker.check(cards);

        assertThat(check).isEqualTo("High Card: CLUB JACK");
    }

    @Test
    void shouldFindPairWithTheSameRank() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.CLUB, Rank.TWO),
                new Card(Suit.DIAMOND, Rank.TWO),
                new Card(Suit.CLUB, Rank.FIVE),
                new Card(Suit.CLUB, Rank.JACK),
                new Card(Suit.CLUB, Rank.SEVEN));
        String check = poker.check(cards);

        assertThat(check).isEqualTo("Pair: TWO");
    }
}