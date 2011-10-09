package Proiect;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class helpBox{
	
	private static final long serialVersionUID = 1L;

	// HelpBox
	public helpBox() throws IOException{
		final JFrame helpbox = new JFrame("Help");
		
		//muta fereastra
		ComponentMover cm = new ComponentMover();
		cm.registerComponent(helpbox);
		
		JLabel label = new JLabel("Help");
		JButton exit = new JButton(" X ");
		JTextArea text = new JTextArea(27,32);
		JScrollPane scrol = new JScrollPane(text);		

		helpbox.setSize(400, 500);
		helpbox.setLocationRelativeTo(Crawler.Crw);
		helpbox.setResizable(false);
		helpbox.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png"));
		helpbox.setUndecorated(true);
		helpbox.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		helpbox.setVisible(true);

		helpbox.setLayout(new FlowLayout());
		helpbox.add(label);
		helpbox.add(Box.createHorizontalStrut(280));
		helpbox.add(exit);
		helpbox.add(scrol);
		
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setIcon(new ImageIcon("resources/icons/menu/help.png"));
		text.setEditable(false);
		text.setSelectionColor(Color.BLACK);
		text.setSelectedTextColor(Color.WHITE);
		scrol.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrol.setViewportBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		exit.setBackground(Color.WHITE);
		exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Arial",Font.BOLD,14));
		
		try {
			FileReader file = new FileReader("resources/helpBox.txt");
			BufferedReader buff = new BufferedReader(file);
			String line = null;
			while ((line = buff.readLine()) != null){
            	text.append(line);
                text.append("\n");
            }
            buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				helpbox.dispose();	
			}
		});
		
		helpbox.getContentPane().setBackground(Color.WHITE);
	}
}
