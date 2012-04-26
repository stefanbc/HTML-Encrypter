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
 * The class for the search and replace window
 * 
 * @author Stefan Cosma
 * 
 */
public class inFind {

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public inFind() {
		final JFrame inFind = new JFrame("Find string");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel inpan1 = new JPanel();
		JPanel inpan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();

		ComponentMover cm = new ComponentMover();
		cm.registerComponent(inFind);

		JLabel title = new JLabel("");
		JButton exit = new JButton("");

		JLabel find = new JLabel("Find string:");
		JLabel replace = new JLabel("Replace string: ");

		final JTextField replacef = new JTextField(30);
		final JTextField findf = new JTextField(30);
		JButton findB = new JButton("Find");
		JButton replaceB = new JButton("Replace");

		inFind.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new BorderLayout());
		inpan1.setLayout(new GridLayout(2, 2, 0, 10));
		inpan2.setLayout(new FlowLayout());
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());

		inFind.add(pan3, BorderLayout.EAST);
		inFind.add(pan1, BorderLayout.NORTH);
		pan1.add(title);
		pan1.add(Box.createHorizontalStrut(210));
		pan1.add(exit);
		inFind.add(pan2, BorderLayout.CENTER);
		pan2.add(inpan1, BorderLayout.NORTH);
		inpan1.add(find);
		inpan1.add(findf);
		inpan1.add(replace);
		inpan1.add(replacef);
		pan2.add(inpan2, BorderLayout.SOUTH);
		inpan2.add(findB);
		inpan2.add(Box.createHorizontalStrut(30));
		inpan2.add(replaceB);
		inFind.add(pan4, BorderLayout.WEST);

		inFind.setSize(300, 150);
		inFind.setLocationRelativeTo(Encrypter.Center);
		inFind.setResizable(false);
		inFind.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		inFind.setUndecorated(true);
		inFind.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		inFind.setVisible(true);

		Color color = Encrypter.color_light;

		inFind.setBackground(color);
		pan1.setBackground(color);
		pan2.setBackground(color);
		inpan1.setBackground(color);
		inpan2.setBackground(color);
		pan3.setBackground(color);
		pan4.setBackground(color);

		pan2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		findf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		findf.setBackground(Encrypter.color_light);
		replacef.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		replacef.setBackground(Encrypter.color_light);

		find.setForeground(Encrypter.color_blue);
		find.setFont(Encrypter.font16);

		replace.setForeground(Encrypter.color_blue);
		replace.setFont(Encrypter.font16);

		findB.setBackground(color);
		findB.setBorder(BorderFactory.createEmptyBorder());
		findB.setForeground(Encrypter.color_black);
		findB.setFont(Encrypter.font16);

		replaceB.setBackground(color);
		replaceB.setBorder(BorderFactory.createEmptyBorder());
		replaceB.setForeground(Encrypter.color_black);
		replaceB.setFont(Encrypter.font16);

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
				inFind.dispose();
			}
		});

		findB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = Encrypter.TA.getText().trim();
				String searchstr = findf.getText();
				int index = s.indexOf(searchstr);
				if (index != 0) {
					Encrypter.TA.setSelectionStart(index);
					Encrypter.TA.setSelectionEnd(index + searchstr.length());
					Encrypter.TA.requestFocusInWindow();
					inFind.dispose();
				}
			}
		});

		replaceB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = findf.getText();
				int start = Encrypter.TA.getText().indexOf(from);
				if (start >= 0 && from.length() > 0)
					Encrypter.TA.replaceRange(replacef.getText(), start, start
							+ from.length());
			}
		});
	}
}