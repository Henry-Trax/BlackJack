package BlackJack;
import java.util.ArrayList;

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

    }

    public Card drawCard(boolean isHidden) {

        usedCards.add(deckCards.get(0));

        usedCards.get(numberOfDrawnCards).setHidden(isHidden);

        deckCards.remove(0);

        return usedCards.get(numberOfDrawnCards++);
    }

}
