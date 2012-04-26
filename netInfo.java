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
 * This class opens the window that shows the system information.
 * 
 * @author Stefan Cosma
 * 
 */
public class netInfo {

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	static JLabel win = new JLabel("", JLabel.CENTER);
	static JLabel ver = new JLabel("", JLabel.CENTER);
	static JLabel ip = new JLabel("", JLabel.CENTER);
	static JLabel name = new JLabel("", JLabel.CENTER);
	static JLabel arch = new JLabel("", JLabel.CENTER);
	static JLabel java = new JLabel("", JLabel.CENTER);

	public netInfo() {
		final JFrame netInfo = new JFrame("System Information");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();

		ComponentMover cm = new ComponentMover();
		cm.registerComponent(netInfo);

		JLabel title = new JLabel("System Information");
		JButton exit = new JButton("");

		netInfo.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new GridLayout(6, 0));
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());

		netInfo.add(pan3, BorderLayout.EAST);
		netInfo.add(pan1, BorderLayout.NORTH);
		pan1.add(title);
		pan1.add(Box.createHorizontalStrut(80));
		pan1.add(exit);
		netInfo.add(pan2, BorderLayout.CENTER);
		pan2.add(win);
		pan2.add(ver);
		pan2.add(arch);
		pan2.add(ip);
		pan2.add(name);
		pan2.add(java);
		netInfo.add(pan4, BorderLayout.WEST);

		netInfo.setSize(300, 170);
		netInfo.setLocationRelativeTo(Encrypter.Center);
		netInfo.setResizable(false);
		netInfo.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		netInfo.setUndecorated(true);
		netInfo.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		netInfo.setVisible(true);

		netInfo.setBackground(Encrypter.color_light);
		pan1.setBackground(Encrypter.color_light);
		pan2.setBackground(Encrypter.color_light);
		pan3.setBackground(Encrypter.color_light);
		pan4.setBackground(Encrypter.color_light);

		ver.setForeground(Encrypter.color_black);
		ver.setFont(Encrypter.font16);
		win.setForeground(Encrypter.color_black);
		win.setFont(Encrypter.font16);
		ip.setForeground(Encrypter.color_black);
		ip.setFont(Encrypter.font16);
		name.setForeground(Encrypter.color_black);
		name.setFont(Encrypter.font16);
		arch.setForeground(Encrypter.color_black);
		arch.setFont(Encrypter.font16);
		java.setForeground(Encrypter.color_black);
		java.setFont(Encrypter.font16);

		ImageIcon title_Icon = getImageIcon("assets/icons/network.png");
		title.setIcon(title_Icon);
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
				netInfo.dispose();
			}
		});
	}
}
