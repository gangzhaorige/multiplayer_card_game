package networking.request;

// Java Imports
import java.io.IOException;

import core.GameServer;
import model.Player;
import networking.response.ResponseEnqueue;
import utility.Log;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 */

public class RequestEnqueue extends GameRequest {

    // Data
    // Responses
    private ResponseEnqueue responseEnqueue;

    public RequestEnqueue() {
        responses.add(responseEnqueue = new ResponseEnqueue());
    }

    @Override
    public void parse() throws IOException {

    }

    @Override
    public void doBusiness() throws Exception {
        Player player = null;
        player = client.getPlayer();
        if(player != null) {
            GameServer.getInstance().enqueue(player);
            Log.printf("Player: " + player.getID() + " is in a queue.");
            responseEnqueue.setStatus((short) 0);
            return;
        }
        responseEnqueue.setStatus((short) 1);
        Log.printf("Failed to enqueue...");
    }
}
