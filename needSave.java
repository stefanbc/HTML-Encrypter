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
import java.io.*;
import javax.swing.*;

/**
 * This class displays a dialog box if the file needs to be saved
 * 
 * @author Stefan Cosma
 * 
 */
public class needSave extends JFrame {
	private static final long serialVersionUID = 1L;

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public needSave() {
		final JFrame needSave = new JFrame("Save file");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel inpan1 = new JPanel();
		JPanel inpan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();

		ComponentMover cm = new ComponentMover();
		cm.registerComponent(needSave);

		JLabel title = new JLabel("");
		JButton exit = new JButton("");

		JButton okB = new JButton("Ok");
		JButton cancelB = new JButton("Exit");

		JLabel text = new JLabel("Do you want to save the file before exit?");

		needSave.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new BorderLayout());
		inpan1.setLayout(new GridBagLayout());
		inpan2.setLayout(new FlowLayout());
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());

		needSave.add(pan3, BorderLayout.EAST);
		needSave.add(pan1, BorderLayout.NORTH);
		pan1.add(title);
		pan1.add(Box.createHorizontalStrut(230));
		pan1.add(exit);
		needSave.add(pan2, BorderLayout.CENTER);
		pan2.add(inpan1, BorderLayout.NORTH);
		inpan1.add(text);
		pan2.add(inpan2, BorderLayout.SOUTH);
		inpan2.add(okB);
		inpan2.add(Box.createHorizontalStrut(30));
		inpan2.add(cancelB);
		needSave.add(pan4, BorderLayout.WEST);

		needSave.setSize(320, 120);
		needSave.setLocationRelativeTo(Encrypter.Center);
		needSave.setResizable(false);
		needSave.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		needSave.setUndecorated(true);
		needSave.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		needSave.setVisible(true);

		Color color = Encrypter.color_light;

		needSave.setBackground(color);
		pan1.setBackground(color);
		pan2.setBackground(color);
		inpan1.setBackground(color);
		inpan2.setBackground(color);
		pan3.setBackground(color);
		pan4.setBackground(color);

		pan2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		okB.setBackground(color);
		okB.setBorder(BorderFactory.createEmptyBorder());
		okB.setForeground(Encrypter.color_black);
		okB.setFont(Encrypter.font16);

		cancelB.setBackground(color);
		cancelB.setBorder(BorderFactory.createEmptyBorder());
		cancelB.setForeground(Encrypter.color_black);
		cancelB.setFont(Encrypter.font16);

		ImageIcon title_Icon = getImageIcon("assets/icons/save.png");
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
				needSave.dispose();
			}
		});

		okB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				needSave.dispose();
				save();
			}
		});

		cancelB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * Save the source code
	 */
	public void save() {
		try {
			String s = Encrypter.TA.getText();
			if (s.length() > 0) {
				FileDialog fd = new FileDialog(this, "Save File",
						FileDialog.SAVE);
				if (Encrypter.inFile != null) {
					fd.setFile(Encrypter.inFile
							.getName()
							.substring(0, Encrypter.inFile.getName().length() - 5)
							.toString()
							+ "_en.html");
				} else {
					fd.setFile("file_en.html");
				}
				fd.setDirectory(".");
				fd.setVisible(true);
				fd.setLocationRelativeTo(null);
				String path = fd.getDirectory() + fd.getFile();

				if (Encrypter.miOpenURL.isSelected()) {
					if (fd.getFile() == null) {
						System.exit(0);
					} else {
						BrowserLaunch.openURL(path);
					}
				}

				if (fd.getFile() == null) {
					return;
				} else {
					FileOutputStream fos = new FileOutputStream(path);
					byte[] b = s.getBytes();
					fos.write(b);
					fos.close();
					System.exit(0);
				}
			}
		} catch (Exception e) {
		}
	}
}
