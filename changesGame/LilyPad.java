/*
 * The container for the pieces
 */

public class LilyPad {
    public static final int MAX_CONNECTIONS = 10;

    GamePiece block;
    Connection[] connections;
    // Connections, probably an array to other LilyPads it touches
    // plus a count of the differences

    /*
     * Returns true if the following are true:
     * 1. we have a GamePiece
     * 2. all our connections have a GamePiece
     * 3. all the differences in GamePiece characteristics match
     */
    public void isComplete() {

    }
    
    /*
     * Will add a new connection to our list.
     */
    public addConnection(Connection a) {

    }

    /*
     * Create new, unconnected LilyPad
     */
    public LilyPad() {
	int i;
	block = null;
	connections = new Connection[MAX_CONNECTIONS];
	for(i = 0; i < MAX_CONNECTIONS; ++i) {
	    connections[i] = null;
	}
    }
}