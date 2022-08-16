package screensaver;

import java.awt.*;
import javax.swing.*;

import screensaver.factory.BouncerFactory;
import screensaver.nomodify.ButtonPanel;
import screensaver.nomodify.Canvas;
import screensaver.nomodify.RangeSlider;

/**
 * Creates a window that can be moved, resized, inconified, and closed by the
 * user.
 * 
 * @author Robert C. Duvall
 */
public class Main {
	// constants
	public static final Dimension SIZE = new Dimension(800, 600);

	public static final String TITLE = "Screen Savers!";

	public static final String SLIDER_LABEL = "Number of shapes to create";

	public static void main(String args[]) {
		// create container to display animations
		Canvas display = new Canvas(SIZE);
		display.setPreferredSize(SIZE);

		// create user interface controls
		RangeSlider slider = new RangeSlider(SLIDER_LABEL, 4, 256);
		ButtonPanel commands = new ButtonPanel(display, slider);

		// add screensaver buttons
		commands.add(new BouncerFactory());

		// create container that will work with Window manager
		JFrame frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add our user interface components to Frame and show it
		frame.getContentPane().add(commands, BorderLayout.NORTH);
		frame.getContentPane().add(display, BorderLayout.CENTER);
		frame.getContentPane().add(slider, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}
