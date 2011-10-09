package Proiect;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class netInfo {
	
	static JLabel win = new JLabel("",JLabel.CENTER);
	static JLabel ver = new JLabel("",JLabel.CENTER);
	static JLabel ip = new JLabel("",JLabel.CENTER);
	static JLabel name = new JLabel("",JLabel.CENTER);
	static JLabel arch = new JLabel("",JLabel.CENTER);
	static JLabel java = new JLabel("",JLabel.CENTER);
	
	public netInfo(){
		final JFrame netInfo = new JFrame("System Information");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		
		//muta fereastra
		ComponentMover cm = new ComponentMover();
		cm.registerComponent(netInfo);
		
		JLabel title = new JLabel("System Information");
		JButton exit = new JButton(" X ");
		
		netInfo.setLayout(new BorderLayout());
		pan1.setLayout(new FlowLayout());
		pan2.setLayout(new GridLayout(6,0));
		pan3.setLayout(new FlowLayout());
		pan4.setLayout(new FlowLayout());
		
		netInfo.add(pan3,BorderLayout.EAST);
		netInfo.add(pan1,BorderLayout.NORTH);
			pan1.add(title);
			pan1.add(Box.createHorizontalStrut(100));
			pan1.add(exit);
		netInfo.add(pan2,BorderLayout.CENTER);
			pan2.add(win);
			pan2.add(ver);
			pan2.add(arch);
			pan2.add(ip);
			pan2.add(name);
			pan2.add(java);
		netInfo.add(pan4,BorderLayout.WEST);
				
		netInfo.setSize(300, 170);
		netInfo.setLocationRelativeTo(Crawler.Crw);
		netInfo.setResizable(false);
		netInfo.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png"));
		netInfo.setUndecorated(true);
		netInfo.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		netInfo.setVisible(true);
		
		Color color = Color.WHITE;
		
		netInfo.setBackground(color);
		pan1.setBackground(color);
		pan2.setBackground(color);
		pan3.setBackground(color);
		pan4.setBackground(color);
		
		Color color1 = Color.BLACK;
		Font font = new Font("Arial", Font.PLAIN, 14);
		
		ver.setForeground(color1);
		ver.setFont(font);
		win.setForeground(color1);
		win.setFont(font);
		ip.setForeground(color1);
		ip.setFont(font);
		name.setForeground(color1);
		name.setFont(font);
		arch.setForeground(color1);
		arch.setFont(font);
		java.setForeground(color1);
		java.setFont(font);
		
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setIcon(new ImageIcon("resources/icons/menu/network.png"));
		exit.setBackground(Color.WHITE);
		exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Arial",Font.BOLD,14));
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				netInfo.dispose();	
			}
		});
		
	}	
}
