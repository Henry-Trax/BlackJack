package blackjack.cards;

import java.util.Arrays;
import java.util.Objects;

public class Card {

    private boolean isHidden = false;
    private final char suit;
    private int cardScore;
    private final String value;
    private String[] sprite = new String[]{"┌─────┐","│%-2s   │","│ %2c  │","│   %2s│","└─────┘"};

    public Card(char suit, String value, int aceValue) {
        this.value = value;
        this.suit = suit;

        switch (value) {
        case "A": {
            this.cardScore = aceValue;
            break;
        }
        case "2": {
            this.cardScore = 2;
            break;
        }
        case "3": {
            this.cardScore = 3;
            break;
        }
        case "4": {
            this.cardScore = 4;
            break;
        }
        case "5": {
            this.cardScore = 5;
            break;
        }
        case "6": {
            this.cardScore = 6;
            break;
        }
        case "7": {
            this.cardScore = 7;
            break;
        }
        case "8": {
            this.cardScore = 8;
            break;
        }
        case "9": {
            this.cardScore = 9;
            break;
        }
        case "10": {
            this.cardScore = 10;
            break;
        }
        case "J": {
            this.cardScore = 11;
            break;
        }
        case "Q": {
            this.cardScore = 12;
            break;
        }
        case "K": {
            this.cardScore = 13;
        }
        }
        createSprite();
    }

    private void createSprite() {
        sprite[1] = String.format((sprite[1]), value);
        sprite[3] = String.format((sprite[3]), value);

        sprite[2] = String.format((sprite[2]), suit);
    }

    public String[] getSprite() {
        return sprite;
    }

    public boolean isHidden() {
        return isHidden;
    }

    @Override
    public String toString() {
        return "Card{" +
                "isHidden=" + isHidden +
                ", suit=" + suit +
                ", cardScore=" + cardScore +
                ", value='" + value + '\'' +
                '}';
    }

    public void setHidden(boolean hidden) {
        this.isHidden = hidden;
    }

    public int getCardScore() {
        return cardScore;
    }
}
