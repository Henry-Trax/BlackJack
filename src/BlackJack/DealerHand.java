package BlackJack;

import java.util.ArrayList;

public class DealerHand extends Hand{

    private final ArrayList<Card> cards = new ArrayList<Card>();
    private String name;

    @Override
    protected void addCard(Card card) {
        this.cards.add(card);
    }



}
