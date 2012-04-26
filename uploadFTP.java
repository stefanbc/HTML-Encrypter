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
import java.net.*;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.tree.*;

/**
 * This class opens the FTP upload window that allow the user to upload a file
 * to his/hers FTP server.
 * 
 * @author Stefan Cosma
 * 
 */
public class uploadFTP {

	final JFrame uploadFTP = new JFrame("FTP Transfer");
	final JFrame tree = new JFrame("Server documents");

	JFileChooser chooserf = new JFileChooser(".");
	public static FileDialog sd = null;

	String filename = null;
	String filepath = null;

	static JLabel titleFTP = new JLabel("Connection");
	public static JTextField adressf = new JTextField("", 35);
	public static JTextField userf = new JTextField("", 35);
	public static JPasswordField passf = new JPasswordField("", 35);
	public static JTextField folderf = new JTextField(35);

	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel inpan1 = new JPanel();
	JPanel inpan2 = new JPanel();
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
	JButton adv = new JButton("");
	JButton exit = new JButton("");

	final ComponentMover cm = new ComponentMover(); // muta fereastra

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public uploadFTP() {
		uploadFTP.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		uploadFTP.setUndecorated(true);
		uploadFTP.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		uploadFTP.setSize(400, 240);
		uploadFTP.setLocationRelativeTo(Encrypter.Center);
		uploadFTP.setResizable(false);
		uploadFTP.setVisible(true);
		cm.registerComponent(uploadFTP);

		uploadFTP.setLayout(new BorderLayout());
		pan1.setLayout(new BorderLayout());
		pan2.setLayout(new BorderLayout());
		inpan1.setLayout(new GridLayout(6, 2, 0, 10));
		inpan2.setLayout(new GridLayout(1, 2, 20, 0));
		pan3.setLayout(new BorderLayout());
		pan4.setLayout(new FlowLayout());

		uploadFTP.add(pan3, BorderLayout.EAST);
		pan3.add(adv, BorderLayout.SOUTH);
		uploadFTP.add(pan1, BorderLayout.NORTH);
		pan1.add(titleFTP, BorderLayout.WEST);
		pan1.add(exit, BorderLayout.EAST);
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
		inpan2.add(connect);
		uploadFTP.add(pan4, BorderLayout.WEST);

		propFTP();
		actionFTP();

		/* BOF Load state */
		try {
			FileInputStream fileStream = new FileInputStream(ClassLoader
					.getSystemResource("upload.prop").getPath());
			ObjectInputStream os = new ObjectInputStream(fileStream);
			adressf.setText(os.readObject().toString());
			userf.setText(os.readObject().toString());
			passf.setText(os.readObject().toString());
			os.close();
			fileStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		/* EOF Load state */
	}

	public void propFTP() {
		uploadFTP.setBackground(Encrypter.color_light);
		pan1.setBackground(Encrypter.color_light);
		pan1.setBorder(BorderFactory.createEmptyBorder(6, 5, 10, 5));
		pan2.setBackground(Encrypter.color_light);
		inpan1.setBackground(Encrypter.color_light);
		inpan2.setBackground(Encrypter.color_light);
		pan3.setBackground(Encrypter.color_light);
		pan4.setBackground(Encrypter.color_light);

		adress.setForeground(Encrypter.color_blue);
		user.setForeground(Encrypter.color_blue);
		pass.setForeground(Encrypter.color_blue);
		folder.setForeground(Encrypter.color_blue);
		filen.setForeground(Encrypter.color_blue);

		adressf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		adressf.setSelectionColor(Encrypter.color_black);
		adressf.setSelectedTextColor(Encrypter.color_white);
		adressf.setBackground(Encrypter.color_light);

		userf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		userf.setSelectionColor(Encrypter.color_black);
		userf.setSelectedTextColor(Encrypter.color_white);
		userf.setBackground(Encrypter.color_light);

		passf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		passf.setSelectionColor(Encrypter.color_black);
		passf.setSelectedTextColor(Encrypter.color_white);
		passf.setBackground(Encrypter.color_light);

		folderf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		folderf.setSelectionColor(Encrypter.color_black);
		folderf.setSelectedTextColor(Encrypter.color_white);
		folderf.setBackground(Encrypter.color_light);

		status.setHorizontalAlignment(SwingConstants.RIGHT);

		ImageIcon title_icon = getImageIcon("assets/icons/upload.png");
		titleFTP.setForeground(Encrypter.color_blue);
		titleFTP.setFont(Encrypter.font16);
		titleFTP.setIcon(title_icon);

		connect.setBackground(Encrypter.color_light);
		connect.setBorder(BorderFactory.createEmptyBorder());
		connect.setForeground(Encrypter.color_black);
		connect.setFont(Encrypter.font16);
		connect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		connect.setToolTipText("Transfer File");

		browsef.setBackground(Encrypter.color_light);
		browsef.setBorder(BorderFactory.createEmptyBorder());
		browsef.setForeground(Encrypter.color_black);
		browsef.setFont(Encrypter.font16);
		browsef.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		browsef.setToolTipText("Add file");

		ImageIcon exit_icon = getImageIcon("assets/icons/exit.png");
		exit.setBackground(Encrypter.color_light);
		exit.setBorder(BorderFactory.createLineBorder(Encrypter.color_dark, 0));
		exit.setForeground(Encrypter.color_black);
		exit.setFont(Encrypter.font16);
		exit.setIcon(exit_icon);
		exit.setToolTipText("Exit");

		ImageIcon adv_icon = getImageIcon("assets/icons/adv_ftp.png");
		adv.setIcon(adv_icon);
		adv.setBackground(Encrypter.color_light);
		adv.setBorder(BorderFactory.createLineBorder(Encrypter.color_light, 0));
		adv.setFont(Encrypter.font16);
		adv.setToolTipText("Display server files");
		adv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		chooserf.addChoosableFileFilter(new FileNameExtensionFilter("Text",
				"txt"));
		chooserf.addChoosableFileFilter(new FileNameExtensionFilter("HTM",
				"htm"));
		chooserf.addChoosableFileFilter(new FileNameExtensionFilter("XHTML",
				"xhtml"));
		chooserf.addChoosableFileFilter(new FileNameExtensionFilter("HTML",
				"html"));
		chooserf.setAcceptAllFileFilterUsed(false);
	}

	/**
	 * Save State
	 */
	public void saveState() {
		try {
			String index1 = adressf.getText();
			String index2 = userf.getText();
			String index3 = String.valueOf(passf.getPassword());
			FileOutputStream fileStream = new FileOutputStream(ClassLoader
					.getSystemResource("upload.prop").getPath());
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(index1);
			os.writeObject(index2);
			os.writeObject(index3);
			os.close();
			fileStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionFTP() {
		adressf.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				InetAddress thisIp;
				try {
					thisIp = InetAddress.getLocalHost();
					titleFTP.setText("Connection: " + thisIp.getHostAddress()
							+ " -> " + adressf.getText());
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveState();
				uploadFTP.dispose();
				tree.dispose();
			}
		});

		connect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FTPClient client = new FTPClient();
				FileInputStream fis = null;
				String pass = String.valueOf(passf.getPassword());
				try {
					if (filename == null) {
						status.setText("File does not exist!");
					} else {
						// Server address
						client.connect(adressf.getText());
						// Login credentials
						client.login(userf.getText(), pass);
						if (client.isConnected()) {
							status.setText("Succesfull transfer!");
							// File type
							client.setFileType(FTP.BINARY_FILE_TYPE);
							// File location
							File file = new File(filepath);
							fis = new FileInputStream(file);
							// Change the folder on the server
							client.changeWorkingDirectory(folderf.getText());
							// Save the file on the server
							client.storeFile(filename, fis);
						} else {
							status.setText("Transfer failed!");
						}
					}
					client.logout();
				} catch (IOException e1) {
					Encrypter.printException(e1);
				} finally {
					try {
						if (fis != null) {
							fis.close();
						}
						client.disconnect();
					} catch (IOException e1) {
						Encrypter.printException(e1);
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
					filenf.setText(chooserf.getSelectedFile().getName()
							.toString());
				}
			}
		});

