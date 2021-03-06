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
    void shouldReturnTwoSequenceNumbers() {
        List<String> result = fizzBuzz.game(100);

        assertThat(result.get(0)).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("2");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 8, 11, 98})
    void shouldReturnFizzWhenNumberIsDivisibleByThree(int elementPosition) {
        List<String> result = fizzBuzz.game(100);

        assertThat(result.get(elementPosition)).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9, 49, 99})
    void shouldReturnBuzzWhenNumberIsDivisibleByFive(int elementPosition) {
        List<String> result = fizzBuzz.game(100);

        assertThat(result.get(elementPosition)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {14, 29, 44, 89})
    void shouldReturnFizzBuzzWhenNumberIsDivisibleByThreeAndFive(int elementPosition) {
        List<String> result = fizzBuzz.game(100);

        assertThat(result.get(elementPosition)).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {30, 62, 92})
    void shouldReturnFizzWhenNumberHasThreeInIt(int elementPosition) {
        List<String> result = fizzBuzz.game(100);

        assertThat(result.get(elementPosition)).isEqualTo("Fizz");
    }

    @Test
    void shouldAddBuzzToResultWhenNumberHasFiveInIt() {
        List<String> result = fizzBuzz.game(100);

        assertThat(result.get(50)).isEqualTo("FizzBuzz");
    }
}