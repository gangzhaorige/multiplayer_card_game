package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for(int i = 1; i < 30; i++) {
            addCard(new Card(i));
        }
        shuffleDeck();
    }

    public List<Card> getCards() {
        return this.deck;
    }

    public void setCards(List<Card> deck) {
        this.deck = deck;
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public Card removeTopCard() {
        return deck.remove(deck.size() - 1);
    }

    public void dealCardsToPlayer(Player player, int numOfCard) {
        Hand hand = new Hand();
        for(int i = 0; i < numOfCard; i++) {
            hand.addCard(removeTopCard());
        }
        player.setHand(hand);
    }

    public void shuffleDeck() {
        Random rand = new Random();
        for(int i = 0; i < deck.size(); i++) {
            int random_index = rand.nextInt(deck.size());
            swap(i, random_index);
        }
    }

    public void swap(int i, int j) {
        Card card = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, card);
    }
}
