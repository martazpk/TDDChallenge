package pl.kopp.marta.days.second.poker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getCards(int numberOfCards) {
        List<Card> gettingCards = new ArrayList<>();
        for (int i = 1; i <= numberOfCards; i++) {
            gettingCards.add(pop());
        }
        return gettingCards;
    }

    public Card pop() {
        return cards.get(cards.size() - 1);
    }

    public void shuffle() {
        for (int i = 0; i < 50; i++) {
            swapTwoCards();
        }
    }

    private void swapTwoCards() {
        Random random = new Random();
        int i = random.nextInt(cards.size());
        int j = random.nextInt(cards.size());
        Card card1 = cards.get(i);
        Card card2 = cards.get(j);

        cards.add(i, card2);
        cards.add(j, card1);
    }
}