public class Room {
    private final int MAXEXITS = 4;
    private final int NORTH = 0;
    private final int SOUTH = 1;
    private final int EAST = 2;
    private final int WEST = 3;
    private final int PIT = 10;
    private final int WALL = 20;
    private final int NORMAL = 30;
    private final int EMPTY = 0x0;
    private final int BORK = 0x100;
    private final int WEAPON = 0x200;
    private final int KEY = 0x400;
    private final int TREASURE = 0x800;

    // We can visit 4 other rooms from here.
    private Room[] exits = new Room[4]; 
    private String description;
    private int contents;
    private int type;

    public void connect(int directon, Room destination) {
	exits[direction] = destination;
    }


    public String descr() {
	return description;
    }

    public Room() {
	int i;

	for( i = 0; i < MAXEXITS; ++i) {
	    exits[i] = null;
	}
	description = new String("");
	contents = EMPTY;
	type = NORMAL;
    }
}