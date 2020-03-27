package pl.kopp.marta.days.second.poker;


import pl.kopp.marta.days.second.poker.model.*;

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

    public PokerResult check(List<Card> cards) {
        List<Card> sort = sort(cards);

        Optional<Card> straightFlush = findStraightFlush(sort);
        if (straightFlush.isPresent()) {
            return PokerResult.STRAIGHT_FLUSH;
        }

        Optional<Card> fourOfTheKind = findFour(sort);
        if (fourOfTheKind.isPresent()) {
            return PokerResult.FOUR_OF_KIND;
        }
        List<Card> fullHouse = findFullHouse(sort);
        if (fullHouse.size() == 2) {
            return PokerResult.FULL_HOUSE;
        }

        Optional<Card> theHighestInFlush = findFlush(sort);
        if (theHighestInFlush.isPresent()) {
            return PokerResult.FLUSH;
        }

        Optional<Card> theHighestInStraight = findStraight(sort);
        if (theHighestInStraight.isPresent()) {
            return PokerResult.STRAIGHT;
        }

        List<Card> three = findThree(sort);
        if (three.size() == 1) {
            return PokerResult.THREE_OF_KIND;
        }
        List<Card> pairs = findPairs(sort);
        if (pairs.size() > 1) {
            return PokerResult.TWO_PAIRS;
        }
        if (pairs.size() == 1) {
            return PokerResult.PAIR;
        }
        return PokerResult.HIGH_CARD;
    }

    private Optional<Card> findStraightFlush(List<Card> sort) {
        if (hasTheSameSuit(sort) && hasConsecutiveRank(sort)) {
            return Optional.of(sort.get(4));
        }
        return Optional.empty();
    }

    private Optional<Card> findFour(List<Card> cards) {
        Map<Rank, List<Card>> collect = cards.stream().collect(groupingBy(Card::getRank));
        for (Rank rank : collect.keySet()) {
            if (collect.get(rank).size() == 4) {
                return Optional.of(collect.get(rank).get(0));
            }
        }
        return Optional.empty();
    }


    private List<Card> findFullHouse(List<Card> sort) {
        List<Card> three = findThree(sort);
        if (!three.isEmpty()) {
            List<Card> otherRank = sort.stream().filter(c -> !(three.get(0).getRank().equals(c.getRank()))).collect(Collectors.toList());
            if (otherRank.get(0).getRank().equals(otherRank.get(1).getRank())) {
                three.add(otherRank.get(0));
                return three;
            }
        }

        return Collections.emptyList();
    }

    private Optional<Card> findFlush(List<Card> sort) {
        if (hasTheSameSuit(sort)) {
            return Optional.of(sort.get(4));
        }
        return Optional.empty();
    }

    private Optional<Card> findStraight(List<Card> sort) {
        if (hasConsecutiveRank(sort)) {
            return Optional.of(sort.get(4));
        }
        return Optional.empty();
    }

    private boolean hasConsecutiveRank(List<Card> sort) {
        int first = sort.get(0).getRank().getValue();
        int second = sort.get(1).getRank().getValue();
        int third = sort.get(2).getRank().getValue();
        int fourth = sort.get(3).getRank().getValue();
        int fifth = sort.get(4).getRank().getValue();
        return second == first + 1 && third == second + 1 && fourth == third + 1 && fifth == fourth + 1;
    }

    private boolean hasTheSameSuit(List<Card> sort) {
        Suit firstSuit = sort.get(0).getSuit();
        return sort.stream().allMatch(c -> c.getSuit().equals(firstSuit));
    }

    private List<Card> findThree(List<Card> cards) {
        List<Card> three = new ArrayList<>();
        Map<Rank, List<Card>> collect = cards.stream().collect(groupingBy(Card::getRank));
        for (Rank rank : collect.keySet()) {
            if (collect.get(rank).size() == 3) {
                three.add(collect.get(rank).get(0));
            }
        }
        return three;
    }

    private List<Card> findPairs(List<Card> cards) {
        List<Card> cardsWithPairs = new ArrayList<>();
        Map<Rank, List<Card>> collect = cards.stream().collect(groupingBy(Card::getRank));
        for (Rank rank : collect.keySet()) {
            if (collect.get(rank).size() > 1) {
                cardsWithPairs.add(collect.get(rank).get(0));
            }
        }
        return cardsWithPairs;
    }

    private List<Card> sort(List<Card> cards) {
        return cards.stream().sorted(new CardComparator()).collect(Collectors.toList());
    }
}
