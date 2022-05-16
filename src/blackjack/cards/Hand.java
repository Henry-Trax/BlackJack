package blackjack.cards;


import java.util.ArrayList;
import java.util.Objects;

abstract class Hand {

    private ArrayList<String> handSprite = new ArrayList<String>();

    private ArrayList<Card> cards = new ArrayList<Card>();
    protected static int colourCount = 1;
    protected static String[] colors = new String[]{"\u001b[90;1m", "\u001b[91;1m", "\u001b[92;1m", "\u001b[93;1m", "\u001b[94;1m", "\u001b[95;1m", "\u001b[96;1m"};
    protected static String colorReset = "\u001b[0m";
    protected String color;
    protected String state;
    protected int points = 0;


    public int getPoints() {
        return points;
    }


    public void incrementPoints(int i) {
        points += i;
    }

    public int getTotal() {
        int total = 0;

        for (Card card : cards) {
            total += card.getCardScore();
        }

        return total;
    }

    public void emptyHand() {
        cards = new ArrayList<Card>();
    }

    public String getState() {
        return state;
    }

    public void setState() {
        if (getTotal() == 21) {
            state = "BJ";
        }

        if (getTotal() > 21) {
            state = "Bust";
        }

        if (!Objects.equals(getState(), "Fold") || !Objects.equals(getState(), "Bust") || !Objects.equals(getState(), "BlackJack")) {
            this.state = String.valueOf(getTotal());
        }

    }

    public void setState(String state) {
        this.state = state;
    }

    protected ArrayList<Card> getCards() {
        return cards;
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        if (colourCount == 7) {
            colourCount = 0;
        }

        this.color = colors[colourCount++];
    }

    protected void updateHandSprite() {
        handSprite.clear();

        int spriteCounter = 0;
        int cardCounter = 0;

        for (int i = 0; i < getCards().size() * 2 + 3; i++) {
            handSprite.add("");
        }

        while (cardCounter < getCards().size()) {
            if (cardCounter == getCards().size() - 1) {
                for (int i = 0; i < 5; i++) {
                    handSprite.set(spriteCounter + i, handSprite.get(spriteCounter + i) + cards.get(cardCounter).getSprite()[i]);
                }

            } else {
                handSprite.set(spriteCounter, handSprite.get(spriteCounter) + cards.get(cardCounter).getSprite()[0]);
                handSprite.set(spriteCounter + 1, handSprite.get(spriteCounter + 1) + cards.get(cardCounter).getSprite()[1]);
                handSprite.set(spriteCounter + 2, handSprite.get(spriteCounter + 2) + "|");
                handSprite.set(spriteCounter + 3, handSprite.get(spriteCounter + 3) + "|");
                handSprite.set(spriteCounter + 4, handSprite.get(spriteCounter + 4) + "└");
                for (int i = spriteCounter + 5; i < getCards().size() * 2 + 3; i++) {
                    handSprite.set(i, handSprite.get(i) + " ");
                }
            }

            spriteCounter += 2;
            cardCounter++;
        }
    }

    public ArrayList<String> getHandSprite() {
        return handSprite;
    }

}
