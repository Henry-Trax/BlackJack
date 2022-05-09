package BlackJack;

public class Deck {

    private int aceValue;
    Card[] deck = new Card[52];

    public Deck(int aceValue) {
        this.aceValue = aceValue;

        makeDeck();
    }

    private void makeDeck() {

        int cardCount = 0;

        for (char suit : new char[]{'♠','♥','♦','♣'}) {

            for (String value : new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"}) {

                deck[cardCount] = new Card(suit, value, aceValue);

            }

        }

    }

}
