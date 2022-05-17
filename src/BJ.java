import blackjack.menus.Menu;

public class BJ {

    public static void main(String[] args) {
        try {
            Menu.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
