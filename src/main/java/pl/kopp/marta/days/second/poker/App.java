package pl.kopp.marta.days.second.poker;

public class App {
    public static void main(String[] args) {
        Game game = new Game("White", "Black");

        String result = game.game();

        System.out.println(result);
    }
}
