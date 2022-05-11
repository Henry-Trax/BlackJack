package blackjack.cards;

import java.util.Objects;

public class Card {

    private boolean isHidden = false;
    private final char suit;
    private int cardScore;
    private final String value;
    private String[] sprite;
    private static final String[] template = new String[]{
            "┌─────┐",
            "│%-2s   │",
            "│ %2c  │",
            "│   %2s│",
            "└─────┘"};

    public Card(char suit, String value, int aceValue) {
        this.suit = suit;
        this.value = value;

        switch (value) {
        case "A": {
            this.cardScore = aceValue;
        }
        case "2": {
            this.cardScore = 2;
        }
        case "3": {
            this.cardScore = 3;
        }
        case "4": {
            this.cardScore = 4;
        }
        case "5": {
            this.cardScore = 5;
        }
        case "6": {
            this.cardScore = 6;
        }
        case "7": {
            this.cardScore = 7;
        }
        case "8": {
            this.cardScore = 8;
        }
        case "9": {
            this.cardScore = 9;
        }
        case "10": {
            this.cardScore = 10;
        }
        case "J": {
            this.cardScore = 11;
        }
        case "Q": {
            this.cardScore = 12;
        }
        case "K": {
            this.cardScore = 13;
        }

        createSprite();
        }
    }

    private void createSprite() {
        sprite = template;

        sprite[1] = String.format((sprite[1]), value);
        sprite[3] = String.format((sprite[3]), value);

        sprite[2] = String.format((sprite[2]), suit);
    }

    public void setAceValue(int aceValue) {
        if (Objects.equals(value, "A")) {
            cardScore = aceValue;
        }
    }

    public String[] getSprite() {
        return sprite;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        this.isHidden = hidden;
    }

    public int getCardScore() {
        return cardScore;
    }
}
