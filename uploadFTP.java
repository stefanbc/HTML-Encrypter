package Proiect;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.tree.*;

public class uploadFTP {
	
	final JFrame uploadFTP = new JFrame("FTP Transfer");
	final JFrame tree = new JFrame("Server documents");
	
	JFileChooser chooserf = new JFileChooser(".");
	JFileChooser loadf = new JFileChooser(".");
	public static FileDialog sd = null;
	
	String filename = null;
	String filepath = null;
	
	static JLabel titleFTP = new JLabel("FTP Transfer");
	public static JTextField adressf = new JTextField("localhost",35);
	public static JTextField userf = new JTextField("test",35);
	public static JPasswordField passf = new JPasswordField("admin",35);
	public static JTextField folderf = new JTextField(35);
				
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
		JPanel inpan1 = new JPanel();
		JPanel inpan2 = new JPanel();
			JPanel inpan21 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan4 = new JPanel();

	final JLabel adress = new JLabel("Server Address: ");
	final JLabel user = new JLabel("User: ");
	final JLabel pass = new JLabel("Password: ");
	final JLabel folder = new JLabel("Default Folder: ");
	final JLabel filen = new JLabel("File: ");
	final JLabel filenf = new JLabel();
	final JLabel status = new JLabel();

	JButton connect = new JButton("Transfer");
	JButton browsef = new JButton("Add..");
	JButton adv = new JButton(" > ");
	JButton save = new JButton("Save ID");
	JButton load = new JButton("Load ID");
	JButton exit = new JButton(" X ");
		
	final ComponentMover cm = new ComponentMover();		// muta fereastra
	Color color = Color.WHITE;
	
	public uploadFTP() {
		uploadFTP.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png"));
		uploadFTP.setUndecorated(true);
		uploadFTP.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		uploadFTP.setSize(400, 280);
		uploadFTP.setLocationRelativeTo(Crawler.Crw);
		uploadFTP.setResizable(false);
		uploadFTP.setVisible(true);
		cm.registerComponent(uploadFTP);
		
		uploadFTP.setLayout(new BorderLayout());
		pan1.setLayout(new BorderLayout());
		pan2.setLayout(new BorderLayout());
			inpan1.setLayout(new GridLayout(6, 2, 0, 10));
			inpan2.setLayout(new FlowLayout());
				inpan21.setLayout(new GridLayout(2,0,0,5));
		pan3.setLayout(new BorderLayout());
		pan4.setLayout(new FlowLayout());
		
		uploadFTP.add(pan3, BorderLayout.EAST);
			pan3.add(adv,BorderLayout.SOUTH);
		uploadFTP.add(pan1, BorderLayout.NORTH);
			pan1.add(titleFTP,BorderLayout.WEST);
			pan1.add(exit,BorderLayout.EAST);
		uploadFTP.add(pan2, BorderLayout.CENTER);
			pan2.add(inpan1, BorderLayout.NORTH);
				inpan1.add(adress);
				inpan1.add(adressf);
				inpan1.add(user);
				inpan1.add(userf);
				inpan1.add(pass);
				inpan1.add(passf);
				inpan1.add(folder);
				inpan1.add(folderf);
				inpan1.add(filen);
				inpan1.add(filenf);
				inpan1.add(status);
			pan2.add(inpan2, BorderLayout.SOUTH);
				inpan2.add(browsef);
				inpan2.add(Box.createHorizontalStrut(20));
				inpan2.add(inpan21);
					inpan21.add(save);
					inpan21.add(load);
				inpan2.add(Box.createHorizontalStrut(20));
				inpan2.add(connect);
		uploadFTP.add(pan4, BorderLayout.WEST);

		propFTP();
		actionFTP();
	}
	
