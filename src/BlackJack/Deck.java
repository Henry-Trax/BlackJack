package BlackJack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private int aceValue;
    private ArrayList<Card> deckCards = new ArrayList<Card>();
    private ArrayList<Card> usedCards = new ArrayList<Card>();
    private int numberOfDrawnCards = 0;

    public Deck(int aceValue) {
        this.aceValue = aceValue;

        makeDeck();
    }

    private void makeDeck() {

        int cardCount = 0;

        for (char suit : new char[]{'♠','♥','♦','♣'}) {

            for (String value : new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"}) {
                deckCards.add(new Card(suit, value, aceValue));
                cardCount++;

            }

        }

        shuffle();
    }

    public Card drawCard() {

        usedCards.add(deckCards.get(0));
        deckCards.remove(0);

        return usedCards.get(numberOfDrawnCards++);
    }

    public double cardCountAverage() {
        int cardsChecked = 0;
        double total = 0;

        for (Card card : deckCards) {
            total += card.getCardScore();
            cardsChecked++;

        }

        for (Card card : usedCards) {

            if (card.isHidden()) {
                total += card.getCardScore();
                cardsChecked++;

            }

        }

        if (cardsChecked == 0) {
            return 0;
        }

        return total / cardsChecked;
    }

    public void shuffle() {
        Collections.shuffle(deckCards);
    }

}
