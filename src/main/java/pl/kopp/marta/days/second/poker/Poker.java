package pl.kopp.marta.days.second.poker;

import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.Deck;

import java.util.ArrayList;
import java.util.List;

public class Poker {

    public List<Card> start() {
        Deck deck = new Deck();
        return deck.getCards(5);
    }
}
