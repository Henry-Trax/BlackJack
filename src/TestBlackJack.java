import BlackJack.Card;
import BlackJack.Deck;
import BlackJack.Hand;
import Util.Displays;

import java.util.Scanner;

public class TestBlackJack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deck deck = new Deck(1);

        Hand hand = new Hand("Player")

        Displays.displayCards(hand);


        scanner.nextLine();
    }

    public static void testDeckDrawing() {


        Deck deck = new Deck(1);

        for (int i = 0; i < 52; i++) {
            Card card = deck.drawCard(true);

            for (String line : card.getSprite()) {
                System.out.println(line);

            }

        }
    }

    public static void testCardCounting() {
        Deck deck = new Deck(1);

        for (int i = 0; i < 52; i++) {
            if (true) {
                Card card = deck.drawCard(true);
            }else {
                Card card = deck.drawCard(false);
            }

        }

        System.out.println(deck.cardCountAverage());

    }

    public static void testShuffle() {
        Deck deck = new Deck(1);
        deck.shuffle();

        System.out.println();
    }
}
