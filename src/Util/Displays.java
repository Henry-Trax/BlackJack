package Util;

import BlackJack.Card;
import BlackJack.Hand;

import java.util.ArrayList;
import java.util.Objects;

public class Displays {


    public static void clearScreen() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception IOException) {
            System.out.println("IOException");
        }
    }

}
