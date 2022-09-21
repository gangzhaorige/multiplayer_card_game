public class Constants {
	
	// Constants
	public static readonly string CLIENT_VERSION = "1.00";
	public static readonly string REMOTE_HOST = "localhost";
	public static readonly int REMOTE_PORT = 1729;
	
	// Request (1xx) + Response (2xx)
	public static readonly short CMSG_AUTH = 101;
	public static readonly short SMSG_AUTH = 201;
    public static readonly short CMSG_HEARTBEAT = 102;
    public static readonly short SMSG_HEARTBEAT = 202;
	public static readonly short CMSG_PLAYERS = 103;
	public static readonly short SMSG_PLAYERS = 203;
	public static readonly short CMSG_TEST = 104;
	public static readonly short SMSG_TEST = 204;
	public static readonly short CMSG_START = 105;
	public static readonly short SMSG_START = 205;
	public static readonly short CMSG_GET_PLAYER_HAND = 106;
	public static readonly short SMSG_GET_PLAYER_HAND = 206;
	
	// Other
	public static readonly string IMAGE_RESOURCES_PATH = "Images/";
	public static readonly string PREFAB_RESOURCES_PATH = "Prefabs/";
	public static readonly string TEXTURE_RESOURCES_PATH = "Textures/";
	
	// GUI Window IDs
	public enum GUI_ID {
		Login
	};

	public static int USER_ID = -1;
	public static string USERNAME = null;
}