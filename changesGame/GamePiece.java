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
	    isLarge = true;
	} else {
	    if( description.equalsIgnoreCase("small") ) {
		isLarge = false;
	    } else {
		// THROW ERROR
		throw new IllegalArgumentException(description);
	    }
	}
    }

    boolean getSize() {
	return isLarge;
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
    public String toString() {
	String description = new String("A ");
	if( isLarge ) {
	    description += "large ";
	} else {
	    description += "small ";
	} 
	return description;
    }

    // Returns the number of differences
    int compareTo(GamePiece other) {
	int count = 0;

	if( isLarge != other.getSize() ) {
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