	//proprietati elemente uploadFTP
	public void propFTP(){		
		uploadFTP.setBackground(color);
		pan1.setBackground(color);
		pan1.setBorder(BorderFactory.createEmptyBorder(6, 5, 10, 5));
		pan2.setBackground(color);
			inpan1.setBackground(color);
			inpan2.setBackground(color);
				inpan21.setBackground(color);
				inpan21.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		pan3.setBackground(color);
		pan4.setBackground(color);
				
		adress.setForeground(Color.BLACK);
		user.setForeground(Color.BLACK);
		pass.setForeground(Color.BLACK);
		folder.setForeground(Color.BLACK);
		filen.setForeground(Color.BLACK);
		
		adressf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		adressf.setSelectionColor(Color.BLACK);
		adressf.setSelectedTextColor(Color.WHITE);
		
		userf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		userf.setSelectionColor(Color.BLACK);
		userf.setSelectedTextColor(Color.WHITE);
		
		passf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		passf.setSelectionColor(Color.BLACK);
		passf.setSelectedTextColor(Color.WHITE);
		
		folderf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		folderf.setSelectionColor(Color.BLACK);
		folderf.setSelectedTextColor(Color.WHITE);
		
		status.setHorizontalAlignment(SwingConstants.RIGHT);
		
		titleFTP.setForeground(Color.BLACK);
		titleFTP.setFont(new Font("Arial", Font.BOLD, 14));
		titleFTP.setIcon(new ImageIcon("resources/icons/menu/upload.png"));

		connect.setBackground(color);
		connect.setBorder(BorderFactory.createEmptyBorder());
		connect.setForeground(Color.BLACK);
		connect.setFont(Crawler.font16);
		connect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		browsef.setBackground(color);
		browsef.setBorder(BorderFactory.createEmptyBorder());
		browsef.setForeground(Color.BLACK);
		browsef.setFont(Crawler.font16);
		browsef.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		exit.setBackground(Color.WHITE);
		exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Arial", Font.BOLD, 14));
		
		save.setBackground(Color.WHITE);
		save.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		save.setIcon(new ImageIcon("resources/icons/menu/save.png"));
		save.setForeground(Color.BLACK);
		save.setFont(new Font("Arial", Font.BOLD, 14));
		save.setToolTipText("<html>&#8226; Save login details</html>");
		save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		load.setBackground(Color.WHITE);
		load.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		load.setIcon(new ImageIcon("resources/icons/menu/load.png"));
		load.setForeground(Color.BLACK);
		load.setFont(new Font("Arial", Font.BOLD, 14));
		load.setToolTipText("<html>&#8226; Load login details</html>");
		load.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		adv.setBackground(Color.WHITE);
		adv.setBorder(BorderFactory.createMatteBorder(2,2,0,0, Color.BLACK));
		adv.setForeground(Color.BLACK);
		adv.setFont(new Font("Arial",Font.BOLD,14));
		adv.setToolTipText("<html>&#8226; Display server files</html>");
		adv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		chooserf.addChoosableFileFilter(new FileNameExtensionFilter("Text", "txt"));
	    chooserf.addChoosableFileFilter(new FileNameExtensionFilter("HTML", "html"));
	    chooserf.setAcceptAllFileFilterUsed(false);
	    loadf.addChoosableFileFilter(new FileNameExtensionFilter("HEU","heu"));
	    loadf.setAcceptAllFileFilterUsed(false);
		
	}
	
	//salvare detalii conectare
	public void saveUser(){
		try {
			String pass = String.valueOf(passf.getPassword());
			String adr = "Address:" + adressf.getText() + "\r\n";
			String usr = "User:" + userf.getText() + "\r\n";
			String pas = "Password:" + pass + "\r\n";
			if (adr.length() > 0 && usr.length() > 0) {
				sd = new FileDialog(sd, "Save Login Details",FileDialog.SAVE);
				sd.setFile(userf.getText() + "ID.heu");
				sd.setDirectory(".");
				sd.setVisible(true);
				sd.setLocationRelativeTo(null);
				String path = sd.getDirectory() + sd.getFile();
				FileOutputStream fos = new FileOutputStream(path);
				byte[] a = adr.getBytes();
				byte[] u = usr.getBytes();
				byte[] p = pas.getBytes();
				fos.write(a);
				fos.write(u);
				fos.write(p);
				fos.close();
			}
		} catch (Exception e1) {}
	}
	
