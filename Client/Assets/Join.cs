using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.SceneManagement;

public class Join : MonoBehaviour
{
    private GameObject mainObject;
    private MessageQueue msgQueue;
	private ConnectionManager cManager;
    [SerializeField] private TMP_InputField username;

    void Awake() {
		mainObject = GameObject.Find("Network");
		cManager = mainObject.GetComponent<ConnectionManager>();
		msgQueue = mainObject.GetComponent<MessageQueue>();
		msgQueue.AddCallback(Constants.SMSG_AUTH, ResponseLogin);
	}
    // Start is called before the first frame update
    void Start()
    {
        
    }

    public void JoinServer() {
        cManager.send(requestLogin(username.text));
    }

    public RequestLogin requestLogin(string username) {
		RequestLogin request = new RequestLogin();
		request.send(username);
		return request;
	}
	
	public void ResponseLogin(ExtendedEventArgs eventArgs) {
		ResponseLoginEventArgs args = eventArgs as ResponseLoginEventArgs;
		if (args.status == 0) {
			Debug.Log ("Successfully joined the lobby : " + args.ToString());
			SceneManager.LoadScene("Lobby");
		} else {
			Debug.Log("Login Failed");
		}
	}
	
    // Update is called once per frame
    void Update()
    {
        
    }
}
