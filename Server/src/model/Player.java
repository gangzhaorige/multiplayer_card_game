package model;

// Other Imports
import core.GameClient;

/**
 * The Player class holds important information about the player including, most
 * importantly, the account. Such information includes the username, password,
 * email, and the player ID.
 */
public class Player {

    private int player_id;
    private boolean ready;
    private String username;
    private GameClient client; // References GameClient instance
    private Hand hand;

    public Player(int player_id) {
        this.player_id = player_id;
    }

    public Player(int player_id, String username) {
        this.ready = false;
        this.player_id = player_id;
        this.username = username;
    }

    public int getID() {
        return player_id;
    }

    public int setID(int player_id) {
        return this.player_id = player_id;
    }

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        return this.username = username;
    }

    public GameClient getClient() {
        return client;
    }

    public GameClient setClient(GameClient client) {
        return this.client = client;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return this.hand;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", username='" + username + '\'' +
                '}';
    }
}
