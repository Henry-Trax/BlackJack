package blackjack.menus;
import blackjack.cards.Game;
import blackjack.util.Displays;
import blackjack.util.UserInterface;

public class Menu {


    public static void start() {

        while (true) {
            Displays.clearScreen();

            Displays.printHeader("Menu", 30);
            System.out.println("1 Settings\n2 Play\n3 Quit");

            switch (UserInterface.askInt("Choose An Option: ")) {
            case 1 : {
                Settings.start();
                break;
            }
            case 2 : {
                Game game = new Game();
                game.run();
                break;
            }
            case 3 : {
                System.out.println("GoodBye...");
                return;
            }
            default: {
                System.out.println("Invalid Input");
                Displays.waitXSeconds(1);
            }

            }
        }
    }
}
