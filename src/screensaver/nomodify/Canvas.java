package screensaver.nomodify;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import screensaver.mover.Mover;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates objects moving around in a bounded environment. *
 * 
 * @author Robert C. Duvall
 */
public class Canvas extends JPanel implements ActionListener {
	// things that will be animated
	private List<Mover> myMovers;

	// animate 25 times per second if possible
	public static final int DEFAULT_DELAY = 1000 / 25; // in milliseconds

	/**
	 * Construct panel so that it knows its center position
	 */
	public Canvas(Dimension size) {
		// distinguish canvas from the rest of the window
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		// initialize animation state
		myMovers = new ArrayList<Mover>();

		// create a timer to animate the canvas
		Timer timer = new Timer(DEFAULT_DELAY, this);
		// start the animation
		timer.start();
	}

	/**
	 * Remember given mover so it is painted on Canvas.
	 * 
	 * Note, movers are rendered in the order they are added.
	 * 
	 * @param m
	 *            mover to be added to those that are drawn
	 */
	public void add(Mover m) {
		myMovers.add(m);
	}

	/**
	 * Forget given mover so it is not painted on Canvas.
	 * 
	 * Note, movers are rendered in the order they are added.
	 * 
	 * @param m
	 *            mover to be added to those that are drawn
	 */
	public void remove(Mover m) {
		myMovers.remove(m);
	}

	/**
	 * Clear canvas of all shapes.
	 */
	public void clear() {
		myMovers.clear();
		repaint();
	}

	/**
	 * Never called by you directly, instead called by Java runtime when area of
	 * screen covered by this container needs to be displayed (i.e., creation,
	 * uncovering, change in status)
	 * 
	 * @param pen
	 *            smart pen to draw on the canvas with
	 */
	public void paintComponent(Graphics pen) {
		// clear the panel
		super.paintComponent(pen);

		// draw and update shapes
		Dimension bounds = getSize();
		for (Mover current : myMovers) {
			current.paint(pen);
			current.move(bounds);
		}

	}

	/**
	 * Never called by you directly, instead called by the Timer every few
	 * milli-seconds.
	 */
	public final void actionPerformed(ActionEvent evt) {
		// let Java runtime know panel needs to be repainted
		repaint();
	}

}
