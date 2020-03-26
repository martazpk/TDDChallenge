package pl.kopp.marta.days.second.poker;


import pl.kopp.marta.days.second.poker.model.Card;
import pl.kopp.marta.days.second.poker.model.CardComparator;
import pl.kopp.marta.days.second.poker.model.Deck;
import pl.kopp.marta.days.second.poker.model.Rank;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

        Optional<Card> pairOptional = findPair(cards);
        if (pairOptional.isPresent()) {
            return "Pair: " + pairOptional.get().getRank();
        }
        return "High Card: " + sort.get(4);
    }

    private Optional<Card> findPair(List<Card> cards) {
        Map<Rank, List<Card>> collect = cards.stream().collect(groupingBy(Card::getRank));
        for (Rank rank: collect.keySet()) {
            if(collect.get(rank).size() > 1){
                return Optional.of(collect.get(rank).get(0));
            }
        }
        return Optional.empty();
    }


    private List<Card> sort(List<Card> cards) {
        return cards.stream().sorted(new CardComparator()).collect(Collectors.toList());
    }
}
