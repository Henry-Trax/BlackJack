import BlackJack.Card;
import BlackJack.Deck;

import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck(1);

        for (int i = 0; i < 52; i++) {

            Card card = deck.drawCard(false);

            for (String line : card.getSprite()) {

                System.out.println(line);

            }

        }

        scanner.nextLine();
    }

}
