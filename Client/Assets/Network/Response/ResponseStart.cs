using System.Data.Common;
using UnityEngine;
using System.Collections.Generic;

public class ResponseStartEventArgs : ExtendedEventArgs {
	public short status { get; set; }
	public int numOfCards { get; set; }
    public List<int> cards { get; set; }

	public ResponseStartEventArgs() {
		event_id = Constants.SMSG_START;
	}

}

public class ResponseStart : NetworkResponse {
    private short status;
	private int numOfCards;
    private List<int> cards;

	public ResponseStart() {
	}

	public override void parse() {
        status = DataReader.ReadShort(dataStream);
		numOfCards = DataReader.ReadInt(dataStream);
        cards = new List<int>();
        for(int i = 0; i < numOfCards; i++) {
            int cardValue = DataReader.ReadInt(dataStream);
            cards.Add(cardValue);
        }
	}

	public override ExtendedEventArgs process() {
		ResponseStartEventArgs args = null;
		args = new ResponseStartEventArgs();
        args.status = status;
		args.numOfCards = numOfCards;
        args.cards = cards;
		return args;
	}

}