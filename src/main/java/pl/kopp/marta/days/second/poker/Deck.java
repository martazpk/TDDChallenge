package pl.kopp.marta.days.second.poker;

import java.util.ArrayList;
import java.util.List;

class Deck {
    private List<Card> cards;

    Deck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank: Rank.values()) {
                Card card = new Card(suit,rank);
                cards.add(card);
            }
        }
    }

    List<Card> getCards() {
        return cards;
    }
}