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

    // We can visit 4 other rooms from here.
    private Room[] exits = new Room[4];
    private Bork monster;
    private String description;
    private Weapon sword;
    private int type;
    private boolean key;
    private Treasure gold;

    public void connect(int directon, Room destination) {
	exits[direction] = destination;
    }

    public dropKey() {
	key = true;
    }

    public dropWeapon(Weapon aSword) {
	sword = aSword;
    }

    public dropTreasure(Treasure someGold) {
	gold = someGold;
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
	monster = null;
	gold = null;
	sword = null;
	key = false;
    }
}