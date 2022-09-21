package networking.request;

import networking.response.ResponseHand;
import networking.response.ResponseStart;
import utility.Log;

import java.io.IOException;
import java.util.List;

import core.GameServer;
import core.NetworkManager;
import model.Game;
import model.Player;

public class RequestStart extends GameRequest {

    private ResponseStart responseStart;

    //Do not remove this constructor even though the IDE claims it is not being used anywhere. It is being called by reflection.
    public RequestStart() {
        responseStart = new ResponseStart();
        responses.add(responseStart);
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        //
        Player curPlayer = client.getPlayer();
        if(!curPlayer.getReady()) {
            curPlayer.setReady(true);
        }
        List<Player> players = GameServer.getInstance().getActivePlayers();
        // if someone is not ready do not start a game...
        for(Player p : players) {
            if(!p.getReady()) {
                return;
            }
        }
        Log.printf("A new Game started...");
        Game game = new Game(players);
        GameServer.getInstance().setGame(game);
        responseStart.setStatus((short) 0);
        for(Player p : players) {
            NetworkManager.addResponseForUser(p.getID(), new ResponseHand((short) 0, p.getHand()));
        }
    }
}
