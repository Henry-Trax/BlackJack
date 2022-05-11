import blackjack.cards.Card;
import blackjack.cards.Deck;

public class TestBlackJack {

    public static void main(String[] args) {
    }

    public static void testDeckDrawing() {

        Deck deck = new Deck(1, 1);

        for (int i = 0; i < 52; i++) {
            Card card = deck.drawCard();

            for (String line : card.getSprite()) {
                System.out.println(line);

            }
        }
    }

    public static void testCardCounting() {
        Deck deck = new Deck(1, 1);

        for (int i = 0; i < 52; i++) {
            if (true) {
                Card card = deck.drawCard();
            }else {
                Card card = deck.drawCard();
            }

        }

        System.out.println(deck.cardCountAverage());

    }

    public static void testShuffle() {
        Deck deck = new Deck(1, 1);
        deck.shuffle();

        System.out.println();
    }
}
