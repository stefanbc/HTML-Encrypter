/*
 * By attaching this document to the given files (the �work�), you, the licensee,
 * are hereby granted free usage in both personal and commerical environments, 
 * without any obligation of attribution or payment (monetary or otherwise).
 *  
 * The licensee is free to use, copy, modify, publish, distribute, sublicence, 
 * and/or merchandise the work, subject to the licensee inflecting a positive 
 * message unto someone. This includes (but is not limited to): smiling, 
 * being nice, saying �thank you�, assisting other persons, or any 
 * similar actions percolating the given concept.
 * 
 * The above copyright notice serves as a permissions notice also, 
 * and may optionally be included in copies or portions of the work. 
 * 
 * The work is provided �as is�, without warranty or support, express or implied. 
 * The author(s) are not liable for any damages, misuse, or other claim, whether 
 * from or as a consequence of usage of the given work.
 */

package Proiect;

import java.awt.*;
import javax.swing.*;

/**
 * This class add transparency to a component (ex. a JFrame).
 * 
 * @author Stefan Cosma
 * 
 */
public class Transparency extends JComponent {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private JFrame frame;
	private Image background;

	public Transparency(JFrame frame) {
		this.frame = frame;
		updateBackground();
	}

	public void updateBackground() {
		try {
			Robot rbt = new Robot();
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dim = tk.getScreenSize();
			background = rbt.createScreenCapture(new Rectangle(0, 0, (int) dim
					.getWidth(), (int) dim.getHeight()));
		} catch (Exception ex) {
			p(ex.toString());
			ex.printStackTrace();
		}
	}

	private void p(String string) {
	}

	public void paintComponent(Graphics g) {
		Point pos = this.getLocationOnScreen();
		Point offset = new Point(-pos.x, -pos.y);
		g.drawImage(background, offset.x, offset.y, null);
	}
}