/*
 * This will hold the gamePiece information for each
 * possible piece.
 */

public class GamePiece {
    // Color constants
    static final int RED = 1;
    static final int GREEN = 2;
    static final int BLUE = 3;
    static final int YELLOW = 4;

    // Shape constants
    static final int SQUARE = 11;
    static final int TRIANGLE = 12;
    static final int CIRCLE = 13;
    static final int HEXAGON = 14;

    // instance variables
    boolean isLarge;
    int color;
    boolean hole;
    int shape;

    void setShape(String description) {
	if( description.equalsIgnoreCase("square") ) {
	    shape = SQUARE;
	    return;
	}
	if( description.equalsIgnoreCase("triangle") ) {
	    shape = TRIANGLE;
	    return;
	}
	if( description.equalsIgnoreCase("circle") ) {
	    shape = CIRCLE;
	    return;
	}
	if( description.equalsIgnoreCase("hexagon") ) {
	    shape = HEXAGON;
	    return;
	}
	throw new IllegalArgumentException(description);
    }

    void setColor(String description) {
	if( description.equalsIgnoreCase("red") ) {
	    color = RED;
	    return;
	}
	if( description.equalsIgnoreCase("green") ) {
	    color = GREEN;
	    return;
	}
	if( description.equalsIgnoreCase("blue") ) {
	    color = BLUE;
	    return;
	}
	if( description.equalsIgnoreCase("yellow") ) {
	    color = YELLOW;
	    return;
	}
	throw new IllegalArgumentException(description);
    }

    void setHole(String description) {
	if( description.equalsIgnoreCase("hole") ) {
	    hole = true;
	    return;
	}
	if( description.equalsIgnoreCase("solid") ) {
	    hole = false;
	    return;
	}
	throw new IllegalArgumentException(description);
    }

    void setSize(String description) {
	if( description.equalsIgnoreCase("large") ) {
	    isLarge = true;
	    return;
	}
	if( description.equalsIgnoreCase("small") ) {
	    isLarge = false;
	    return;
	}
	throw new IllegalArgumentException(description);
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
	if( !hole ) {
	    description += "solid ";
	}
	switch(color) {
	case RED:
	    description += "red ";
	    break;
	case BLUE:
	    description += "blue ";
	    break;
	case GREEN:
	    description += "green ";
	    break;
	case YELLOW:
	    description += "yellow ";
	    break;
	default:
	    description += "NO COLOR";
	}
	switch(shape) {
	case SQUARE:
	    description += "square";
	    break;
	case TRIANGLE:
	    description += "triangle";
	    break;
	case CIRCLE:
	    description += "circle";
	    break;
	case HEXAGON:
	    description += "hexagon";
	    break;
	default:
	    description += "{NO SHAPE}";
	}
	if( hole ) {
	    description += " with a hole in it.";
	} else {
	    description += ".";
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

    // Constructor
    public GamePiece(String newSize, String newColor,
		     String newShape, String newHole) {
	setSize(newSize);
	setColor(newColor);
	setShape(newShape);
	setHole(newHole);
    }

}
