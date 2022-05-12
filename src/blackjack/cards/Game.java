package blackjack.cards;


import blackjack.menus.Settings;
import blackjack.util.Displays;
import blackjack.util.UserInterface;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static final Scanner scanner = new Scanner(System.in);
    private Deck deck;
    private ArrayList<PlayerHand> playerHands = new ArrayList<PlayerHand>();
    private int playerCount = 0;
    private DealerHand dealerHands;
    private int round = 0;


    public Game() {
        deck = new Deck(Settings.getAceValue(), Settings.getDecksInUse());
    }

    public void run() {

        deck = new Deck(Settings.getAceValue(), Settings.getDecksInUse());
        instantiateHands();

        while (deck.size() > 0) {

            do {

                System.out.println(deck.size());
                deck.drawCard();

            } while (!isEndOfRound());

            checkWinners();
            emptyHands();
        }
    }

    private void checkWinners() {
    }

    private boolean isEndOfRound() {
        boolean bool = true;

        for (PlayerHand playerHand : playerHands) {
            if ("inplay".equals(playerHand.state)) {
                bool = false;
            }
        }


        if (deck.size() <= 0) bool = true;

        return bool;
    }

    private boolean turnEnd() {



        return true;
    }

    private void emptyHands() {
        for (PlayerHand playerHand : playerHands) {
            playerHand.emptyHand();
        }

        dealerHands.emptyHand();
    }

    private void turnStart() {
    }

    public void instantiateHands() {
        while (playerCount > 8 || playerCount < 1) {
            Displays.clearScreen();
            playerCount = UserInterface.askInt("How many players are there? (Max Players 8) : ");
        }

        for (int i = 0; i < playerCount; i++) {
            playerHands.add(new PlayerHand(UserInterface.askString(String.format("Enter player %d's Name: ", i + 1))));
            playerHands.get(i).setState("inplay");
        }

        dealerHands = new DealerHand();
    }

}
