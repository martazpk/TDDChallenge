package pl.kopp.marta.days.second.poker;

import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.CardComparator;
import pl.kopp.marta.days.second.poker.model.PokerResultSummary;

import java.util.List;
import java.util.stream.Collectors;

public interface Poker {
    PokerResultSummary check(List<Card> cards);

    default List<Card> sort(List<Card> cards) {
        return cards.stream().sorted(new CardComparator()).collect(Collectors.toList());
    }
}
