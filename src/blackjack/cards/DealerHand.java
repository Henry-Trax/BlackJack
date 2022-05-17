package blackjack.cards;

import blackjack.menus.Settings;

import java.util.Objects;

public class DealerHand extends Hand{

    private final String[] hiddenCard = new String[]{"┌─────┐","│/ / /│","│\\ \\ \\│","│/ / /│","└─────┘"};
    public DealerHand() {
        this.setColor(Settings.isTwoHundredElevenColors());
    }

    protected void addCard(Card card) {
        this.getCards().add(card);
        updateHandSprite();
    }

    public int getTotal(boolean b) {
        if (b) {
            return super.getTotal();
        } else {
            return super.getTotal() - getCards().get(getCards().size() - 1).getCardScore();
        }
    }

    @Override
    public String getState() {
        return super.getState();
    }

    @Override
    protected void updateHandSprite() {
        getHandSprite().removeAll(getHandSprite());

        int spriteCounter = 0;
        int cardCounter = 0;

        for (int i = 0; i < getCards().size() * 2 + 3; i++) {
            getHandSprite().add("");
        }

        while (cardCounter < getCards().size()) {
            if (cardCounter == getCards().size() - 1) {
                for (int i = 0; i < 5; i++) {
                    getHandSprite().set(spriteCounter + i, getHandSprite().get(spriteCounter + i) + hiddenCard[i]);
                }

            } else {
                getHandSprite().set(spriteCounter, getHandSprite().get(spriteCounter) + getCards().get(cardCounter).getSprite()[0]);
                getHandSprite().set(spriteCounter + 1, getHandSprite().get(spriteCounter + 1) + getCards().get(cardCounter).getSprite()[1]);
                getHandSprite().set(spriteCounter + 2, getHandSprite().get(spriteCounter + 2) + "|");
                getHandSprite().set(spriteCounter + 3, getHandSprite().get(spriteCounter + 3) + "|");
                getHandSprite().set(spriteCounter + 4, getHandSprite().get(spriteCounter + 4) + "└");
                for (int i = spriteCounter + 5; i < getCards().size() * 2 + 3; i++) {
                    getHandSprite().set(i, getHandSprite().get(i) + " ");
                }
            }

            spriteCounter += 2;
            cardCounter++;
        }
    }

    public void setState() {
        if (getTotal() == 21) {
            state = "BJ";
        }

        if (getTotal() > 21) {
            state = "Bust";
        }

        if (!Objects.equals(getState(), "Stand") || !Objects.equals(getState(), "Bust") || !Objects.equals(getState(), "BlackJack")) {
            this.state = String.valueOf(getTotal(false));
        }
    }

    public void superUpdateHandSprite() {
        super.updateHandSprite();
    }

}
