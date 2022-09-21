package model;

import java.util.List;

public class Game {

    private Pile pile;
    private Deck deck;
    private List<Player> players;

    public Game(List<Player> players) {
        this.deck = new Deck();
        this.pile = new Pile();
        this.players = players;
        for(Player p : players) {
            deck.dealCardsToPlayer(p, 4);
        }
    }

    public Deck getDeck() {
        return this.deck;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Pile getPile() {
        return this.pile;
    }

}
