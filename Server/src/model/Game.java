package model;

import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players;

    public Game(List<Player> players) {
        this.deck = new Deck();
        this.players = players;
        for(Player p : players) {
            deck.dealCard(p);
        }
    }

    public Deck getDeck() {
        return this.deck;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
