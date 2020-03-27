package pl.kopp.marta.days.second.poker;


import pl.kopp.marta.days.second.poker.model.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


class Poker {

    String game() {
        Deck deck = createNewDeck();
        deck.shuffle();

        List<Card> player1 = deck.pokerHand(5);
        List<Card> player2 = deck.pokerHand(5);

        return getWin(player1, player2);
    }

    private String getWin(List<Card> player1, List<Card> player2) {
        PokerResultSummary whitePokerResultSummary = check(player1);
        PokerResultSummary blackPokerResultSummary = check(player2);


        if(whitePokerResultSummary.getResult().getScore() > blackPokerResultSummary.getResult().getScore()){
            return "White wins. - with " + whitePokerResultSummary.toString();
        } else if (whitePokerResultSummary.getResult().getScore() < blackPokerResultSummary.getResult().getScore()){
            return "Black wins. - with " + blackPokerResultSummary.toString();
        } else {
            return compareTheHighestCards(player1, player2);
        }
    }

    private String compareTheHighestCards(List<Card> player1, List<Card> player2) {
        Card whiteCard = getHighestCard(player1);
        Card blackCard = getHighestCard(player2);

        if(whiteCard.getRank().getValue() > blackCard.getRank().getValue()){
            return "White wins. - with " + check(player1).toString();
        } else {
            return "Black wins. - with " + check(player2).toString();
        }
    }

    private Card getHighestCard(List<Card> cards) {
        List<Card> sort = sort(cards);
        return sort.get(4);
    }

    private Deck createNewDeck() {
        return new Deck();
    }

    PokerResultSummary check(List<Card> cards) {
        List<Card> sort = sort(cards);

        Optional<Card> straightFlush = findStraightFlush(sort);
        if (straightFlush.isPresent()) {
            return new PokerResultSummary(PokerResult.STRAIGHT_FLUSH, straightFlush.get().toString());
        }

        Optional<Card> fourOfTheKind = findFour(sort);
        if (fourOfTheKind.isPresent()) {
            String details = fourOfTheKind.toString();
            return new PokerResultSummary(PokerResult.FOUR_OF_KIND, details);
        }
        List<Card> fullHouse = findFullHouse(sort);
        if (fullHouse.size() == 2) {
            String details = fullHouse.get(1).getRank().toString() + " over " + fullHouse.get(0).getRank().toString();
            return new PokerResultSummary(PokerResult.FULL_HOUSE, details);
        }

        Optional<Card> theHighestInFlush = findFlush(sort);
        if (theHighestInFlush.isPresent()) {
            String details= theHighestInFlush.get().getRank().toString();
            return new PokerResultSummary(PokerResult.FLUSH, details);
        }

        Optional<Card> theHighestInStraight = findStraight(sort);
        if (theHighestInStraight.isPresent()) {
            String details = theHighestInStraight.get().getRank().toString();
            return new PokerResultSummary(PokerResult.STRAIGHT, details);
        }

        List<Card> three = findThree(sort);
        if (three.size() == 1) {
            String details = three.get(0).getRank().toString();
            return new PokerResultSummary(PokerResult.THREE_OF_KIND, details);
        }
        List<Card> pairs = findPairs(sort);
        if (pairs.size() > 1) {
            String details = pairs.get(1).getRank().toString() + " over " + pairs.get(0).getRank().toString();
            return new PokerResultSummary(PokerResult.TWO_PAIRS, details);
        }
        if (pairs.size() == 1) {
            String details = pairs.get(0).getRank().toString();
            return new PokerResultSummary(PokerResult.PAIR, details);
        }
        String theHighestCard = sort.get(4).getRank().toString();
        return new PokerResultSummary(PokerResult.HIGH_CARD, theHighestCard);
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
            List<Card> otherRank = sort.stream()
                    .filter(c -> !(three.get(0).getRank().equals(c.getRank())))
                    .collect(Collectors.toList());
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

    private boolean hasConsecutiveRank(List<Card> sortCards) {
        for (int i = 0; i < sortCards.size() - 1; i++) {
            int rank = sortCards.get(i).getRank().getValue();
            int nextRank = sortCards.get(i + 1).getRank().getValue();
            if (rank != nextRank - 1) {
                return false;
            }
        }
        return true;
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
        for (Rank rank : collect.keySet())
            if (collect.get(rank).size() > 1) {
                cardsWithPairs.add(collect.get(rank).get(0));
            }
        return cardsWithPairs;
    }

    public List<Card> sort(List<Card> cards) {
        return cards.stream().sorted(new CardComparator()).collect(Collectors.toList());
    }
}
