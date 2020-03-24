package pl.kopp.marta.days.first.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    private static final String THREE_WORD = "Fizz";
    private static final String FIVE_WORD = "Buzz";

    public List<String> game(int range) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            String element = "";

            if (isDivisibleByThree(i) || hasNumber(i, "3")) {
                element = element + THREE_WORD;
            }
            if (isDivisibleByFive(i) || hasNumber(i, "5")) {
                element = element + FIVE_WORD;
            }
            if (element.isEmpty()) {
                element = String.valueOf(i);
            }
            result.add(element);
        }
        return result;
    }

    private boolean hasNumber(int i, String number) {
            String numberAsString = String.valueOf(i);
            return numberAsString.contains(number);
    }

    private boolean isDivisibleByFive(int i) {
        return i % 5 == 0;
    }

    private boolean isDivisibleByThree(int i) {
        return i % 3 == 0;
    }
}
