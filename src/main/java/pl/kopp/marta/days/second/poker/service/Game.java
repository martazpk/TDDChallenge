package pl.kopp.marta.days.second.poker.service;

import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.Deck;
import pl.kopp.marta.days.second.poker.model.PokerResultSummary;

import java.util.List;

public class Game {
    private static final String ANNOUNCEMENT_OF_THE_WINNER = "%s  wins. - with %s";
    private Poker poker;
    private String player1;
    private String player2;

    public Game(String player1, String player2) {
        this.poker = new PokerHands();
        this.player1 = player1;
        this.player2 = player2;
    }

    public String game() {
        Deck deck = createNewDeck();
        deck.shuffle();

        List<Card> first = deck.getCards(5);
        List<Card> second = deck.getCards(5);

        return getWin(first, second);
    }

    private Card getHighestCard(List<Card> cards) {
        List<Card> sort = poker.sort(cards);
        return sort.get(4);
    }

    private Deck createNewDeck() {
        return new Deck();
    }

    private String getWin(List<Card> first, List<Card> second) {
        PokerResultSummary player1Result = poker.check(first);
        PokerResultSummary player2Result = poker.check(second);


        if (player1Result.getResult().getScore() > player2Result.getResult().getScore()) {
            return String.format(ANNOUNCEMENT_OF_THE_WINNER, player1, player1Result.toString());
        } else if (player1Result.getResult().getScore() < player2Result.getResult().getScore()) {
            return String.format(ANNOUNCEMENT_OF_THE_WINNER, player2, player2Result.toString());
        } else {
            return compareTheHighestCards(first, second);
        }
    }

    private String compareTheHighestCards(List<Card> first, List<Card> second) {
        Card whiteCard = getHighestCard(first);
        Card blackCard = getHighestCard(second);

        if (whiteCard.getRank().getValue() > blackCard.getRank().getValue()) {
            return String.format(ANNOUNCEMENT_OF_THE_WINNER, player1, poker.check(first).toString());
        } else {
            return String.format(ANNOUNCEMENT_OF_THE_WINNER, player2, poker.check(second).toString());
        }
    }
}
