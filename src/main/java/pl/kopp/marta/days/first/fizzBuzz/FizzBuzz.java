package pl.kopp.marta.days.first.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    public List<String> game(int range) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <=range ; i++) {
            if(isDivisibleByThree(i)){
                result.add("Fizz");
            }
            String numberAsString = String.valueOf(i);
            result.add(numberAsString);
        }
        return result;
    }

    private boolean isDivisibleByThree(int i) {
        return i == 3;
    }
}
