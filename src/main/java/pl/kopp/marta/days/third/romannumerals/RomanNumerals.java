package pl.kopp.marta.days.third.romannumerals;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RomanNumerals {

    String toRoman(int i) {
        List<RomanNumeral> numerals = Arrays.stream(RomanNumeral.values()).collect(Collectors.toList());

        String result = "";
        for (RomanNumeral r: numerals) {
            if(i == r.getValue()) {
                return result.concat(r.toString());
            }
        }
        if (i <= 3) {
            result = addOne(i, result);

        } else if (i < 9) {
            result = result.concat(RomanNumeral.V.toString());
            result = addOne(i - 5, result);
        } else {
            result = result.concat(RomanNumeral.X.toString());
            result = addOne(i - 10, result);
        }
        return result;
    }

    private String addOne(int i, String result) {
        for (int j = 1; j <= i; j++) {
            result = result.concat(RomanNumeral.I.toString());
        }
        return result;
    }
}
