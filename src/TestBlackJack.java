import blackjack.cards.Card;
import blackjack.cards.DealerHand;
import blackjack.cards.Deck;
import blackjack.cards.PlayerHand;

public class TestBlackJack {

    public static void main(String[] args) {

        PlayerHand player1 = new PlayerHand("Henry");
        PlayerHand player2 = new PlayerHand("Jamie");
        PlayerHand player3 = new PlayerHand("Marcin");
        PlayerHand player4 = new PlayerHand("Tony");
        DealerHand dealer = new DealerHand();
        PlayerHand player5 = new PlayerHand("Brandon");
        PlayerHand player6 = new PlayerHand("Robert");
        PlayerHand player7 = new PlayerHand("Harry");

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