		adv.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				tree.setSize(220, uploadFTP.getHeight());
				tree.setLocation(uploadFTP.getX() + 405, uploadFTP.getY());
				tree.setResizable(false);
				tree.setIconImage(Toolkit.getDefaultToolkit().getImage(
						getClass().getClassLoader().getResource(
								"assets/ico.png")));
				tree.setUndecorated(true);
				tree.getRootPane().setBorder(
						BorderFactory.createLineBorder(Encrypter.color_black, 2));
				tree.setVisible(true);
				tree.setLayout(new BorderLayout());

				JLabel labeltree = new JLabel("Server documents");
				labeltree.setOpaque(true);
				labeltree.setBackground(Encrypter.color_light);
				labeltree.setBorder(BorderFactory.createMatteBorder(8, 10, 10,
						0, Encrypter.color_light));
				labeltree.setForeground(Encrypter.color_blue);
				labeltree.setFont(Encrypter.font16);

				JButton refresh = new JButton("");
				ImageIcon refresh_icon = getImageIcon("assets/icons/refresh.png");
				refresh.setIcon(refresh_icon);
				refresh.setBackground(Encrypter.color_light);
				refresh.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
				refresh.setForeground(Encrypter.color_black);
				refresh.setFont(Encrypter.font16);
				refresh.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));

				final FTPClient client = new FTPClient();
				DefaultMutableTreeNode top = new DefaultMutableTreeNode(adressf
						.getText());
				DefaultMutableTreeNode files = null;
				DefaultMutableTreeNode leaf = null;

				final JTree tree_view = new JTree(top);
				tree_view.setForeground(Encrypter.color_black);
				tree_view.setBorder(BorderFactory
						.createEmptyBorder(0, 10, 0, 0));
				tree_view.putClientProperty("JTree.lineStyle", "None");
				tree_view.setBackground(Encrypter.color_light);
				JScrollPane scrolltree = new JScrollPane(tree_view);
				scrolltree.setBackground(Encrypter.color_light);
				scrolltree.getVerticalScrollBar().setPreferredSize(
						new Dimension(0, 0));

				UIManager.put("Tree.textBackground", Encrypter.color_light);
				UIManager.put("Tree.selectionBackground", Encrypter.color_blue);
				UIManager.put("Tree.selectionBorderColor", Encrypter.color_blue);

				tree_view.updateUI();

				final String pass = String.valueOf(passf.getPassword());
				try {
					client.connect(adressf.getText());
					client.login(userf.getText(), pass);
					client.enterLocalPassiveMode();
					if (client.isConnected()) {
						try {
							FTPFile[] ftpFiles = client.listFiles();
							for (FTPFile ftpFile : ftpFiles) {
								files = new DefaultMutableTreeNode(ftpFile
										.getName());
								top.add(files);
								if (ftpFile.getType() == FTPFile.DIRECTORY_TYPE) {
									FTPFile[] ftpFiles1 = client
											.listFiles(ftpFile.getName());
									for (FTPFile ftpFile1 : ftpFiles1) {
										leaf = new DefaultMutableTreeNode(
												ftpFile1.getName());
										files.add(leaf);
									}
								}
							}
						} catch (IOException e1) {
							Encrypter.printException(e1);
						}
						client.disconnect();
					} else {
						status.setText("Failed connection!");
					}
				} catch (IOException e1) {
					Encrypter.printException(e1);
				} finally {
					try {
						client.disconnect();
					} catch (IOException e1) {
						Encrypter.printException(e1);
					}
				}

				tree.add(labeltree, BorderLayout.NORTH);
				tree.add(scrolltree, BorderLayout.CENTER);
				tree.add(refresh, BorderLayout.SOUTH);

				uploadFTP.addComponentListener(new ComponentListener() {

					public void componentMoved(ComponentEvent e) {
						tree.setLocation(uploadFTP.getX() + 405,
								uploadFTP.getY());
					}

					public void componentShown(ComponentEvent e) {
					}

					public void componentResized(ComponentEvent e) {
					}

					public void componentHidden(ComponentEvent e) {
					}
				});

				uploadFTP.addWindowListener(new WindowListener() {
					public void windowActivated(WindowEvent e) {
						tree.toFront();
					}

					public void windowOpened(WindowEvent e) {
					}

					public void windowIconified(WindowEvent e) {
					}

					public void windowDeiconified(WindowEvent e) {
					}

					public void windowDeactivated(WindowEvent e) {
					}

					public void windowClosing(WindowEvent e) {
					}

					public void windowClosed(WindowEvent e) {
					}
				});

				refresh.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						tree.dispose();
						tree.setVisible(true);
					}
				});
			}
		});

	}
}
