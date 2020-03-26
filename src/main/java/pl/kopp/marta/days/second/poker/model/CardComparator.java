package pl.kopp.marta.days.second.poker.model;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getRank().getValue() < c2.getRank().getValue()) {
            return -1;
        }
        if (c1.getRank().getValue() > c2.getRank().getValue()) {
            return 1;
        }
        return Integer.compare(c1.getSuit().getValue(), c2.getSuit().getValue());
    }
}
