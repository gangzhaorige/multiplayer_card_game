package core;

import java.util.LinkedHashMap;
import java.util.Map;

import model.Player;

public class MatchmakingQueue {
    private Map<Integer, Player> queue = new LinkedHashMap<>();

    public synchronized void addPlayer(Player player) {
        queue.put(player.getID(), player);
    }

    public synchronized boolean removePlayer(int playerId) {
        return queue.remove(playerId) != null;
    }

    public synchronized Player getNextPlayer() {
        // Returns the first player in the queue
        if (!queue.isEmpty()) {
            Map.Entry<Integer, Player> entry = queue.entrySet().iterator().next();
            return entry.getValue();
        }
        return null;
    }
}