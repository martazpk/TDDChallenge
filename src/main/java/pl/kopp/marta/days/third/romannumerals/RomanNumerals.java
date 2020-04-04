package pl.kopp.marta.days.third.romannumerals;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RomanNumerals {

    String toRoman(int number) {
        if(numberIsOutOfBound(number)){
            throw new IllegalArgumentException(number + " is out of bound (0, 3000>");
        }

        List<RomanNumeral> numerals = Arrays.stream(RomanNumeral.values()).collect(Collectors.toList());
        String result = "";
        int index = numerals.size()-1;

        while (number > 0 && index >= 0 ) {
                RomanNumeral current = numerals.get(index);
                if (current.getValue() <= number) {
                    result = result.concat(current.toString());
                    number -= current.getValue();
                }
                else {
                    index--;
                }
        }
        return result;
    }

    private boolean numberIsOutOfBound(int number) {
      return   number < 1 || number > 3000;
    }
}
