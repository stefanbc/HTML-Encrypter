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
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class pAbout{
		
	// Fereastra despre
	public pAbout() {
		final JFrame aboutf = new JFrame("About");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
				
		//mutare fereastra
		ComponentMover cm = new ComponentMover();
		cm.registerComponent(aboutf);
		
		File file = new File("Crawler.jar");
		long lastModified = file.lastModified(); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date(lastModified); 
		
		final String link = "http://htmlencrypter.call-to-action.ro";
		JLabel ico = new JLabel();
		JLabel name = new JLabel("<html><b>Name: </b>" + "HTML Encrypter</html>");
		JLabel autor = new JLabel("<html><b>Author: </b>" + "Stefan Cosma</html>");
		JLabel versiune = new JLabel("<html><b>Version: </b>" + "1.9.0_" + sdf.format(date) + "</html>");
		final JLabel email = new JLabel("<html><b>Email: </b>steficosma@yahoo.com</html>");
		final JLabel url = new JLabel("<html><b>URL: </b>" + "<a href='"+ link +"'>www.htmlencrypter.ro</a></html>");
		JButton exit = new JButton(" X ");
		
		JLabel logo = new JLabel();
		ImageIcon logoico = new ImageIcon("resources/logo_main.png");
		
		aboutf.setSize(580,320);
		aboutf.setLocationRelativeTo(Crawler.Crw);
		aboutf.setResizable(false);
		aboutf.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png"));
		aboutf.setUndecorated(true);
		aboutf.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		aboutf.setVisible(true);

		pan1.setLayout(new FlowLayout());
		pan1.setBackground(Color.WHITE);
		pan2.setLayout(new GridLayout(5,0));
		pan2.setBackground(Color.WHITE);
		pan3.setLayout(new FlowLayout());
		pan3.setBackground(Color.WHITE);
		pan4.setLayout(new FlowLayout());
		pan4.setBackground(Color.WHITE);
		aboutf.setLayout(new BorderLayout());
		aboutf.setBackground(Color.WHITE);
		
		aboutf.add(pan3,BorderLayout.WEST);
			pan3.add(logo);
		aboutf.add(pan1,BorderLayout.NORTH);
//			pan1.add(ico);
			pan1.add(Box.createHorizontalStrut(540));
			pan1.add(exit);
		aboutf.add(pan2,BorderLayout.CENTER);
			pan2.add(name);
			pan2.add(autor);
			pan2.add(versiune);
			pan2.add(email);
			pan2.add(url);
		aboutf.add(pan4,BorderLayout.EAST);

		ico.setIcon(new ImageIcon("resources/icons/menu/about.png"));
		logo.setIcon(logoico);
		name.setFont(new Font("Arial", Font.PLAIN, 16));
		name.setForeground(Color.BLACK);
		autor.setFont(new Font("Arial", Font.PLAIN, 16));
		autor.setForeground(Color.BLACK);
		versiune.setFont(new Font("Arial", Font.PLAIN, 16));
		versiune.setForeground(Color.BLACK);
		email.setFont(new Font("Arial", Font.PLAIN, 16));
		email.setForeground(Color.BLACK);
		url.setFont(new Font("Arial", Font.PLAIN, 16));
		url.setBackground(Color.WHITE);
		url.setForeground(Color.BLACK);
	    url.setBorder(BorderFactory.createEmptyBorder());
	    url.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setBackground(Color.WHITE);
		exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Arial",Font.BOLD,14));
//		logo.setBorder(BorderFactory.createMatteBorder(0,0,0,2,Color.BLACK));
		pan2.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aboutf.dispose();	
			}
		});
		
		url.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {BrowserLaunch.openURL(link);}

		});
		
		aboutf.getContentPane().setBackground(Color.WHITE);
		
	}
}
