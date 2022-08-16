package screensaver.mover;

import java.awt.*;
import java.util.Random;

/**
 * Represents a shape that moves on its own
 * 
 * @author Robert C. Duvall
 * 
 */
public abstract class Mover {

	protected Point myCenter;
	protected int speed;
	protected int direction;

	protected Dimension mySize;
	protected Color myColor;

	private static Random ourGenerator = new Random();

	/**
	 * Construct a shape at the given position, with the given velocity, size, and
	 * color.
	 * 
	 * @param center position of the shape
	 * @param size   dimensions of the shape
	 * @param speed  speed of the mover
	 * @param angle  direction of the mover (from 0 to 359)
	 * @param color  color of the shape
	 */
	public Mover(Point center, Dimension size, int speed, int angle, Color color) {
		myCenter = new Point(center.x, center.y);
		mySize = new Dimension(size.width, size.height);
		this.speed = speed;
		direction = angle;

		myColor = color;
	}

	/**
	 * Describes how to draw the shape on the screen.
	 * 
	 * @param pen knows how to draw me on the screen
	 */
	abstract public void paint(Graphics pen);

	/**
	 * Describes how to "animate" the shape by changing its state.
	 * 
	 * @param bounds which encloses this shape
	 */
	public void move(Dimension bounds) {
		int dx = Math.round((float) (speed * Math.cos(Math.toRadians(direction))));
		int dy = Math.round((float) (speed * Math.sin(Math.toRadians(direction))));

		myCenter.translate(dx, dy);
	}

	/**
	 * Reports shape's center.
	 * 
	 * @return center of shape
	 */
	public Point getCenter() {
		return myCenter;
	}

	/**
	 * Reports shape's left-most coordinate.
	 * 
	 * @return left-most coordinate
	 */
	public int getLeft() {
		return getCenter().x - getSize().width / 2;
	}

	/**
	 * Reports shape's top-most coordinate.
	 * 
	 * @return top-most coordinate
	 */
	public int getTop() {
		return getCenter().y - getSize().height / 2;
	}

	/**
	 * Reports shape's right-most coordinate.
	 * 
	 * @return right-most coordinate
	 */
	public int getRight() {
		return getCenter().x + getSize().width / 2;
	}

	/**
	 * Reports shape's bottom-most coordinate.
	 * 
	 * @return bottom-most coordinate
	 */
	public int getBottom() {
		return getCenter().y + getSize().height / 2;
	}

	/**
	 * Reports shape's size.
	 * 
	 * @return size of shape
	 */
	public Dimension getSize() {
		return mySize;
	}

	/**
	 * Returns the shape's color.
	 * 
	 * @return color of shape
	 */
	public Color getColor() {
		return myColor;
	}

	/**
	 * Return's the mover's speed.
	 * 
	 * @return the mover's speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Returns the angle in which the mover is moving.
	 * 
	 * @return the angle in which the mover is moving
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Returns a random angle between 0 and 359, inclusive
	 * 
	 * @return a random angle (between 0 and 359, inclusive)
	 */
	public static int generateRandomAngle() {
		return ourGenerator.nextInt(360);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Center: " + myCenter + "\n");
		sb.append("Speed: " + speed + "\n");
		sb.append("Direction: " + direction + "\n");
		return sb.toString();
	}

}
