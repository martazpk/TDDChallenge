package pl.kopp.marta.days.second.poker.model;

import lombok.Getter;

@Getter
public enum PokerResult {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_KIND(8),
    STRAIGHT_FLUSH(9);

    private int score;

    PokerResult(int score) {
        this.score = score;
    }
}




