package blackjack.cards;
import blackjack.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private int decksInUse = 0;
    private int aceValue;
    private ArrayList<Card> deckCards = new ArrayList<Card>();
    private ArrayList<Card> usedCards = new ArrayList<Card>();
    private int numberOfDrawnCards = 0;

    public Deck(int aceValue, int decksInUse) {
        this.aceValue = aceValue;

        makeDecks(decksInUse);

        this.decksInUse = decksInUse;
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


    public void resetDeck(int decksInUse) {
        usedCards.removeAll(usedCards);
        deckCards.removeAll(deckCards);
    }

    private void makeDecks(int decksInUse) {
        for (int i = 0; i < decksInUse - this.decksInUse; i++) {
            makeDeck();
        }
    }

    public int getAceValue() {
        return aceValue;
    }

    public void setAceValue(int aceValue) {

        for (Card card : deckCards) {
            card.setAceValue(aceValue);
        }
        for (Card card : usedCards) {
            card.setAceValue(aceValue);
        }

        this.aceValue = aceValue;
    }
}