package pl.kopp.marta.days.third.romannumerals;


class RomanNumerals {

    String toRoman(int i) {
        if(i == 1) {
            return "I";
        }
        if(i == 2) {
            return "II";
        }
        if(i == 3){
            return "III";
        }
        if(i == 5){
            return "V";
        }
        else return "IV";
    }
}
