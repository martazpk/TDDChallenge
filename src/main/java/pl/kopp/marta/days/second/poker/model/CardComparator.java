package pl.kopp.marta.days.second.poker.model;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getSuit().getValue() < o2.getSuit().getValue()) {
            return -1;
        }
        if (o1.getSuit().getValue() > o2.getSuit().getValue()) {
            return 1;
        }
        return Integer.compare(o1.getRank().getValue(), o2.getRank().getValue());
    }
}
