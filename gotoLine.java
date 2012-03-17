/*
 * By attaching this document to the given files (the “work”), you, the licensee,
 * are hereby granted free usage in both personal and commerical environments, 
 * without any obligation of attribution or payment (monetary or otherwise).
 *  
 * The licensee is free to use, copy, modify, publish, distribute, sublicence, 
 * and/or merchandise the work, subject to the licensee inflecting a positive 
 * message unto someone. This includes (but is not limited to): smiling, 
 * being nice, saying “thank you”, assisting other persons, or any 
 * similar actions percolating the given concept.
 * 
 * The above copyright notice serves as a permissions notice also, 
 * and may optionally be included in copies or portions of the work. 
 * 
 * The work is provided “as is”, without warranty or support, express or implied. 
 * The author(s) are not liable for any damages, misuse, or other claim, whether 
 * from or as a consequence of usage of the given work.
 */

package Proiect;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gotoLine {
	
	public gotoLine() {
		final JFrame gotoL = new JFrame("Line");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();

		// muta fereastra
		ComponentMover cm = new ComponentMover();
		cm.registerComponent(gotoL);

		JLabel title = new JLabel("Go to line");
		JButton exit = new JButton(" X ");

		JLabel gotol = new JLabel("Go to line:");
		final JTextField gotof = new JTextField(30);
		JButton gotoB = new JButton("Go");

		gotoL.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new GridLayout(1, 3,0,0));
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());
		pan5.setLayout(new FlowLayout());

		gotoL.add(pan3,BorderLayout.WEST);
		gotoL.add(pan1, BorderLayout.NORTH);
			pan1.add(title);
			pan1.add(Box.createHorizontalStrut(180));
			pan1.add(exit);
		gotoL.add(pan2, BorderLayout.CENTER);
			pan2.add(gotol);
			pan2.add(gotof);
			pan2.add(gotoB);
		gotoL.add(pan4,BorderLayout.EAST);
		gotoL.add(pan5,BorderLayout.SOUTH);

		gotoL.setSize(340, 75);
		gotoL.setLocationRelativeTo(Crawler.Crw);
		gotoL.setResizable(false);
		gotoL.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png"));
		gotoL.setUndecorated(true);
		gotoL.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		gotoL.setVisible(true);

		Color color = Color.WHITE;

		gotoL.setBackground(color);
		pan1.setBackground(color);
		pan2.setBackground(color);
		pan3.setBackground(color);
		pan4.setBackground(color);
		pan5.setBackground(color);

		pan2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		gotof.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		gotol.setForeground(Color.BLACK);
		gotol.setFont(new Font("Arial", Font.BOLD, 14));

		gotoB.setBackground(color);
		gotoB.setBorder(BorderFactory.createEmptyBorder());
		gotoB.setForeground(Color.BLACK);
		gotoB.setFont(Crawler.font16);

		title.setForeground(Color.BLACK);
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setIcon(new ImageIcon("resources/icons/menu/search.png"));
		exit.setBackground(Color.WHITE);
		exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Arial", Font.BOLD, 14));

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gotoL.dispose();
			}
		});
		
		gotoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = Crawler.TAlines.getText().trim();
				String searchstr = gotof.getText();
				int index = s.indexOf(searchstr);
				if (index != 0) {
					Crawler.TAlines.setSelectionStart(index);
					Crawler.TAlines.setSelectionEnd(index + (searchstr.length()+2));				
					Crawler.TAlines.requestFocusInWindow();
					gotoL.dispose();
				}
			}
		});
	}
}
