package model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for(int i = 1; i < 30; i++) {
            cards.add(new Card(i));
        }
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card removeTopCard() {
        return cards.remove(cards.size() - 1);
    }

    public void dealCard(Player player) {
        Hand hand = new Hand();
        for(int i = 0; i < 4; i++) {
            hand.addCard(removeTopCard());
        }
        player.setHand(hand);
    }
}
