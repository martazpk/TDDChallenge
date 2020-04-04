package pl.kopp.marta.days.third.romannumerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralsTest {
private RomanNumerals romanNumerals;

    @BeforeEach
    void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @ParameterizedTest
    @CsvSource({"1,I", "2,II", "3,III"})
    void shouldReturnMultipleOfIWhenNumberIsGiven(int input, String expected) {
        String romanNumeral = romanNumerals.toRoman(input);

        assertThat(romanNumeral).isEqualTo(expected);
    }
    @Test
    void shouldReturnIVWhen4IsGiven() {
        String romanNumeral = romanNumerals.toRoman(4);

        assertThat(romanNumeral).isEqualTo("IV");
    }

    @Test
    void shouldReturnVWhen5IsGiven() {
        String romanNumeral = romanNumerals.toRoman(5);

        assertThat(romanNumeral).isEqualTo("V");
    }

    @ParameterizedTest
    @CsvSource({"6,VI", "7,VII", "8,VIII"})
    void shouldReturnVIWhen6IsGiven(int input, String expected) {
        String romanNumeral = romanNumerals.toRoman(input);

        assertThat(romanNumeral).isEqualTo(expected);
    }

    @Test
    void shouldReturnIXWhen9IsGiven() {
        String romanNumeral = romanNumerals.toRoman(9);

        assertThat(romanNumeral).isEqualTo("IX");
    }

    @Test
    void shouldReturnXWhen10IsGiven() {
        String romanNumeral = romanNumerals.toRoman(10);

        assertThat(romanNumeral).isEqualTo("X");
    }

    @ParameterizedTest
    @CsvSource({"11,XI", "12,XII", "13,XIII"})
    void shouldReturnCorrectLiteralWhen11To13IsGiven(int input, String expected) {
        String romanNumeral = romanNumerals.toRoman(input);

        assertThat(romanNumeral).isEqualTo(expected);
    }
}