/*
 * This is a class to hold the connection information
 */

public class Connection {
    private LilyPad destination;
    private int differences;

    void setDestination(LilyPad dest) {
	destination = dest;
    }

    LilyPad getDestination() {
	return destination;
    }

    void setDifferences(int diff) {
	differences = diff;
    }

    int getDifferences() {
	return differences;
    }

    public Connection(LilyPad dest, int diff) {
	setDestination(dest);
	setDifferences(diff);
    }
}
