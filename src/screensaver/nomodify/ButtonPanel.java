package screensaver.nomodify;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The collection of buttons to apply commands to the active canvas.
 * 
 * @author Robert C Duvall
 */
public class ButtonPanel extends JPanel {
	// other user interface components
	private Canvas myView;
	private RangeSlider mySlider;

	/**
	 * Create a button panel to act on the given target.
	 * 
	 * @param target
	 *            canvas upon which commands act on
	 * @param input
	 *            component that provides additional input to commands
	 */
	public ButtonPanel(Canvas target, RangeSlider input) {
		myView = target;
		mySlider = input;
	}

	/**
	 * Create a button for the given command.
	 * 
	 * @param factory
	 *            command to activate when button is pushed
	 */
	public void add(final Factory factory) {
		JButton b = new JButton(factory.getName());
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.clear();
				factory.createMovers(myView, mySlider.getValue());
				myView.repaint();
			}
		});
		add(b);
	}
}
