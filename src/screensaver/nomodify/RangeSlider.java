package screensaver.nomodify;

import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.BorderFactory;

/**
 * A labelled slider that reports values within the given range, inclusive.
 * 
 * @author Robert C. Duvall
 */
public class RangeSlider extends JSlider {
	
	public RangeSlider(String title, int minValue, int maxValue) {
		super(minValue, maxValue, (minValue + maxValue) / 2);
		
		// label range reasonably
		Dictionary<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(minValue, new JLabel(Integer.toString(minValue)));
		labelTable.put(maxValue, new JLabel(Integer.toString(maxValue)));
		setLabelTable(labelTable);
		setPaintLabels(true);
		setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createEtchedBorder(), title));
	}
	
}
