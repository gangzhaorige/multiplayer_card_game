using System.Data.Common;
using UnityEngine;
using System.Collections.Generic;

public class ResponseStartEventArgs : ExtendedEventArgs {
	public short status { get; set; }

	public ResponseStartEventArgs() {
		event_id = Constants.SMSG_START;
	}

}

public class ResponseStart : NetworkResponse {
    private short status;

	public ResponseStart() {
	}

	public override void parse() {
        status = DataReader.ReadShort(dataStream);
	}

	public override ExtendedEventArgs process() {
		ResponseStartEventArgs args = null;
		args = new ResponseStartEventArgs();
        args.status = status;
		return args;
	}

}