package blackjack.cards;

import blackjack.menus.Settings;

public class PlayerHand extends Hand {

    private String name;

    public PlayerHand(String name) {
        this.setName(name);
        this.setColor(Settings.isTwoHundredElevenColors());
    }

    protected void addCard(Card card) {

        this.getCards().add(card);
        updateHandSprite();

        setLastCardInHandToHidden();
    }

    private void setLastCardInHandToHidden() {
        for (Card card : this.getCards()) {
            card.setHidden(false);
        }

        this.getCards().get(this.getCards().size() - 1).setHidden(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
