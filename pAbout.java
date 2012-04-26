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
 * This class opens the about window
 * 
 * @author Stefan Cosma
 *
 */
public class pAbout {

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public pAbout() {
		final JFrame aboutf = new JFrame("About");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();

		ComponentMover cm = new ComponentMover();
		cm.registerComponent(aboutf);

		final String link = "http://htmlencrypter.call-to-action.ro";
		JLabel name = new JLabel("<html><b>Name: </b>"
				+ "HTML Encrypter</html>");
		JLabel autor = new JLabel("<html><b>Author: </b>"
				+ "Stefan Cosma</html>");
		JLabel versiune = new JLabel("<html><b>Version: </b>"
				+ Encrypter.LB4.getText().toString() + "</html>");
		final JLabel url = new JLabel("<html><b>URL: </b>" + "<a href='" + link
				+ "'>www.htmlencrypter.ro</a></html>");
		JButton exit = new JButton("");
		JLabel logo = new JLabel();

		aboutf.setSize(400, 180);
		aboutf.setLocationRelativeTo(Encrypter.Center);
		aboutf.setResizable(false);
		aboutf.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		aboutf.setUndecorated(true);
		aboutf.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		aboutf.setVisible(true);

		pan1.setLayout(new BorderLayout());
		pan1.setBackground(Encrypter.color_light);

		pan2.setLayout(new GridLayout(4, 0));
		pan2.setBackground(Encrypter.color_light);
		pan2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

		pan3.setLayout(new FlowLayout());
		pan3.setBackground(Encrypter.color_light);

		pan4.setLayout(new FlowLayout());
		pan4.setBackground(Encrypter.color_light);

		aboutf.setLayout(new BorderLayout());
		aboutf.setBackground(Encrypter.color_light);

		aboutf.add(pan3, BorderLayout.WEST);
		pan3.add(logo);
		aboutf.add(pan1, BorderLayout.NORTH);
		pan1.add(Box.createHorizontalStrut(360), BorderLayout.WEST);
		pan1.add(exit, BorderLayout.CENTER);
		aboutf.add(pan2, BorderLayout.CENTER);
		pan2.add(name);
		pan2.add(autor);
		pan2.add(versiune);
		pan2.add(url);
		aboutf.add(pan4, BorderLayout.EAST);

		ImageIcon logo_Icon = getImageIcon("assets/logo.png");
		logo.setIcon(logo_Icon);

		name.setFont(Encrypter.font16);
		name.setForeground(Encrypter.color_black);

		autor.setFont(Encrypter.font16);
		autor.setForeground(Encrypter.color_black);

		versiune.setFont(Encrypter.font16);
		versiune.setForeground(Encrypter.color_black);

		url.setFont(Encrypter.font16);
		url.setBackground(Encrypter.color_white);
		url.setForeground(Encrypter.color_black);
		url.setBorder(BorderFactory.createEmptyBorder());
		url.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon exit_icon = getImageIcon("assets/icons/exit.png");
		exit.setBackground(Encrypter.color_light);
		exit.setBorder(BorderFactory.createLineBorder(Encrypter.color_dark, 0));
		exit.setForeground(Encrypter.color_black);
		exit.setFont(Encrypter.font16);
		exit.setIcon(exit_icon);
		exit.setToolTipText("Exit");

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aboutf.dispose();
			}
		});

		url.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				BrowserLaunch.openURL(link);
			}

		});

		aboutf.getContentPane().setBackground(Encrypter.color_white);

	}
}
