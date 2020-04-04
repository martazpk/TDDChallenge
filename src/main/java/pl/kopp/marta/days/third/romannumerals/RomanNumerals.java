package pl.kopp.marta.days.third.romannumerals;


class RomanNumerals {
    private static final String ONE = "I";
    private static final String FIVE = "V";
    private static final String FOUR = "IV";
    private static final String NINE = "IX";
    private static final String TEN = "X";

    String toRoman(int i) {
        String result = "";

        if (i <= 3) {
            result = addOne(i, result);
        } else if (i == 4) {
            result = result.concat(FOUR);

        } else if (i == 5) {
            result = result.concat(FIVE);
        } else if (i < 9) {
            result = result.concat(FIVE);
            result = addOne(i - 5, result);
        } else if (i < 10) {
            result = result.concat(NINE);
        } else if (i == 10) {
            result = result.concat(TEN);
        } else {
            result = result.concat(TEN);
            result = addOne(i - 10, result);
        }
        return result;
    }

    private String addOne(int i, String result) {
        for (int j = 1; j <= i; j++) {
            result = result.concat(ONE);
        }
        return result;
    }
}
