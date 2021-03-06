package pl.kopp.marta.days.third.romannumerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumeralsTest {
    private RomanNumerals romanNumerals;

    @BeforeEach
    void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @ParameterizedTest
    @CsvSource({
            "1,I",
            "2,II",
            "3,III",
            "4,IV",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",
            "9,IX",
            "10,X",
            "11,XI",
            "12,XII",
            "13,XIII",
            "40,XL",
            "50,L",
            "90,XC",
            "100,C",
            "400,CD",
            "500,D",
            "900,CM",
            "1000,M"
    })
    void shouldReturnCorrectRomanNumeralIWhenNumberIsGiven(int input, String expected) {
        String romanNumeral = romanNumerals.toRoman(input);

        assertThat(romanNumeral).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3001})
    void shouldThrowExceptionWhenNumberIsOutOfBound(int input) {

        assertThrows(IllegalArgumentException.class, () -> romanNumerals.toRoman(input));
    }
}