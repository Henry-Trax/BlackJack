package BlackJack;

import java.util.ArrayList;

public class Hand {

    private String name = "";
    private ArrayList<Card> cards;

    public Hand(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card cards) {
        this.cards.add(cards);
    }
}
