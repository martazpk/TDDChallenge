package pl.kopp.marta.days.first.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    public List<String> game(int range) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <=range ; i++) {
            String element = "";
            
            if(isDivisibleByThree(i)){
                element = element + "Fizz";
            }
            if(isDivisibleByFive(i)){
                element = element + "Buzz";
            }
            if(element.isEmpty()) {
                element = String.valueOf(i);
            }
            result.add(element);
        }
        return result;
    }

    private boolean isDivisibleByFive(int i) {
        return i % 5 == 0;
    }

    private boolean isDivisibleByThree(int i) {
        return i % 3 == 0;
    }
}
