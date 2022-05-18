package blackjack.menus;

import blackjack.util.Displays;
import blackjack.util.UserInterface;

public class Settings {

    private static int aceValue = 1;
    private static int decksInUser = 1;
    private static boolean isDebugging = false;
    private static boolean twoHundredElevenColors = true;
    private static int difficulty = 1;

    private static boolean aiThreshold = true;


    public static void start() {

        while (true) {
            Displays.clearScreen();

            Displays.printHeader("Settings", 30);
            System.out.printf("1 AceValue: %d\n2 DecksInUse: %d\n3 Debug: %s\n4 Using 211 colors: %s\n5 Ai Difficulty: %d\n6 Dealer Plays: %s\n7 Exit\n", aceValue, decksInUser, String.valueOf(isIsDebugging()), String.valueOf(isTwoHundredElevenColors()), difficulty, aiThreshold);

            switch (UserInterface.askInt("Choose An Option: ")) {
            case 1 : {
                changeAceValue();
                break;
            }
            case 2 : {
                changeDeckInUse();
                break;
            }
            case 3 : {
                changeIsDebugging();
                break;
            }
            case 4 : {
                changTwoHundredElevenColors();
                break;
            }
            case 5 : {
                changeDifficulty();
                break;
            }
            case 6 : {
                changeAiThreshold();
                break;
            }
            case 7 : {
                return;
            }
            default: {
            System.out.println("Invalid Input");
            Displays.waitXSeconds(1);
            }

            }
        }
    }

    private static void changeAiThreshold() {
        Displays.clearScreen();
        Displays.printHeader("Dealer", 30);
        System.out.printf("Dealer plays: %s\n", aiThreshold);
        aiThreshold = Boolean.parseBoolean(UserInterface.askString("Enter new value true or false: "));
    }

    private static void changeDifficulty() {
        Displays.clearScreen();
        Displays.printHeader("Ai Difficulty", 30);
        System.out.printf("Ai Difficulty: %d\n", difficulty);

        do {
            difficulty = UserInterface.askInt("New value for difficulty 1 - 3: ");
        } while (difficulty < 1 || difficulty > 3);
    }

    private static void changTwoHundredElevenColors() {
        Displays.clearScreen();
        Displays.printHeader("Color", 30);
        System.out.printf("Use 211 colors: %s\n", isTwoHundredElevenColors());
        twoHundredElevenColors = Boolean.parseBoolean(UserInterface.askString("Enter new value true or false: "));
    }

    private static void changeIsDebugging() {
        Displays.clearScreen();
        Displays.printHeader("Debug", 30);
        System.out.printf("Debugging: %s\n", isIsDebugging());
        isDebugging = Boolean.parseBoolean(UserInterface.askString("Enter new value true or false: "));
    }

    private static void changeDeckInUse() {
        Displays.clearScreen();
        Displays.printHeader("Number of Decks", 30);
        System.out.printf("Decks In use: %d\n", decksInUser);
        decksInUser = UserInterface.askInt("How many Decks do you want to use?: ");
    }

    private static void changeAceValue() {
        Displays.clearScreen();
        Displays.printHeader("AceValue", 30);
        System.out.printf("Ace Value: %d\n", aceValue);
        aceValue = UserInterface.askInt("New value for aces: ");
    }

    public static int getAceValue() {
        return aceValue;
    }

    public static void setAceValue(int aceValue) {
        Settings.aceValue = aceValue;
    }

    public static int getDecksInUse() {
        return decksInUser;
    }

    public static void setDecksInUser(int decksInUser) {
        Settings.decksInUser = decksInUser;
    }

    public static boolean isIsDebugging() {
        return isDebugging;
    }

    public static void setIsDebugging(boolean isDebugging) {
        Settings.isDebugging = isDebugging;
    }

    public static boolean isTwoHundredElevenColors() {
        return twoHundredElevenColors;
    }

    public static void setTwoHundredElevenColors(boolean twoHundredElevenColors) {
        Settings.twoHundredElevenColors = twoHundredElevenColors;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        Settings.difficulty = difficulty;
    }

    public static boolean getAiActivity(int playerCount) {
        int val = 1;

        if (aiThreshold) {
            val = 7;
        }

        return val >= playerCount;
    }

    public static boolean isAiThreshold() {
        return aiThreshold;
    }
}
