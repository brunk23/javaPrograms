public class Dungeon {
    private Room[][] rooms;

    // This will create the dungeon, populate the rooms,
    // and place the player and door.
    public Dungeon(int size) {
	rooms = new Room[size+2][size+2];
    }

}