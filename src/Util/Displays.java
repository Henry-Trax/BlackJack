package Util;

import BlackJack.Card;

import java.util.ArrayList;

public class Displays {

    public static void clearScreen() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception IOException) {
            System.out.println("IOException");
        }
    }

    public static void displayCards(Hand hand) {
        clearScreen();


        String bracket = getBracket(hand.getCards);
        System.out.println(bracket);

        System.out.printf("|%s%-" + (hand.getCards.length * 8 - 6) + "s|\n", hand.getName, "'s Hand:");
        showLineByLine(hand.getCards);

        System.out.println(bracket);



    }

    private static void showLineByLine(Card[] cards) {
        for (int i = 0; i < 5; i++) {
            System.out.print("|");

            for (Card card : cards) {
                System.out.print(card.getSprite()[i] + " ");
            }

            System.out.println("|");
        }
    }

    private static String getBracket(Card[] cards) {

        String bracket = "O";
        int boardLength = 0;

        boardLength = cards.length * 8;

        for (int i = 0; i < boardLength; i++) {
            bracket += "=";
        }
        bracket += "O";
        return bracket;
    }

}
