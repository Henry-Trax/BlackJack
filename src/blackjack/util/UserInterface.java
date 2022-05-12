package blackjack.util;

import java.util.Scanner;

public class UserInterface {

    public static int askInt(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);

        try {
            int num = scanner.nextInt();
            scanner.nextLine();
            return num;
        } catch (Exception e) {
            return -1;
        }

    }

    public static String askString(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
