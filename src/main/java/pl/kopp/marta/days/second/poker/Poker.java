package pl.kopp.marta.days.second.poker;


import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.CardComparator;
import pl.kopp.marta.days.second.poker.model.Deck;
import pl.kopp.marta.days.second.poker.model.Rank;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class Poker {
    private Deck deck;

    public Poker() {
        this.deck = new Deck();
        deck.shuffle();
    }


    public List<Card> game() {
        return deck.getCards(5);
    }

    public String check(List<Card> cards) {
        List<Card> sort = sort(cards);

        List<Card> pairs = findPairs(sort);
        if(pairs.size()> 1){
            return "Two Pairs: " + pairs.get(1).getRank() +" and " + pairs.get(0).getRank();
        }

        if (pairs.size() == 1) {
            return "Pair: " + pairs.get(0).getRank();
        }
        return "High Card: " + sort.get(4);
    }

    private List<Card> findPairs(List<Card> cards) {
        List<Card> cardsWithPairs = new ArrayList<>();
        Map<Rank, List<Card>> collect = cards.stream().collect(groupingBy(Card::getRank));
        for (Rank rank: collect.keySet()) {
            if(collect.get(rank).size() > 1){
                cardsWithPairs.add(collect.get(rank).get(0));
            }
        }
        return cardsWithPairs;
    }

    private List<Card> sort(List<Card> cards) {
        return cards.stream().sorted(new CardComparator()).collect(Collectors.toList());
    }
}
