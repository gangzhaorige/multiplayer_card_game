package networking.response;

import metadata.Constants;
import model.Card;
import model.Hand;
import utility.GamePacket;

public class ResponseHand extends GameResponse {
    private short status;
    private Hand hand;

    public ResponseHand(short status, Hand hand) {
        this.status = status;
        this.hand = hand;
        responseCode = Constants.SMSG_GET_PLAYER_HAND;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        if (status == 0) {
            packet.addInt32(hand.getCards().size());
            for(Card card : hand.getCards()) {
                packet.addInt32(card.getValue());
            }
        }
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
