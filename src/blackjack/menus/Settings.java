package blackjack.menus;

import blackjack.util.Displays;
import blackjack.util.UserInterface;

public class Settings {

    private static int aceValue = 1;
    private static int decksInUser = 1;
    private static boolean isDebugging = false;


    public static void start() {

        while (true) {
            Displays.clearScreen();

            Displays.printHeader("Settings", 30);
            System.out.printf("1 AceValue: %d\n2 DecksInUse: %d\n3 Debug: %s\n4 Exit\n", aceValue, decksInUser, String.valueOf(isIsDebugging()));

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
                return;
            }
            default: {
            System.out.println("Invalid Input");
            Displays.waitXSeconds(1);
            }

            }
        }
    }

    private static void changeIsDebugging() {
        Displays.clearScreen();
        Displays.printHeader("Debug", 30);
        System.out.printf("Debugging: %s\n", String.valueOf(isIsDebugging()));
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
}
