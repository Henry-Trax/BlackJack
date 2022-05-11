package blackjack.cards;

import blackjack.cards.Card;

import java.util.ArrayList;

abstract class Hand {

    private final ArrayList<Card> cards = new ArrayList<Card>();

    protected ArrayList<Card> getCards() {
        return cards;
    }

    protected void addCard(Card card) {
        this.cards.add(card);
    }

}
