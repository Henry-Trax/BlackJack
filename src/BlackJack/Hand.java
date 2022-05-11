package BlackJack;

import java.util.ArrayList;
import java.util.Objects;

public class Hand {

    private final ArrayList<Card> cards = new ArrayList<Card>();
    private String name;

    protected ArrayList<Card> getCards() {
        return cards;
    }

    protected void addCard(Card card) {
        this.cards.add(card);

        cards.get(cards.size() - 1).setHidden(true);
    }

//            ┌─────┐
//            │     │
//            │     │
//            │     │
//            └─────┘



}
