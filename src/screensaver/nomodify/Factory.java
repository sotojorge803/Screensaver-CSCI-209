package screensaver.nomodify;

import java.util.Random;

/**
 * An abstract command class that creates Mover subclasses.
 * 
 * @author Robert C Duvall
 */
public abstract class Factory {
	// generates a series of random numbers
	private static final Random ourGenerator = new Random();

	// name of this factory
	private String myName;

	/**
	 * Create a factory with the given name.
	 * 
	 * @param name
	 *            of this factory
	 */
	public Factory(String name) {
		myName = name;
	}

	/**
	 * Reports the name of this factory (displayed on the button used to
	 * activate it)
	 * 
	 * @return name of this factory
	 */
	public String getName() {
		return myName;
	}

	/**
	 * Subclasses determine how to create the movers and add them to the canvas
	 * 
	 * @param target
	 *            canvas that will display created movers
	 * @param numberToCreate
	 *            number of movers to create
	 */
	public abstract void createMovers(Canvas target, int numberToCreate);

	/**
	 * Allow subclasses convenient access to a random value.
	 * 
	 * @return random number between min and max, inclusive
	 */
	public int nextIntInRange(int min, int max) {
		return ourGenerator.nextInt(max - min + 1) + min;
	}
}
