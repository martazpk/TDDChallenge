package pl.kopp.marta.days.second.poker;


import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.CardComparator;
import pl.kopp.marta.days.second.poker.model.Deck;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Poker {
    private Deck deck;

    public Poker() {
        this.deck = new Deck();
        deck.shuffle();
    }


    public List<Card> game(){
      return deck.getCards(5);
    }

    public String check(List<Card> cards){
        List<Card> sortedCards = sort(cards);

        return "High Card: " + cards.get(4);
    }

    private List<Card> sort(List<Card> cards) {

        return cards.stream().sorted(new CardComparator()).collect(Collectors.toList());
    }
}
