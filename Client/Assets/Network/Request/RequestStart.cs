using UnityEngine;

using System;

public class RequestStart : NetworkRequest {

	public RequestStart() {
		request_id = Constants.CMSG_START;
	}
	
	public void send() {
	    packet = new GamePacket(request_id);
	}
}