package pl.kopp.marta.days.third.romannumerals;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RomanNumerals {

    String toRoman(int number) {
        List<RomanNumeral> numerals = Arrays.stream(RomanNumeral.values()).collect(Collectors.toList());
        String result = "";

        int i = numerals.size()-1;

        while (number > 0 && i>= 0 ) {
                RomanNumeral current = numerals.get(i);
                if (current.getValue() <= number) {
                    result = result.concat(current.toString());
                    number -= current.getValue();
                }
                else {
                    i--;
                }
        }
        return result;
    }
}
