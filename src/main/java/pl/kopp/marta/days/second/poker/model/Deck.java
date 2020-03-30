package pl.kopp.marta.days.second.poker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        for (int i = 0; i < numberOfCards; i++) {
            Card pop = pop();
            gettingCards.add(pop);
            this.getCards().remove(pop);
        }
        return gettingCards;
    }

    private Card pop() {
        Card card = this.getCards().get(this.getCards().size()-1);
        this.getCards().remove(card);
        return card;
    }

    public void shuffle(int times) {
        for (int i = 0; i < times; i++) {
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

        cards.remove(card2);
        cards.remove(card1);
    }
}