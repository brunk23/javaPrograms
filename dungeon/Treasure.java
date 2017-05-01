public class Treasure {
    int value;

    public int collect() {
	int a = value;
	value = 0;
	return a;
    }

    public Treasure() {
	value = 100;
    }
}