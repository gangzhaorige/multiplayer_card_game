using UnityEngine;

using System;
using System.Collections.Generic;

public class ResponseHandEventArgs : ExtendedEventArgs {
		
	public short status { get; set; }
	public int handSize { get; set; }
	public List<int> cards { get; set; }
	
	public ResponseHandEventArgs() {
		event_id = Constants.SMSG_GET_PLAYER_HAND;
	}
}

public class ResponseHand : NetworkResponse {
	
	private short status;
	private int handSize;
	private List<int> cards;

	public ResponseHand() {
	}
	
	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		if (status == 0) {
            cards = new List<int>();
			handSize = DataReader.ReadInt(dataStream);
            for(int i = 0; i < handSize; i++) {
                cards.Add(DataReader.ReadInt(dataStream));
            }
		}
	}
	
	public override ExtendedEventArgs process() {
		ResponseHandEventArgs args = null;
		if (status == 0) {
			args = new ResponseHandEventArgs();
			args.status = status;
			args.handSize = handSize;
			args.cards = cards;
		}

		return args;
	}
}