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
    @CsvSource({"1,I", "2,II"})
    void shouldReturnMultipleOfIWhenNumberIsGiven(int input, String expected) {
        String romanNumeral = romanNumerals.toRoman(input);

        assertThat(romanNumeral).isEqualTo(expected);
    }
}