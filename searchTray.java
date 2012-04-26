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

public class searchTray{

	static final JFrame searchTray = new JFrame("Search URL / URI");
	static JButton searchB = new JButton("");
	static final JTextField searchF = new JTextField("http://",50);
	
	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public searchTray() {
		
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();

		ComponentMover cm = new ComponentMover();
		cm.registerComponent(searchTray);

		JLabel title = new JLabel("Search URL / URI");
		JButton exit = new JButton("");

		searchTray.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new BorderLayout());
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());
		pan5.setLayout(new FlowLayout());

		searchTray.add(pan3, BorderLayout.WEST);
		searchTray.add(pan1, BorderLayout.NORTH);
		pan1.add(title);
		pan1.add(Box.createHorizontalStrut(190));
		pan1.add(exit);
		searchTray.add(pan2, BorderLayout.CENTER);
		pan2.add(Box.createHorizontalStrut(20),BorderLayout.WEST);
		pan2.add(searchF,BorderLayout.CENTER);
		pan2.add(searchB,BorderLayout.EAST);
		searchTray.add(pan4, BorderLayout.EAST);
		searchTray.add(pan5, BorderLayout.SOUTH);

		searchTray.setSize(360, 100);
		searchTray.setLocationRelativeTo(Encrypter.Center);
		searchTray.setResizable(false);
		searchTray.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		searchTray.setUndecorated(true);
		searchTray.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		searchTray.setVisible(true);

		searchTray.setBackground(Encrypter.color_light);
		pan1.setBackground(Encrypter.color_light);
		pan2.setBackground(Encrypter.color_light);
		pan3.setBackground(Encrypter.color_light);
		pan4.setBackground(Encrypter.color_light);
		pan5.setBackground(Encrypter.color_light);

		pan2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		searchF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		searchF.setBackground(Encrypter.color_light);
		
		ImageIcon but = getImageIcon("assets/icons/search.png");
		ImageIcon but_r = getImageIcon("assets/icons/search_r.png");
		searchB.setBackground(Encrypter.color_light);
		searchB.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		searchB.setForeground(Encrypter.color_white);
		searchB.setFont(Encrypter.font16);
		searchB.setToolTipText("Search URL / URI");
		searchB.setIcon(but);
		searchB.setPressedIcon(but_r);
		searchB.setRolloverIcon(but_r);
		searchB.setHorizontalTextPosition(AbstractButton.LEFT);
		searchB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		title.setForeground(Encrypter.color_blue);
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
				searchTray.dispose();
			}
		});
	}
}
