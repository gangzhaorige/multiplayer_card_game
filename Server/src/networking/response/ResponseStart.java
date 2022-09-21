package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseStart extends GameResponse {
    private short status;

    public ResponseStart() {
        responseCode = Constants.SMSG_START;
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
