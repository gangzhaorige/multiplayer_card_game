using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
public class Hand : MonoBehaviour
{

    private GameObject mainObject;
    private MessageQueue msgQueue;
	private ConnectionManager cManager;
    public GameObject card; 

    
    [SerializeField] private TMP_Text hand;
    void Awake() {
		mainObject = GameObject.Find("Network");
		cManager = mainObject.GetComponent<ConnectionManager>();
		msgQueue = mainObject.GetComponent<MessageQueue>();
		msgQueue.AddCallback(Constants.SMSG_GET_PLAYER_HAND, ResponseHand);
	}
    // Start is called before the first frame update
    void Start()
    {
        
    }

    public void ResponseHand(ExtendedEventArgs eventArgs) {
		ResponseHandEventArgs args = eventArgs as ResponseHandEventArgs;
		if (args.status == 0) {
			Debug.Log ("Successful got player Hand : " + args.ToString());
            string stringHand = "";
            for(int i = 0; i < args.handSize; i++) {
                Debug.Log ("Hand : " + i + " " + args.cards[i]);
                stringHand = stringHand + args.cards[i];
                stringHand = stringHand + " ";
            }
            hand.text = stringHand;
		} else {
			Debug.Log("Login Failed");
		}
	}

    // Update is called once per frame
    void Update()
    {
        
    }
}
