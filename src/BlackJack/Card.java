package BlackJack;

public class Card {

    private boolean isHidden = false;
    private final char suit;
    private int cardScore;
    private final String value;
    private String[] sprite;

    public Card(char suit, String value, int aceValue) {
        this.suit = suit;
        this.value = value;

        switch (value) {
        case "A"-> this.cardScore = aceValue;
        case "2"-> this.cardScore = 2;
        case "3"-> this.cardScore = 3;
        case "4"-> this.cardScore = 4;
        case "5"-> this.cardScore = 5;
        case "6"-> this.cardScore = 6;
        case "7"-> this.cardScore = 7;
        case "8"-> this.cardScore = 8;
        case "9"-> this.cardScore = 9;
        case "10"-> this.cardScore = 10;
        case "J"-> this.cardScore = 11;
        case "Q"-> this.cardScore = 12;
        case "K"-> this.cardScore = 13;
        }

        createSprite();
    }

    private void createSprite() {
        String[] template = new String[]{
                "┌─────┐",
                "│%-2s   │",
                "│ %2c  │",
                "│   %2s│",
                "└─────┘"};

        template[1] = String.format((template[1]), value);
        template[2] = String.format((template[2]), suit);
        template[3] = String.format((template[3]), value);

        sprite = template;
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
