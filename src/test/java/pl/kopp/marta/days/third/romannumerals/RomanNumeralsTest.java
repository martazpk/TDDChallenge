package pl.kopp.marta.days.third.romannumerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RomanNumeralsTest {

    @Test
    void shouldReturnIWhenOneAsIntIsGiven() {
        RomanNumerals romanNumerals = new RomanNumerals();
        String romanNumeral = romanNumerals.toRoman(1);

        assertThat(romanNumeral).isEqualTo("I");
    }
}