package screensaver.mover;

import java.awt.*;

/**
 * Represents a shape that bounces around within the canvas.
 * 
 * @author Robert C. Duvall
 * 
 */
public class BouncingBall extends Mover {
	// there are 360 degrees in a circle
	private static final int NUM_DEGREES = 360;

	/**
	 * Construct a shape at the given position, with the given velocity, size, and
	 * color.
	 * 
	 * @param center    position of the shape
	 * @param size      dimensions of the shape
	 * @param speed     speed of the shape
	 * @param direction direction of the shape
	 * @param color     color of the shape
	 */
	public BouncingBall(Point center, Dimension size, int speed, int direction, Color color) {
		super(center, size, speed, direction, color);
	}

	/**
	 * Describes how to draw the shape on the screen.
	 * 
	 * Currently, draws the shape as a simple circle.
	 * 
	 * @param pen knows how to draw on the screen
	 */
	public void paint(Graphics pen) {
		pen.setColor(getColor());
		pen.fillOval(getLeft(), getTop(), getSize().width, getSize().height);
	}

	/**
	 * Describes how to "animate" the shape by changing its state.
	 * 
	 * Currently, moves the shape according to its velocity and keeps it within the
	 * bounds of the canvas.
	 * 
	 * @param bounds which encloses this shape
	 */
	public void move(Dimension bounds) {
		super.move(bounds);

		// bounce off the left or right walls
		if (myCenter.x <= mySize.width / 2) {
			bounceHorizontal();
			myCenter.x = mySize.width / 2;
		} else if (myCenter.x >= bounds.width - mySize.width / 2) {
			bounceHorizontal();
			myCenter.x = bounds.width - mySize.width / 2;
		}

		// bounce off the top or bottom walls
		if (myCenter.y <= mySize.height / 2) {
			direction = NUM_DEGREES - direction;
			myCenter.y = mySize.height / 2;
		} else if (myCenter.y >= bounds.height - mySize.height / 2) {
			direction = NUM_DEGREES - direction;
			myCenter.y = bounds.height - mySize.height / 2;
		}

	}

	/**
	 * Helper method for making ball bounce horizontally.
	 */
	private void bounceHorizontal() {
		if (direction < 180) {
			direction = 180 - direction;
		} else {
			direction = 180 - direction + NUM_DEGREES;
		}
	}
}
