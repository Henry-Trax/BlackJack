package blackjack.cards;


import blackjack.menus.Settings;
import blackjack.util.Displays;
import blackjack.util.UserInterface;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    private static final Scanner scanner = new Scanner(System.in);
    private Deck deck;
    private ArrayList<PlayerHand> playerHands = new ArrayList<PlayerHand>();
    private int playerCount = 0;
    private DealerHand dealerHands;

    public Game() {
        deck = new Deck(Settings.getAceValue(), Settings.getDecksInUse());
    }

    public void run() {

        deck = new Deck(Settings.getAceValue(), Settings.getDecksInUse());

        Displays.shuffleAnimation(3);

        instantiateHands();

        while (deck.size() > 0) {

            for (PlayerHand hand : playerHands) {
                hand.addCard(deck.drawCard());
                if (isDeckEmpty()) break;
                hand.addCard(deck.drawCard());
                if (isDeckEmpty()) break;
                hand.setState();
            }

            if (isDeckEmpty()) break;

            if (playerCount == 1) {
                dealerHands.addCard(deck.drawCard());
                if (isDeckEmpty()) break;
                dealerHands.addCard(deck.drawCard());
                if (isDeckEmpty()) break;
                dealerHands.setState();
            }

            if (isDeckEmpty()) break;

            do {
                for (PlayerHand playerHand : playerHands) {

                    if (!isStandBustOrBJ(playerHand)) {

                        Displays.clearScreen();
                        displayAllHands(true);

                        String answer;

                        if (Settings.isIsDebugging()) {
                            answer = UserInterface.askString("\n" + playerHand.getColor() + "Player - " + playerHand.getName() + "" +
                                    "\n(" + (deck.size()) + " Cards Remaining)" +
                                    "\n(Average Value: " + String.format("%.2f", deck.cardCountAverage()) + ") Hit, Stand, Options or End : ");

                        } else if (deck.size() <= 28) {
                            answer = UserInterface.askString("\n" + playerHand.getColor() + "Player - " + playerHand.getName() +
                                    "\n(" + (deck.size()) + " Cards Remaining) Hit, Stand, Options or End : ");
                        } else {
                            answer = UserInterface.askString("\n" + playerHand.getColor() + "Player - " + playerHand.getName() + ", Hit, Stand, Options or End : ");
                        }
                        System.out.print(Hand.colorReset);

                        if (answer.toLowerCase().equals("hit") || answer.toLowerCase().equals("h")) {
                            playerHand.addCard(deck.drawCard());
                            playerHand.setState();

                            if (playerHand.getTotal() == 21) {
                                playerHand.setState("BJ");
                                checkWinner(playerHand);
                            }
                            if (playerHand.getTotal() > 21) {
                                playerHand.setState("Bust");
                                checkWinner(playerHand);
                            }

                            if (isDeckEmpty()) break;

                        } else if (answer.toLowerCase().equals("stand") || answer.toLowerCase().equals("s")) {
                            playerHand.setState("Stood");
                            checkWinner(playerHand);
                        }

                        if (answer.toLowerCase().equals("options") || answer.toLowerCase().equals("o")) {
                            Settings.start();
                            deck.makeDecks(Settings.getDecksInUse());
                            Displays.shuffleAnimation(3);
                        }

                        if (answer.toLowerCase().equals("end") || answer.toLowerCase().equals("e")) {
                            deck.empty();
                            if (isDeckEmpty()) break;
                        }
                    }
                }

                if (playerCount == 1 && !isStandBustOrBJ(dealerHands)) {
                    String answer = "Stand";

                    if (dealerHands.getTotal(true) < 17 && 21 - dealerHands.getTotal(true) > deck.cardCountAverage()) {
                        answer = "Hit";
                    }

                    if (answer.toLowerCase().equals("hit")) {
                        dealerHands.addCard(deck.drawCard());
                        dealerHands.setState();

                        if (dealerHands.getTotal(true) == 21) {
                            dealerHands.setState("BJ");
                            checkWinner(dealerHands);
                        }
                        if (dealerHands.getTotal(true) > 21) {
                            dealerHands.setState("Bust");
                            checkWinner(dealerHands);
                        }

                        if (isDeckEmpty()) break;

                    } else if (answer.toLowerCase().equals("stand")) {
                        dealerHands.setState("Stood");
                        checkWinner(dealerHands);
                    }
                }


                if (isDeckEmpty()) break;

            } while (isNotEndOfRound());

            Displays.clearScreen();
            dealerHands.superUpdateHandSprite();
            displayAllHands(true);
            System.out.println("Round Over");
            scanner.nextLine();
            Displays.shuffleAnimation(1);

            emptyHands();
        }

        displayScores();
    }

    private void displayScores() {

        Displays.clearScreen();
        Displays.printHeader("Game Over", 30);

        double total = 0;
        for (PlayerHand playerHand : playerHands) {
            total += playerHand.getPoints();
        }
        if (playerCount == 1) {
            total += dealerHands.getPoints();
        }

        if (total == 0) total = 0.000001;

        for (PlayerHand playerHand : playerHands) {
            System.out.println(playerHand.color + "Player " + playerHand.getName() + " Got " + playerHand.getPoints() + " Points (" + String.format("%.2f",((playerHand.getPoints() / total) * 100)) + "%)" + Hand.colorReset);
        }
        if (playerCount == 1) {
            System.out.println(dealerHands.color + "Dealer Got " + dealerHands.getPoints() + " Points (" + String.format("%.2f",((dealerHands.getPoints() / total) * 100)) + "%)" + Hand.colorReset);
        }



        scanner.nextLine();
    }

    private void checkWinner(PlayerHand playerHand) {
        switch (playerHand.getTotal()) {
        case 21 : {
            playerHand.incrementPoints(30);
            break;
        }
        case 20 : {
            playerHand.incrementPoints(15);
            break;
        }
        case 19 : {
            playerHand.incrementPoints(13);
            break;
        }
        case 18 : {
            playerHand.incrementPoints(11);
            break;
        }
        case 17 : {
            playerHand.incrementPoints(9);
            break;
        }
        case 16 : {
            playerHand.incrementPoints(7);
            break;
        }
        case 15 : {
            playerHand.incrementPoints(5);
            break;
        }
        case 2 : {
            playerHand.incrementPoints(50);
            break;
        }
        }

        if (playerHand.getTotal() < 15) {
            playerHand.incrementPoints(3);
        }
    }
    private void checkWinner(DealerHand dealerHand) {
        switch (dealerHand.getTotal(true)) {
        case 21 : {
            dealerHand.incrementPoints(21);
            break;
        }
        case 20 : {
            dealerHand.incrementPoints(15);
            break;
        }
        case 19 : {
            dealerHand.incrementPoints(14);
            break;
        }
        case 18 : {
            dealerHand.incrementPoints(13);
            break;
        }
        case 17 : {
            dealerHand.incrementPoints(12);
            break;
        }
        case 16 : {
            dealerHand.incrementPoints(11);
            break;
        }
        case 15 : {
            dealerHand.incrementPoints(10);
            break;
        }
        }

        if (dealerHand.getTotal(true) < 15) {
            dealerHand.incrementPoints(5);
        }
    }

    private boolean isNotEndOfRound() {
        boolean bool = false;

        for (PlayerHand playerHand : playerHands) {
            if (!isStandBustOrBJ(playerHand)) {
                bool = true;
            }
        }

        if (!isStandBustOrBJ(dealerHands) && playerCount == 1) {
            bool = true;
        }

        return bool;
    }

    private boolean isStandBustOrBJ(DealerHand dealerHand) {
        return Objects.equals(dealerHand.getState(), "Stood") || Objects.equals(dealerHand.getState(), "Bust") || Objects.equals(dealerHand.getState(), "BJ");

    }
    private boolean isStandBustOrBJ(PlayerHand playerHand) {
        return Objects.equals(playerHand.getState(), "Stood") || Objects.equals(playerHand.getState(), "Bust") || Objects.equals(playerHand.getState(), "BJ");
    }

    private boolean isDeckEmpty() {
        return deck.size() <= 0;
    }

    private void emptyHands() {
        for (PlayerHand playerHand : playerHands) {
            playerHand.emptyHand();
            playerHand.setState("0");
        }

        dealerHands.emptyHand();
    }

    private void turnStart() {
    }

    public void instantiateHands() {
        while (playerCount > 7 || playerCount < 1) {
            Displays.clearScreen();
            playerCount = UserInterface.askInt("How many players are there? (Max Players 7) : ");
        }

        for (int i = 0; i < playerCount; i++) {
            playerHands.add(new PlayerHand(UserInterface.askString(String.format("Enter player %d's Name: ", i + 1))));
            playerHands.get(i).setState("inplay");
        }

        dealerHands = new DealerHand();

        if (playerCount == 1) {
            dealerHands.setState("Inactive");
        }
    }

    public void displayAllHands(boolean b) {
        int maximumHandSize = 0;
        ArrayList<String> screenDisplay = new ArrayList<>();

        for (PlayerHand hand : playerHands) {
            if (hand.getHandSprite().size() > maximumHandSize) {
                maximumHandSize = hand.getHandSprite().size();
            }
        }

        if (dealerHands.getHandSprite().size() > maximumHandSize) maximumHandSize = dealerHands.getHandSprite().size();

        screenDisplay.add("");
        screenDisplay.add("");

        addNamesToDisplay(screenDisplay);

        addCardsToDisplay(maximumHandSize, screenDisplay);

        screenDisplay.add("");

        addStatesToDisplay(screenDisplay);

        screenDisplay.add("");

        addPointsToDisplay(screenDisplay);

        if (playerHands.size() == 1) {
            addDealerToDisplay(screenDisplay, b);
        }

        for (String string : screenDisplay) {
            System.out.println(string);
        }
    }

    private void addPointsToDisplay(ArrayList<String> screenDisplay) {
        for (PlayerHand hand : playerHands) {
            screenDisplay.set(screenDisplay.size() - 1, (screenDisplay.get(screenDisplay.size() - 1) + String.format(hand.getColor() + "%-" + (hand.getCards().size() + 11) + "s" + Hand.colorReset, "Points: " + hand.getPoints())));
        }

    }

    private void addDealerToDisplay(ArrayList<String> screenDisplay, boolean b) {
        screenDisplay.set(0, (screenDisplay.get(0) + String.format(dealerHands.getColor() + "%-" + (dealerHands.getCards().size() + 11) + "s" + Hand.colorReset,"Dealer:")));

        for (int i = 0; i < dealerHands.getHandSprite().size(); i++) {
            screenDisplay.set(i + 2, (screenDisplay.get(i + 2) + String.format(dealerHands.getColor() + "%-" + (dealerHands.getCards().size() + 11) + "s" + Hand.colorReset, dealerHands.getHandSprite().get(i))));
        }

        screenDisplay.set(screenDisplay.size() - 1, (screenDisplay.get(screenDisplay.size() - 1) + String.format(dealerHands.getColor() + "%-" + (dealerHands.getCards().size() + 11) + "s" + Hand.colorReset, "Points: " + dealerHands.getPoints())));
        screenDisplay.set(screenDisplay.size() - 2, (screenDisplay.get(screenDisplay.size() - 2) + String.format(dealerHands.getColor() + "%-" + (dealerHands.getCards().size() + 11) + "s" + Hand.colorReset, "State: " + dealerHands.getState())));
    }

    private void addStatesToDisplay(ArrayList<String> screenDisplay) {
        for (PlayerHand hand : playerHands) {
            screenDisplay.set(screenDisplay.size() - 1, (screenDisplay.get(screenDisplay.size() - 1) + String.format(hand.getColor() + "%-" + (hand.getCards().size() + 11) + "s" + Hand.colorReset, "State: " + hand.getState())));
        }
    }

    private void addCardsToDisplay(int maximumHandSize, ArrayList<String> screenDisplay) {
        for (int i = 0; i < maximumHandSize; i++) {
            screenDisplay.add("");

            for (PlayerHand hand : playerHands) {

                if (hand.getHandSprite().size() < i + 1) {
                    screenDisplay.set(i + 2, screenDisplay.get(i + 2) + String.format("%" + (hand.getCards().size() + 11) + "s" , ""));
                    continue;
                }

                screenDisplay.set(i + 2, (screenDisplay.get(i + 2) + String.format(hand.getColor() + "%-" + (hand.getCards().size() + 11) + "s" + Hand.colorReset, hand.getHandSprite().get(i))));
            }
        }
    }

    private void addNamesToDisplay(ArrayList<String> screenDisplay) {
        for (PlayerHand hand : playerHands) {
            String name = hand.getName();

            if (name.length() > hand.getCards().size() + 9) {
                name = name.substring(0, hand.getCards().size() + 9);
            }

            screenDisplay.set(0, (screenDisplay.get(0) + String.format(hand.getColor() + "%-" + (hand.getCards().size() + 11) + "s" + Hand.colorReset, "Player: ")));
            screenDisplay.set(1, (screenDisplay.get(1) + String.format(hand.getColor() + "%-" + (hand.getCards().size() + 11) + "s" + Hand.colorReset, name)));
        }
    }
}