	//incarcare detalii conectare
	public void loadUser() {
		adressf.setText("");
		userf.setText("");
		passf.setText("");
		String pass = String.valueOf(passf.getPassword());
		int retval = loadf.showOpenDialog(loadf);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File inFile = loadf.getSelectedFile();
            try {
                FileReader fr = new FileReader(inFile);
                BufferedReader bufRdr = new BufferedReader(fr);
                String line = null;
                while ((line = bufRdr.readLine()) != null){
                	if(line.startsWith("Address:" + adressf.getText())){
                		adressf.setText(line.toString().substring(7));
                	}
                	if(line.startsWith("User:" + userf.getText())){
                		userf.setText(line.toString().substring(5));
                	}
                	if(line.startsWith("Password:" + pass)){
                		passf.setText(line.toString().substring(7));
                	}
                }
                bufRdr.close();
            } catch (IOException ioex) {}
        }
    }
	
	//actiuni elemente uploadFTP
	public void actionFTP(){
		//schimbare text in adress textfiled si titlu in acelasi timp
		adressf.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				InetAddress thisIp;
				try {
					thisIp = InetAddress.getLocalHost();
					titleFTP.setText("FTP Transfer: " + thisIp.getHostAddress() + " -> " + adressf.getText());
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
			}
		});
			    
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uploadFTP.dispose();
				tree.dispose();
			}
		});

		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				saveUser();
			}
		});
		
		load.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				loadUser();
			}
		});
		
		connect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FTPClient client = new FTPClient();
				FileInputStream fis = null;
				String pass = String.valueOf(passf.getPassword());
				try {
					if(filename == null){
						status.setText("File does not exist!");
					}
					else{
						client.connect(adressf.getText());						//adresa
						client.login(userf.getText(),pass);						//user si parola
						if(client.isConnected()){
							status.setText("Succesfull transfer!");
							client.setFileType(FTP.BINARY_FILE_TYPE);			//tipul fisierului
							File file = new File(filepath);						//locatia fisierului
							fis = new FileInputStream(file);					//deschide un stream pentru fisier
							client.changeWorkingDirectory(folderf.getText());	//schimba directorul pe server
							client.storeFile(filename, fis);					//retine fisierul pe server
						}
						else{
							status.setText("Filed transfer!");
						}
					}
					client.logout();
				} 
				catch (IOException e1){
					Crawler.printException(e1);
				} 
				finally {
					try {
						if (fis != null) {fis.close();
						}
						client.disconnect();
					} catch (IOException e1){
						Crawler.printException(e1);
					}
				}
			}
		});
		
		browsef.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int retval = chooserf.showOpenDialog(chooserf);
			    if (retval == JFileChooser.APPROVE_OPTION) {
			    	   status.setText("");
			           filename = chooserf.getSelectedFile().getName().toString();
			           filepath = chooserf.getSelectedFile().getPath();
			           filenf.setText(chooserf.getSelectedFile().getName().toString());
			    }
			}
		});
		
		adv.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				tree.setSize(220,uploadFTP.getHeight());
				tree.setLocation(uploadFTP.getX() + 405, uploadFTP.getY());
				tree.setResizable(false);
				tree.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png"));
				tree.setUndecorated(true);
				tree.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				tree.setVisible(true);
				tree.setLayout(new BorderLayout());
				
				JLabel labeltree = new JLabel("Server documents");
				labeltree.setOpaque(true);
				labeltree.setBackground(Color.WHITE);
				labeltree.setBorder(BorderFactory.createMatteBorder(8, 10, 10, 0, Color.WHITE));
				labeltree.setForeground(Color.BLACK);
				labeltree.setFont(new Font("Arial", Font.BOLD, 14));
				
				JButton refresh = new JButton("Refresh");
				refresh.setBackground(Color.WHITE);
				refresh.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
				refresh.setForeground(Color.BLACK);
				refresh.setFont(Crawler.font16);
				
				final FTPClient client = new FTPClient();
				DefaultMutableTreeNode top = new DefaultMutableTreeNode(adressf.getText());
				DefaultMutableTreeNode files = null;
				DefaultMutableTreeNode leaf = null;
				
				final JTree tree_view = new JTree(top);
				tree_view.setForeground(Color.BLACK);
				tree_view.setBorder(BorderFactory.createEmptyBorder(0, 10,0,0));
				tree_view.putClientProperty("JTree.lineStyle", "None");			//tipul liniei 
				JScrollPane scrolltree = new JScrollPane(tree_view);
				
				String pass = String.valueOf(passf.getPassword());
				try {
					client.connect(adressf.getText()); 		// adresa
					client.login(userf.getText(), pass); 	// user si parola
					client.enterLocalPassiveMode();
					if (client.isConnected()) {
						try {
							FTPFile[] ftpFiles = client.listFiles();
							for (FTPFile ftpFile : ftpFiles) {
								files = new DefaultMutableTreeNode(ftpFile.getName());
								top.add(files);
							if(ftpFile.getType() == FTPFile.DIRECTORY_TYPE){
								FTPFile[] ftpFiles1 = client.listFiles(ftpFile.getName());
								for (FTPFile ftpFile1 : ftpFiles1) {
									leaf = new DefaultMutableTreeNode(ftpFile1.getName());
									files.add(leaf);
									}
								}
							}	
						} catch (IOException e1) {Crawler.printException(e1);}
					} else {
						status.setText("Failed connection!");
					}
				} catch (IOException e1) {Crawler.printException(e1);}
				finally {
					try {client.disconnect();}
					catch (IOException e1){Crawler.printException(e1);}
				}
						
				tree.add(labeltree,BorderLayout.NORTH);
				tree.add(scrolltree, BorderLayout.CENTER);
				tree.add(refresh,BorderLayout.SOUTH);
				
				// pentru miscare frame-uri simultan
				uploadFTP.addComponentListener(new ComponentListener() {
					
					public void componentMoved(ComponentEvent e) {
						tree.setLocation(uploadFTP.getX() + 405, uploadFTP.getY());
					}
					public void componentShown(ComponentEvent e) {}
					public void componentResized(ComponentEvent e) {}
					public void componentHidden(ComponentEvent e) {}
				});
				
				// pentru focus simultan pe frame-uri
				uploadFTP.addWindowListener(new WindowListener() {
					public void windowActivated(WindowEvent e) {
						tree.toFront();						
					}
					public void windowOpened(WindowEvent e) {}
					public void windowIconified(WindowEvent e) {}
					public void windowDeiconified(WindowEvent e) {}
					public void windowDeactivated(WindowEvent e) {}
					public void windowClosing(WindowEvent e) {}
					public void windowClosed(WindowEvent e) {}
				});
				
//				tree.addWindowListener(new WindowListener() {
//					public void windowActivated(WindowEvent e) {
//						uploadFTP.toFront();						
//					}
//					public void windowOpened(WindowEvent e) {}
//					public void windowIconified(WindowEvent e) {}
//					public void windowDeiconified(WindowEvent e) {}
//					public void windowDeactivated(WindowEvent e) {}
//					public void windowClosing(WindowEvent e) {}
//					public void windowClosed(WindowEvent e) {}
//				});
							
				refresh.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						uploadFTP.dispose();
						tree.dispose();
						uploadFTP.setVisible(true);
						tree.setVisible(true);
					}
				});
			}
		});
		
	}
}
