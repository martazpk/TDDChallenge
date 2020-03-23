package pl.kopp.marta.days.first.fizzBuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<String> numbers = fizzBuzz.game(1);

        assertThat(numbers.get(0)).isEqualTo("1");
    }

    @Test
    void shouldAddTwoSequenceNumbersWhenRangeIsTwo() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> numbers = fizzBuzz.game(2);

        assertThat(numbers.get(0)).isEqualTo("1");
        assertThat(numbers.get(1)).isEqualTo("2");
    }

    @Test
    void shouldReturnFizzWhenNumberIsDivisibleByThree() {
        List<String> result = fizzBuzz.game(3);

        assertThat(result.get(2)).isEqualTo("Fizz");
    }
}