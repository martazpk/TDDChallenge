package pl.kopp.marta.days.third.romannumerals;


public class RomanNumerals {

    public String toRoman(int i) {
        if(i == 1){
            return "I";
        }
        if(i == 2){
            return "II";
        }
        else return "III";
    }
}
