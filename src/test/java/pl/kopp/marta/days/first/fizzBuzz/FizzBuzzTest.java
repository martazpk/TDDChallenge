package pl.kopp.marta.days.first.fizzBuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void shouldReturnOneForOnePieceList() {
        List<String> numbers = fizzBuzz.game(100);

        assertThat(numbers.get(0)).isEqualTo("1");
    }

    @Test
    void shouldAddTwoSequenceNumbersWhenRangeIsTwo() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> numbers = fizzBuzz.game(100);

        assertThat(numbers.get(0)).isEqualTo("1");
        assertThat(numbers.get(1)).isEqualTo("2");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 8, 11, 98})
    void shouldReturnFizzWhenNumberIsDivisibleByThree(int elementPosition) {
        List<String> result = fizzBuzz.game(100);

        assertThat(result.get(elementPosition)).isEqualTo("Fizz");
    }

}