package pl.kopp.marta.days.second.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.PokerResult;
import pl.kopp.marta.days.second.poker.model.Rank;
import pl.kopp.marta.days.second.poker.model.Suit;
import pl.kopp.marta.days.second.poker.service.PokerHands;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PokerHandsTest {
    private PokerHands pokerHands;

    @BeforeEach
    void setUp() {
        pokerHands = new PokerHands();
    }

    @Test
    void shouldReturnTheHighestCard() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.DIAMOND, Rank.TWO),
                new Card(Suit.CLUB, Rank.FOUR),
                new Card(Suit.CLUB, Rank.FIVE),
                new Card(Suit.CLUB, Rank.JACK),
                new Card(Suit.CLUB, Rank.SEVEN));
        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.HIGH_CARD);
    }

    @Test
    void shouldFindPairWithTheSameRank() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.CLUB, Rank.TWO),
                new Card(Suit.DIAMOND, Rank.TWO),
                new Card(Suit.CLUB, Rank.FIVE),
                new Card(Suit.CLUB, Rank.JACK),
                new Card(Suit.CLUB, Rank.SEVEN));
        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.PAIR);
    }

    @Test
    void shouldFindTwoPairsWithTheSameRank() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.CLUB, Rank.TWO),
                new Card(Suit.DIAMOND, Rank.TWO),
                new Card(Suit.CLUB, Rank.FIVE),
                new Card(Suit.HEART, Rank.FIVE),
                new Card(Suit.CLUB, Rank.SEVEN));
        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.TWO_PAIRS);
    }

    @Test
    void shouldReturnThreeCardsWithTheSameRank() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.DIAMOND, Rank.FIVE),
                new Card(Suit.DIAMOND, Rank.NINE),
                new Card(Suit.CLUB, Rank.FIVE),
                new Card(Suit.HEART, Rank.FIVE),
                new Card(Suit.CLUB, Rank.SEVEN));
        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.THREE_OF_KIND);
    }

    @Test
    void shouldReturnStraight() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.HEART, Rank.FIVE),
                new Card(Suit.DIAMOND, Rank.SIX),
                new Card(Suit.DIAMOND, Rank.SEVEN),
                new Card(Suit.DIAMOND, Rank.EIGHT),
                new Card(Suit.DIAMOND, Rank.NINE));

        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.STRAIGHT);
    }

    @Test
    void shouldReturnFlush() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.DIAMOND, Rank.FIVE),
                new Card(Suit.DIAMOND, Rank.SIX),
                new Card(Suit.DIAMOND, Rank.SEVEN),
                new Card(Suit.DIAMOND, Rank.EIGHT),
                new Card(Suit.DIAMOND, Rank.JACK));

        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.FLUSH);
    }
    @Test
    void shouldReturnFullHouse() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.DIAMOND, Rank.FIVE),
                new Card(Suit.HEART, Rank.FIVE),
                new Card(Suit.DIAMOND, Rank.KING),
                new Card(Suit.HEART, Rank.KING),
                new Card(Suit.CLUB, Rank.KING));

        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.FULL_HOUSE);
    }
    @Test
    void shouldReturnFourOfTheKind() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.DIAMOND, Rank.FIVE),
                new Card(Suit.SPADE, Rank.KING),
                new Card(Suit.DIAMOND, Rank.KING),
                new Card(Suit.HEART, Rank.KING),
                new Card(Suit.CLUB, Rank.KING));

        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.FOUR_OF_KIND);
    }

    @Test
    void shouldReturnStraightFlush() {
        List<Card> cards = Arrays.asList(
                new Card(Suit.DIAMOND, Rank.SEVEN),
                new Card(Suit.DIAMOND, Rank.EIGHT),
                new Card(Suit.DIAMOND, Rank.NINE),
                new Card(Suit.DIAMOND, Rank.TEN),
                new Card(Suit.DIAMOND, Rank.JACK));

        PokerResult result = pokerHands.check(cards).getResult();

        assertThat(result).isEqualTo(PokerResult.STRAIGHT_FLUSH);
    }
}