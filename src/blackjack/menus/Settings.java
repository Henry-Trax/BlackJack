package blackjack.menus;

import blackjack.util.Displays;
import blackjack.util.UserInterface;

public class Settings {

    private static int aceValue = 1;
    private static int decksInUser = 1;
    private static boolean isDebugging = false;
    private static boolean twoHundredElevenColors = true;


    public static void start() {

        while (true) {
            Displays.clearScreen();

            Displays.printHeader("Settings", 30);
            System.out.printf("1 AceValue: %d\n2 DecksInUse: %d\n3 Debug: %s\n4 Using 211 colors: %s\n5 Exit\n", aceValue, decksInUser, String.valueOf(isIsDebugging()), String.valueOf(isTwoHundredElevenColors()));

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
                return;
            }
            default: {
            System.out.println("Invalid Input");
            Displays.waitXSeconds(1);
            }

            }
        }
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
}
