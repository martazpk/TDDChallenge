package pl.kopp.marta.days.second.poker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

   public Deck() {
        this.cards = new Stack<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank: Rank.values()) {
                Card card = new Card(suit,rank);
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getCards(int numberOfCards) {
       List<Card> gettingCards = new ArrayList<>();
       for(int i = 1; i<= numberOfCards ; i++){
           gettingCards.add(cards.pop());
       }
        return gettingCards;
    }
}