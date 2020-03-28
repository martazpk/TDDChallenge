package pl.kopp.marta.days.second.poker.model;

import lombok.Getter;

@Getter
public class PokerResultSummary {
    private PokerResult result;
    private String description;

    public PokerResultSummary(PokerResult result, String description) {
        this.result = result;
        this.description = description;
    }

    @Override
    public String toString() {
        String resultFormat = result.toString().toLowerCase().replace('_', ' ');
        return  resultFormat + ": " +
                 description.toLowerCase()
                ;
    }
}
