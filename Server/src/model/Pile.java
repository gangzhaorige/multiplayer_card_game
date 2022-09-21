package model;

import java.util.ArrayList;

import java.util.List;

public class Pile {
    
    private List<Card> pile;

    public Pile() {
        pile = new ArrayList<>();
    }

    public List<Card> getPile() {
        return pile;
    }

    public void setPile(List<Card> pile) {
        this.pile = pile;
    }

    public void addCardToPile(Card card) {
        pile.add(card);
    }

    public void pileToDeck(Deck deck) {
        for(int i = pile.size() - 1; i >= 0; i--) {
            deck.addCard(pile.remove(i));
        }
    }
}
