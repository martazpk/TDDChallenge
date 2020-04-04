package pl.kopp.marta.days.third.romannumerals;


class RomanNumerals {
    private static final String ONE = "I";
    private static final String FIVE = "V";
    private static final String FOUR = "IV";

    String toRoman(int i) {
        String result = "";

        if (i <= 3) {
            result = addOne(i, result);
        } else if (i == 4) {
            result = result.concat(FOUR);

        } else if (i ==5){
            result = result.concat(FIVE);
        } else {
            result = result.concat(FIVE);
            result = addOne(i-5, result);
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
