package blackjack.util;


public class Displays {

    public static void clearScreen() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception IOException) {
            System.out.println("IOException");
        }
    }

    public static void waitXSeconds(double secs) {
        try {
            Thread.sleep((long) (secs * 1000L));

        } catch (InterruptedException ignored) {

        }
    }

    public static void printHeader(String header, int padding) {
        System.out.println("[" + centerAlign(header, padding) + "]");

    }

    public static String centerAlign(String string, int padding) {
        padding /= 2;

        if (string.length() % 2 == 0) {
            String formatString = String.format(("%" + ( padding - (string.length()) / 2) + "s"), " ") + "%s" + String.format(("%" + ( padding - (string.length()) / 2) + "s"), " ");
            string = String.format(formatString.replace(' ', '_'), string);
        } else {
            String formatString = String.format(("%" + ( padding - (string.length()) / 2) + "s"), " ") + "%s" + String.format(("%" + ( (padding - 1) - (string.length()) / 2) + "s"), " ");
            string = String.format(formatString.replace(' ', '_'), string);
        }

        return string;
    }

    public static void shuffleAnimation(int i) {
        int b = 0;

        while (b++ < i) {

            if (true) printFrames();

        }

        waitXSeconds(0.5);
    }

    private static void printFrames() {

        clearScreen();
        System.out.println(
                "┌┬─────┐    ┌─────┐" + "\n" +
                "││     │    │     │" + "\n" +
                "││  B  │    │  J  │" + "\n" +
                "││     │    │     │" + "\n" +
                "└┸─────┘    └─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─┬─────┐   ┌─────┐" + "\n" +
                "│ │     │   │     │" + "\n" +
                "│ │  B  │   │  J  │" + "\n" +
                "│ │     │   │     │" + "\n" +
                "└─┴─────┘   └─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌──┬─────┐  ┌─────┐" + "\n" +
                "│  │     │  │     │" + "\n" +
                "│  │  B  │  │  J  │" + "\n" +
                "│  │     │  │     │" + "\n" +
                "└──┴─────┘  └─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌───┬─────┐ ┌─────┐" + "\n" +
                "│   │     │ │     │" + "\n" +
                "│  B│  B  │ │  J  │" + "\n" +
                "│   │     │ │     │" + "\n" +
                "└───┴─────┘ └─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌────┬─────┐┌─────┐" + "\n" +
                "│    │     ││     │" + "\n" +
                "│  B │  B  ││  J  │" + "\n" +
                "│    │     ││     │" + "\n" +
                "└────┴─────┘└─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─────┬─────┬─────┐" + "\n" +
                "│     │     │     │" + "\n" +
                "│  B  │  B  │  J  │" + "\n" +
                "│     │     │     │" + "\n" +
                "└─────┴─────┴─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─────┐┌────┬─────┐" + "\n" +
                "│     ││    │     │" + "\n" +
                "│  B  ││  B │  J  │" + "\n" +
                "│     ││    │     │" + "\n" +
                "└─────┘└────┴─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─────┐ ┌───┬─────┐" + "\n" +
                "│     │ │   │     │" + "\n" +
                "│  B  │ │  B│  J  │" + "\n" +
                "│     │ │   │     │" + "\n" +
                "└─────┘ └───┴─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─────┐  ┌──┬─────┐" + "\n" +
                "│     │  │  │     │" + "\n" +
                "│  B  │  │  │  J  │" + "\n" +
                "│     │  │  │     │" + "\n" +
                "└─────┘  └──┴─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─────┐   ┌─┬─────┐" + "\n" +
                "│     │   │ │     │" + "\n" +
                "│  B  │   │ │  J  │" + "\n" +
                "│     │   │ │     │" + "\n" +
                "└─────┘   └─┴─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─────┐    ┌┬─────┐" + "\n" +
                "│     │    ││     │" + "\n" +
                "│  B  │    ││  J  │" + "\n" +
                "│     │    ││     │" + "\n" +
                "└─────┘    └┴─────┘");
        waitXSeconds(0.01);
        clearScreen();
        System.out.println(
                "┌─────┐     ┌─────┐" + "\n" +
                "│     │     │     │" + "\n" +
                "│  B  │     │  J  │" + "\n" +
                "│     │     │     │" + "\n" +
                "└─────┘     └─────┘");
        waitXSeconds(0.01);

    }
}
