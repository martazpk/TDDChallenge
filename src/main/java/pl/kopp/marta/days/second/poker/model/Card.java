package pl.kopp.marta.days.second.poker.model;

import lombok.Getter;

@Getter
public class Card{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return suit + " " + rank;
    }
}