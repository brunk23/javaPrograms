/*
 * This will hold the gamePiece information for each
 * possible piece.
 */

public class GamePiece {
    boolean isLarge;
    int color;
    boolean hole;
    int shape;

    void setSize(String description) {
	if( description.equalsIgnoreCase("large") ) {
	    size = true;
	} else {
	    if( description.eqauls.IgnoreCase("small") ) {
		size = false;
	    } else {
		// THROW ERROR
		throw new IllegalArgumentException;
	    }
	}
    }

    boolean getSize() {
	return size;
    }

    int getColor() {
	return color;
    }

    boolean hasHole() {
	return hole;
    }

    int getShape() {
	return shape;
    }

    // Will print a string description of the object.
    String toString() {
	String description = new String("A ");
	if( isLarge ) {
	    description += "large ";
	} else {
	    description += "small ";
	} 

    }

    // Returns the number of differences
    int compareTo(GamePiece other) {
	int count = 0;

	if( size != other.getSize() ) {
	    count++;
	}
	if( color != other.getColor() ) {
	    count++;
	}
	if( hole != other.hasHole() ) {
	    count++;
	}
	if( shape != other.getShape() ) {
	    count++;
	}

	return count;
    }


    public GamePiece() {
	
    }

}