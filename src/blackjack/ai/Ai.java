package blackjack.ai;

import blackjack.cards.DealerHand;
import blackjack.cards.Deck;
import blackjack.cards.Game;
import blackjack.menus.Settings;
import blackjack.util.Displays;

public class Ai {

    private static Deck deck;
    private static DealerHand dealerHand;

    public static String makeMove(Deck deck, DealerHand dealerHand) {
        Ai.deck = deck;
        Ai.dealerHand = dealerHand;

        switch (Settings.getDifficulty()) {
        case 1 : {
            return difficultyOne();
        }
        case 2 : {
            return difficultyTwo();
        }
        case 3 : {
            return difficultyThree();
        }
        default: {
            return "Stand";
        }
        }
    }

    private static String difficultyThree() {
        if (21 - dealerHand.getTotal(true) >= deck.getCards().get(0).getCardScore()) return "Hit";
        else return "Stand";

    }

    private static String difficultyTwo() {
        if (dealerHand.getTotal(true) < (21 - deck.cardCountAverage())) return "Hit";
        else return "Stand";
    }

    private static String difficultyOne() {
        if (dealerHand.getTotal(true) < 17) return "Hit";
        else return "Stand";
    }
}