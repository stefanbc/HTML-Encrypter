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
import java.awt.event.*;
import javax.swing.*;

/**
 * This class allows the user to specify a certain line and then highlight it
 * 
 * @author Stefan Cosma
 * 
 */
public class gotoLine {

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public gotoLine() {
		final JFrame gotoL = new JFrame("Go to line");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();

		ComponentMover cm = new ComponentMover();
		cm.registerComponent(gotoL);

		JLabel title = new JLabel("");
		JButton exit = new JButton("");

		JLabel gotol = new JLabel("Go to line:");
		final JTextField gotof = new JTextField(30);
		JButton gotoB = new JButton("Find");

		gotoL.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new GridLayout(1, 3, 0, 0));
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());
		pan5.setLayout(new FlowLayout());

		gotoL.add(pan3, BorderLayout.WEST);
		gotoL.add(pan1, BorderLayout.NORTH);
		pan1.add(title);
		pan1.add(Box.createHorizontalStrut(250));
		pan1.add(exit);
		gotoL.add(pan2, BorderLayout.CENTER);
		pan2.add(gotol);
		pan2.add(gotof);
		pan2.add(gotoB);
		gotoL.add(pan4, BorderLayout.EAST);
		gotoL.add(pan5, BorderLayout.SOUTH);

		gotoL.setSize(340, 80);
		gotoL.setLocationRelativeTo(Encrypter.Center);
		gotoL.setResizable(false);
		gotoL.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		gotoL.setUndecorated(true);
		gotoL.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		gotoL.setVisible(true);

		Color color = Encrypter.color_light;

		gotoL.setBackground(color);
		pan1.setBackground(color);
		pan2.setBackground(color);
		pan3.setBackground(color);
		pan4.setBackground(color);
		pan5.setBackground(color);

		pan2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		gotof.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		gotof.setBackground(Encrypter.color_light);

		gotol.setForeground(Encrypter.color_black);
		gotol.setForeground(Encrypter.color_blue);
		gotol.setFont(Encrypter.font16);

		gotoB.setBackground(color);
		gotoB.setBorder(BorderFactory.createEmptyBorder());
		gotoB.setForeground(Encrypter.color_black);
		gotoB.setFont(Encrypter.font16);

		ImageIcon title_Icon = getImageIcon("assets/icons/search.png");
		title.setIcon(title_Icon);
		title.setForeground(Encrypter.color_black);
		title.setFont(Encrypter.font16);

		ImageIcon exit_icon = getImageIcon("assets/icons/exit.png");
		exit.setBackground(Encrypter.color_light);
		exit.setBorder(BorderFactory.createLineBorder(Encrypter.color_dark, 0));
		exit.setForeground(Encrypter.color_black);
		exit.setFont(Encrypter.font16);
		exit.setIcon(exit_icon);
		exit.setToolTipText("Exit");

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gotoL.dispose();
			}
		});

		gotoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = gotof.getText();
				int index = Integer.parseInt(str);
				Encrypter.TA.setCaretPosition(Encrypter.TA.getDocument()
						.getDefaultRootElement().getElement(index - 2)
						.getStartOffset());
				Encrypter.TA.requestFocusInWindow();
				gotoL.dispose();
			}

		});
	}
}
