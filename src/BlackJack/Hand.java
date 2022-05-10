package BlackJack;

import java.util.ArrayList;
import java.util.Objects;

public class Hand {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public Hand(String name) {
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);

        cards.get(cards.size() - 1).setHidden(true);
    }

}
