using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class Lobby : MonoBehaviour
{
    private GameObject mainObject;
    private MessageQueue msgQueue;
	private ConnectionManager cManager;
    [SerializeField] private TMP_Text username;
    // Start is called before the first frame update
    void Start()
    {
        username.text = Constants.USERNAME;
    }

    void Awake() {
		mainObject = GameObject.Find("Network");
		cManager = mainObject.GetComponent<ConnectionManager>();
		msgQueue = mainObject.GetComponent<MessageQueue>();
		msgQueue.AddCallback(Constants.SMSG_START, ResponseStart);
	}

    public void StartGame() {
        cManager.send(requestStart());
    }

    public RequestStart requestStart() {
		RequestStart request = new RequestStart();
		request.send();
		return request;
	}
	
	public void ResponseStart(ExtendedEventArgs eventArgs) {
		ResponseStartEventArgs args = eventArgs as ResponseStartEventArgs;
		if (args.status == 0) {
			Debug.Log ("Successfully ready." + args.ToString());
		} else {
			Debug.Log("Waiting for others to start...");
		}
	}

    // Update is called once per frame
    void Update()
    {
        
    }
}
