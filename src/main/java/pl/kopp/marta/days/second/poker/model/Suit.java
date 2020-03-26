package pl.kopp.marta.days.second.poker.model;

public enum Suit{
    CLUB(4),
    DIAMOND(3),
    HEART(2),
    SPADE(1);

    private int value;

    Suit(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
