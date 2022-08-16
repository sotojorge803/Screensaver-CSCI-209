package screensaver.factory;

import java.awt.*;

import screensaver.mover.BouncingBall;
import screensaver.nomodify.Canvas;
import screensaver.nomodify.Factory;

/**
 * Creates any number of Bouncer objects "exploding" from the center of the
 * canvas.
 * 
 * @author Robert C. Duvall
 */
public class BouncerFactory extends Factory {

	/**
	 * Creates a BouncerFactory object (but doesn't start creating bouncers
	 * yet).
	 */
	public BouncerFactory() {
		super("Create Bouncers");
	}

	/**
	 * Creates given number of bouncers within the given canvas.
	 * 
	 * @param number
	 *            of bouncers to create
	 * @param canvas
	 *            within which bouncers should appear
	 */
	public void createMovers(Canvas canvas, int numberToCreate) {
		// current size of canvas
		Dimension bounds = canvas.getSize();

		// create each bouncer and add to list
		for (int i = 0; i < numberToCreate; i++) {
			int size = nextIntInRange(16, 48);

			Point center = new Point(bounds.width / 2, bounds.height / 2);
			Dimension ballSize = new Dimension(size, size);
			int speed = nextIntInRange(1, 12);
			int direction = BouncingBall.generateRandomAngle();
			Color ballColor = new Color(nextIntInRange(0, 255), nextIntInRange(
					0, 255), nextIntInRange(0, 255));

			canvas.add(new BouncingBall(center, ballSize, speed, direction,
					ballColor));
		}
	}
}
