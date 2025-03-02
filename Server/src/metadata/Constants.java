package metadata;

/**
 * The Constants class stores important variables as constants for later use.
 */
public class Constants {

    // Request (1xx) + Response (2xx)
    public final static short CMSG_AUTH = 101;
    public final static short SMSG_AUTH = 201;
    public final static short CMSG_HEARTBEAT = 102;
    public final static short SMSG_HEARTBEAT = 202;
    public final static short CMSG_PLAYERS = 103;
    public final static short SMSG_PLAYERS = 203;
    public final static short CMSG_ENQUEUE = 104;
    public final static short SMSG_ENQUEUE = 204;
    // Other
    public static final float BIOMASS_SCALE = 1000;
    public static final String CLIENT_VERSION = "1.00";
    public static final int TIMEOUT_SECONDS = 30;
    public static final String CSV_SAVE_PATH = "src/log/";

}
