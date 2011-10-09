package Proiect;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class inFind {
	
	public inFind(){
		final JFrame inFind = new JFrame("Find string");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
			JPanel inpan1 = new JPanel();
			JPanel inpan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		
		//muta fereastra
		ComponentMover cm = new ComponentMover();
		cm.registerComponent(inFind);
		
		JLabel title = new JLabel("Find/Replace");
		JButton exit = new JButton(" X ");
		
		JLabel find = new JLabel("Find string:");
		JLabel replace = new JLabel("Replace string: ");
		
		
		final JTextField replacef = new JTextField(30);
		final JTextField findf = new JTextField(30);
		JButton findB = new JButton("Find");
		JButton replaceB = new JButton("Replace");
		
		inFind.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new BorderLayout());
			inpan1.setLayout(new GridLayout(2,2,0,10));
			inpan2.setLayout(new FlowLayout());
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());
		
		inFind.add(pan3,BorderLayout.EAST);
		inFind.add(pan1,BorderLayout.NORTH);
			pan1.add(title);
			pan1.add(Box.createHorizontalStrut(110));
			pan1.add(exit);
			inFind.add(pan2,BorderLayout.CENTER);
			pan2.add(inpan1,BorderLayout.NORTH);
				inpan1.add(find);
				inpan1.add(findf);
				inpan1.add(replace);
				inpan1.add(replacef);
			pan2.add(inpan2,BorderLayout.SOUTH);
				inpan2.add(findB);
				inpan2.add(Box.createHorizontalStrut(30));
				inpan2.add(replaceB);
		inFind.add(pan4,BorderLayout.WEST);
				
		inFind.setSize(300, 130);
		inFind.setLocationRelativeTo(Crawler.Crw);
		inFind.setResizable(false);
		inFind.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png"));
		inFind.setUndecorated(true);
		inFind.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		inFind.setVisible(true);
		
		Color color = Color.WHITE;
		
		inFind.setBackground(color);
		pan1.setBackground(color);
		pan2.setBackground(color);
		inpan1.setBackground(color);
		inpan2.setBackground(color);
		pan3.setBackground(color);
		pan4.setBackground(color);
		
		pan2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		findf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		replacef.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		find.setForeground(Color.BLACK);
		find.setFont(new Font("Arial", Font.BOLD, 14));
		
		replace.setForeground(Color.BLACK);
		replace.setFont(new Font("Arial", Font.BOLD, 14));
		
		findB.setBackground(color);
		findB.setBorder(BorderFactory.createEmptyBorder());
		findB.setForeground(Color.BLACK);
		findB.setFont(Crawler.font16);
		
		replaceB.setBackground(color);
		replaceB.setBorder(BorderFactory.createEmptyBorder());
		replaceB.setForeground(Color.BLACK);
		replaceB.setFont(Crawler.font16);
		
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setIcon(new ImageIcon("resources/icons/menu/search.png"));
		exit.setBackground(Color.WHITE);
		exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Arial",Font.BOLD,14));
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inFind.dispose();	
			}
		});
		
		findB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = Crawler.TA.getText().trim();
				String searchstr = findf.getText();
				int index = s.indexOf(searchstr);
				if (index != 0) {
					Crawler.TA.setSelectionStart(index);
					Crawler.TA.setSelectionEnd(index + searchstr.length());
					Crawler.TA.requestFocusInWindow();
					inFind.dispose();
				}
			}
		});
		
		replaceB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = findf.getText();
		        int start = Crawler.TA.getText().indexOf(from);
		        if (start >= 0 && from.length() > 0)
		        	Crawler.TA.replaceRange(replacef.getText(), start, start + from.length());
			}
		});
	}
}