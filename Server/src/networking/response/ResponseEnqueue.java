package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseEnqueue extends GameResponse {

    private short status;

    public ResponseEnqueue() {
        responseCode = Constants.SMSG_ENQUEUE;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }
}