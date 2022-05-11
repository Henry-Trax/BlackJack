package blackjack;

import blackjack.cards.DealerHand;
import blackjack.cards.Deck;
import blackjack.cards.PlayerHand;
import blackjack.menus.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static Scanner scanner = new Scanner(System.in);
    private static Deck deck;
    private static ArrayList<PlayerHand> playerHands = new ArrayList<PlayerHand>();
    private static ArrayList<DealerHand> dealerHands = new ArrayList<DealerHand>();

    public static void run() {

        Menu.start();

    }

}
