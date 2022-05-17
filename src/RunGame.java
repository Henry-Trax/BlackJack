import blackjack.menus.Menu;

public class RunGame {

    public static void main(String[] args) {
        try {
            Menu.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
