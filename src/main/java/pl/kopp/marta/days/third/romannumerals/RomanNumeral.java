package pl.kopp.marta.days.third.romannumerals;

import lombok.Getter;

@Getter
public enum RomanNumeral {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    XC(90),
    C(100),
    L(50);

    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }
}
