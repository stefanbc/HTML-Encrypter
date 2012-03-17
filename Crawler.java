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

/** 
 * Author: Stefan Cosma
 * The problem: Using encryption/decryption algorithms to hide HTML code
 * Name: HTML Encrypter
 * Year: 2011
 * Last stable version: v1.9.0 [17.03.2012]
 * Status: In development
 */

package Proiect;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JPopupMenu.*;
import javax.swing.event.*;
import javax.swing.text.*;
import Proiect.js.jsBlowfish;
import Proiect.js.jsAES;
import Proiect.js.jsEscape;
import Proiect.js.jsMARC4;
import Proiect.js.jsRabbit;
import Proiect.js.jsTEA;

public class Crawler extends JFrame {

	/**
	 * Create panels
	 */
	static JPanel Crw = new JPanel(); // Main panel
	static JPanel main_North = new JPanel();
	static JPanel main_Center = new JPanel();
	static JPanel main_South = new JPanel();
	static JPanel main_West = new JPanel();
	static JPanel main_East = new JPanel();
	static JPanel pan1 = new JPanel();
	static JPanel in_pan11 = new JPanel();
	static JPanel pan2 = new JPanel();
	static JPanel in_pan21 = new JPanel();
	static JPanel in_pan211 = new JPanel();
	static JPanel in_pan22 = new JPanel();
	static JPanel pan3 = new JPanel();
	static JPanel pan4 = new JPanel();
	static JPanel in_pan41 = new JPanel();
	static JPanel in_pan42 = new JPanel();
	static JPanel pan5 = new JPanel();
	static JPanel in_pan51 = new JPanel();
	static JPanel West = new JPanel(); // Main panel sidebar
	static JPanel East = new JPanel();
	static JPanel South = new JPanel();
	static JPanel ad_pan1 = new JPanel(); // Additional panel sidebar
	static JPanel ad_pan11 = new JPanel(); // Additional panel sidebar

	// Create general components
	static JTextField TF1 = new JTextField("http://htmlencrypter.call-to-action.ro", 30); // Texfield URL
	static JTextField TF2 = new JTextField(30); // textfield URL result

	static JLabel LB1 = new JLabel("Insert URL / URI: "); // label URL
	static JLabel LB2 = new JLabel("The search results are: "); // label results
	static JLabel LB3 = new JLabel("Encryption/decryption method: "); // label combobox
	static JLabel LB4 = new JLabel("HTML Encrypter v1.9.0 [17.03.2012]"); // label version

	public static JTextArea TA = new JTextArea(20, 50); // show results
	static JTextArea TAlines = new JTextArea(); // show count lines
	static JScrollPane scroll = new JScrollPane(TA); // scroll textarea

	static JButton but = new JButton("Search"); // buton cautare
	static JButton crypt = new JButton("Encrypt"); // buton criptare
	static JButton decrypt = new JButton("Decrypt"); // buton decriptare
	static JButton exit = new JButton(" x "); // buton iesire
	static JButton minim = new JButton(" _ "); // buton minimalizare
	static JButton maxim = new JButton(" # "); // buton maximizare

	static JComboBox combo = new JComboBox(); // selectare limbaj criptare
	public static JCheckBox no_click = new JCheckBox("Disable right click");
	static JFileChooser chooser = new JFileChooser("."); // deschide fisier
	static JProgressBar progbar = new JProgressBar(0, 100); // progress bar

	// menubar si itemuri
	JMenuBar mb = new JMenuBar();
	JMenu mFile = new JMenu("File");
	JMenuItem miFile = new JMenuItem("New Search");
	JMenuItem miOpen = new JMenuItem("Open File...");
	JMenuItem miSave = new JMenuItem("Save Source Code");
	JMenuItem miExit = new JMenuItem("Exit");
	JMenu mHist = new JMenu("Search History");
	JMenu mEdit = new JMenu("Edit");
	JMenuItem miCopy = new JMenuItem("Copy");
	JMenuItem miPaste = new JMenuItem("Paste");
	JMenuItem miFind = new JMenuItem("Find");
	JMenuItem miLine = new JMenuItem("Find Line...");
	JMenu mView = new JMenu("View");// submenu
	JCheckBoxMenuItem miFull = new JCheckBoxMenuItem("Fullscreen");
	JCheckBoxMenuItem miTray = new JCheckBoxMenuItem("System Tray", true);
	JMenu mTools = new JMenu("Tools");// submenu
	JMenuItem miBrowse = new JMenuItem("Show URL");
	JMenuItem miBlank = new JMenuItem("Remove _blank");
	JMenuItem miFTP = new JMenuItem("FTP Transfer");
	JMenu mAbout = new JMenu("Help");
	JMenuItem miAbout = new JMenuItem("About HTML Encrypter");
	JMenuItem miHelp = new JMenuItem("Help");
	JMenuItem miLog = new JMenuItem("Show Log");
	JMenuItem miNet = new JMenuItem("System Information");

	// butoane sidebar
	static JButton new_doc = new JButton();
	static JButton open = new JButton();
	static JButton copy = new JButton();
	static JButton paste = new JButton();
	static JButton save = new JButton();
	static JButton no_blank = new JButton();
	static JButton upload = new JButton();

	// alte variabile
	final Clipboard clipboard = getToolkit().getSystemClipboard(); // variabila pentru buton Cut
	private static final long serialVersionUID = 1L; // tipul versiunii de program
	static Font font12 = new Font("Arial", Font.BOLD, 12); // font 12 global
	static Font font16 = new Font("Arial", Font.BOLD, 16); // font 16 global
	ComponentMover cm = new ComponentMover(); // variabila mutare fereastra
	ComponentResizer cr = new ComponentResizer(); // variabila redimensionare fereastra

	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
	Date date = new Date();
	File logfile = new File("resources/log/" + "logfile" + sdf.format(date) + ".txt");// variabila pentru logfile
	static PrintStream log = null; // stream de scriere pentru logfile
	Calendar cal = Calendar.getInstance(); // afisare data pentru logfile
	String name = ""; // string pentru istoric cautarii
	LinePainter painter = new LinePainter(TA); // highlight rand textarea
	File inFile;

	// menu click dreapta
	JPopupMenu popUp = new JPopupMenu();
	JMenuItem popCopy = new JMenuItem("Copy");
	JMenuItem popPaste = new JMenuItem("Paste");
	
	public static String no_click_script = "<script language=JavaScript>"
		+ "var message='Deactivated function!';"
		+ "function clickIE4(){"
		+ "if (event.button==2){"
		+ "alert(message);"
		+ "return false;}}"
		+ "function clickNS4(e){"
		+ "if (document.layers||document.getElementById&&!document.all){"
		+ "if (e.which==2||e.which==3){"
		+ "alert(message);"
		+ "return false;}}}"
		+ "if (document.layers){"
		+ "document.captureEvents(Event.MOUSEDOWN);"
		+ "document.onmousedown=clickNS4;"
		+ "}else if (document.all&&!document.getElementById){"
		+ "document.onmousedown=clickIE4;}"
		+ "document.oncontextmenu=new Function('alert(message);return false')"
		+ "</script>\n";
		
	public Crawler() {
		super("HTML Encrypter");
		setDefaultCloseOperation(EXIT_ON_CLOSE); // in caz de alt+f4
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources/ico.png")); // icoana fereastra
		setUndecorated(true); // border fereastra principala
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // --||--

		cm.registerComponent(this); // mutare fereastra
		cr.setSnapSize(new Dimension(10, 10));
		cr.registerComponent(this); // redimensionare fereastra
		cm.setDragInsets(cr.getDragInsets());

		//com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.8f); //transparenta fereastra
		setLayout(new BorderLayout());
		add(Crw, BorderLayout.CENTER);
		add(West, BorderLayout.WEST);
		add(East, BorderLayout.EAST);
		add(South, BorderLayout.SOUTH);

		West.setLayout(new FlowLayout());
		East.setLayout(new FlowLayout());
		South.setLayout(new BorderLayout());
		Crw.setLayout(new BorderLayout());
		main_North.setLayout(new BorderLayout());
		main_Center.setLayout(new BorderLayout());
		main_South.setLayout(new BorderLayout());
		main_West.setLayout(new BorderLayout());
		main_East.setLayout(new FlowLayout());
		pan1.setLayout(new BorderLayout());
		pan2.setLayout(new BorderLayout());
		pan3.setLayout(new BorderLayout());
		pan4.setLayout(new BorderLayout());
		in_pan41.setLayout(new GridLayout(2, 0, 0, 3));
		pan5.setLayout(new BorderLayout());
		in_pan21.setLayout(new BorderLayout());
		in_pan211.setLayout(new BorderLayout());
		in_pan22.setLayout(new BorderLayout());
		ad_pan1.setLayout(new BorderLayout());
		ad_pan11.setLayout(new GridLayout(0, 1));

		// adaugare menubar
		Crw.add(main_North, BorderLayout.NORTH);
		main_North.add(pan1);
		pan1.add(mb, BorderLayout.WEST);
		mb.add(mFile);
		mFile.add(miFile);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(mHist); // submenu
		mFile.add(miExit);
		mb.add(mEdit);
		mEdit.add(miCopy);
		mEdit.add(miPaste);
		mEdit.add(new Separator());
		mEdit.add(miFind);
		mEdit.add(miLine);
		mEdit.add(new Separator());
		mEdit.add(mView); // submenu
		mView.add(miFull);
		mView.add(miTray);
		mb.add(mTools);
		mTools.add(miBrowse);
		mTools.add(miBlank);
		mTools.add(miFTP);
		mb.add(mAbout);
		mAbout.add(miHelp);
		mAbout.add(miLog);
		mAbout.add(miAbout);
		mAbout.add(miNet);
		pan1.add(in_pan11, BorderLayout.EAST);
		in_pan11.add(minim); // buton minimizare
		in_pan11.add(maxim); // buton maximizare
		in_pan11.add(exit); // buton exit

		Crw.add(main_West, BorderLayout.WEST);
		main_West.add(ad_pan1, BorderLayout.CENTER);
		ad_pan1.add(Box.createVerticalStrut(70), BorderLayout.NORTH);
		ad_pan1.add(ad_pan11, BorderLayout.CENTER);
		ad_pan11.add(new_doc);
		ad_pan11.add(open);
		ad_pan11.add(save);
		ad_pan11.add(copy);
		ad_pan11.add(paste);
		ad_pan11.add(no_blank);
		ad_pan11.add(upload);
		ad_pan1.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
		ad_pan1.add(Box.createVerticalStrut(70), BorderLayout.SOUTH);

		Crw.add(main_Center, BorderLayout.CENTER);
		main_Center.add(pan2, BorderLayout.NORTH);
		pan2.add(in_pan21, BorderLayout.NORTH);
		in_pan21.add(LB1, BorderLayout.WEST); // label sus dreapta
		in_pan21.add(in_pan211, BorderLayout.CENTER);
		in_pan211.add(Box.createHorizontalStrut(50), BorderLayout.WEST);
		in_pan211.add(TF1, BorderLayout.CENTER); // textfield URL
		in_pan211.add(but, BorderLayout.EAST); // buton cautare
		pan2.add(in_pan22, BorderLayout.SOUTH);
		in_pan22.add(LB2, BorderLayout.WEST); // label rezultat
		in_pan22.add(TF2, BorderLayout.CENTER); // textfield rezultat
		main_Center.add(pan3, BorderLayout.CENTER);
		pan3.add(scroll); // textarea rezultate

		Crw.add(main_East, BorderLayout.EAST);
		main_East.add(Box.createHorizontalStrut(20));

		Crw.add(main_South, BorderLayout.SOUTH);
		main_South.add(pan4, BorderLayout.NORTH);
		pan4.add(in_pan41, BorderLayout.WEST);
		in_pan41.add(LB3); // label metoda criptare
		in_pan41.add(combo); // combobox alege metoda
		combo.insertItemAt("JavaScript Blowfish", 0);
		combo.insertItemAt("JavaScript AES", 1);
		combo.insertItemAt("JavaScript Rabbit", 2);
		combo.insertItemAt("JavaScript MARC4", 3);
		combo.insertItemAt("JavaScript TEA", 4);
		combo.insertItemAt("JavaScript Escape", 5);
		combo.setSelectedIndex(0);
		in_pan41.add(Box.createHorizontalStrut(20));
		in_pan41.add(no_click);
		pan4.add(in_pan42, BorderLayout.EAST);
		in_pan42.add(crypt); // buton criptare
		in_pan42.add(Box.createHorizontalStrut(10));// separator
		in_pan42.add(decrypt); // buton decriptare
		main_South.add(pan5, BorderLayout.SOUTH);
		pan5.add(in_pan51, BorderLayout.EAST);
		in_pan51.add(progbar); // progress bar
		in_pan51.add(Box.createHorizontalStrut(35));
		South.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
		South.add(LB4, BorderLayout.CENTER); // titlu + versiune
		South.add(Box.createVerticalStrut(5), BorderLayout.SOUTH);

		// meniu click dreapta
		popUp.add(popCopy);
		popUp.add(popPaste);

		// scriere exceptie in logfile
		try {
			log = new PrintStream(logfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// apelare actiuni si proprietati elemente
		new setProp(); // clasa proprietati elemente
		propMenu(); // clasa proprietati menu
		action(); // clasa actiuni butoane
		actMenu(); // clasa actiuni meniu
		actSidebar(); // clasa actiuni butoane sidebar

		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null); // centrul ecranului
		setVisible(true);
	}

	/**
	 * Proprietati Menu - generale
	 * 
	 * @return
	 */
	public void propMenu() {

		mb.setBackground(Color.WHITE);
		mb.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		mb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		mFile.setMnemonic('F');
		mEdit.setMnemonic('E');
		mTools.setMnemonic('T');
		mAbout.setMnemonic('H');

		miFile.setMnemonic('N');
		miOpen.setMnemonic('O');
		miSave.setMnemonic('S');
		miExit.setMnemonic('E');

		miCopy.setMnemonic('C');
		miPaste.setMnemonic('P');

		miBrowse.setMnemonic('U');

		miAbout.setMnemonic('A');
		miHelp.setMnemonic('L');

		mFile.setFont(font16);
		mFile.setForeground(Color.BLACK);
		mFile.setSelected(false);
		mFile.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		mFile.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2));

		mEdit.setFont(font16);
		mEdit.setForeground(Color.BLACK);
		mEdit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		mEdit.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2));

		mHist.setBackground(Color.WHITE);
		mHist.setForeground(Color.BLACK);
		mHist.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		mHist.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2));

		mTools.setFont(font16);
		mTools.setForeground(Color.BLACK);
		mTools.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		mTools.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2));

		mView.setBackground(Color.WHITE);
		mView.setForeground(Color.BLACK);
		mView.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		mView.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2));

		mAbout.setFont(font16);
		mAbout.setForeground(Color.BLACK);
		mAbout.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		mAbout.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2));

		miFile.setBackground(Color.WHITE);
		miFile.setForeground(Color.BLACK);
		miFile.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miFile.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));// shortcut
		miFile.setIcon(new ImageIcon("resources/icons/menu/new.png"));

		miOpen.setBackground(Color.WHITE);
		miOpen.setForeground(Color.BLACK);
		miOpen.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miOpen.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		miOpen.setIcon(new ImageIcon("resources/icons/menu/open.png"));

		miSave.setBackground(Color.WHITE);
		miSave.setForeground(Color.BLACK);
		miSave.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miSave.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
		miSave.setIcon(new ImageIcon("resources/icons/menu/save.png"));

		miExit.setBackground(Color.WHITE);
		miExit.setForeground(Color.BLACK);
		miExit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miExit.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		miExit.setIcon(new ImageIcon("resources/icons/menu/exit.png"));

		miCopy.setBackground(Color.WHITE);
		miCopy.setForeground(Color.BLACK);
		miCopy.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miCopy.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		miCopy.setIcon(new ImageIcon("resources/icons/menu/copy.png"));

		miPaste.setBackground(Color.WHITE);
		miPaste.setForeground(Color.BLACK);
		miPaste.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miPaste.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_V, java.awt.Event.CTRL_MASK));
		miPaste.setIcon(new ImageIcon("resources/icons/menu/paste.png"));

		miFind.setBackground(Color.WHITE);
		miFind.setForeground(Color.BLACK);
		miFind.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miFind.setIcon(new ImageIcon("resources/icons/menu/search.png"));
		miFind.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));

		miLine.setBackground(Color.WHITE);
		miLine.setForeground(Color.BLACK);
		miLine.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miLine.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_L, java.awt.Event.CTRL_MASK));

		miFull.setBackground(Color.WHITE);
		miFull.setForeground(Color.BLACK);
		miFull.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miFull.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_H, java.awt.Event.CTRL_MASK));
		miFull.setIcon(new ImageIcon("resources/icons/menu/fullscreen.png"));
		miFull.setHorizontalTextPosition(AbstractButton.LEFT);

		miAbout.setBackground(Color.WHITE);
		miAbout.setForeground(Color.BLACK);
		miAbout.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miAbout.setIcon(new ImageIcon("resources/icons/menu/about.png"));

		miHelp.setBackground(Color.WHITE);
		miHelp.setForeground(Color.BLACK);
		miHelp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miHelp.setAccelerator(KeyStroke.getKeyStroke("F1")); // keystroke F1
																// pentru miHelp
		miHelp.setIcon(new ImageIcon("resources/icons/menu/help.png"));

		miLog.setBackground(Color.WHITE);
		miLog.setForeground(Color.BLACK);
		miLog.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miLog.setAccelerator(KeyStroke.getKeyStroke("F2"));

		miBrowse.setBackground(Color.WHITE);
		miBrowse.setForeground(Color.BLACK);
		miBrowse.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miBrowse.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_U, java.awt.Event.CTRL_MASK));
		miBrowse.setIcon(new ImageIcon("resources/icons/menu/show_url.png"));

		miBlank.setBackground(Color.WHITE);
		miBlank.setForeground(Color.BLACK);
		miBlank.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miBlank.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_B, java.awt.Event.CTRL_MASK));
		miBlank.setIcon(new ImageIcon("resources/icons/menu/no_blank.png"));

		miFTP.setBackground(Color.WHITE);
		miFTP.setForeground(Color.BLACK);
		miFTP.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miFTP.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_T, java.awt.Event.CTRL_MASK));
		miFTP.setIcon(new ImageIcon("resources/icons/menu/upload.png"));

		miNet.setBackground(Color.WHITE);
		miNet.setForeground(Color.BLACK);
		miNet.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		miNet.setAccelerator(KeyStroke.getKeyStroke("F3"));
		miNet.setIcon(new ImageIcon("resources/icons/menu/network.png"));

		// meniu click dreapta proprietati
		popUp.setBackground(Color.WHITE);
		popUp.setForeground(Color.BLACK);
		popUp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		popCopy.setBackground(Color.WHITE);
		popCopy.setIcon(new ImageIcon("resources/icons/menu/copy.png"));
		popPaste.setBackground(Color.WHITE);
		popPaste.setIcon(new ImageIcon("resources/icons/menu/paste.png"));
	}

	/**
	 * Actiuni Butoane
	 */
	public void action() {
		but.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (TF1.getText().contentEquals("http://")) {
						TA.setText(" Please insert URL!!");
						TA.append("\n");
					} else {
						TA.setText("");
						LB2.setText("The search results are: ");
						new Thread(new progress()).start();
						ping();
						if (TA.getText().contentEquals("200")) {
							TA.setText("");
							crawl();
							TF2.setText(TF1.getText() + " was searched");
						} else {
							TA.append(" Failed connection!");
						}
					}
				} catch (IllegalArgumentException e1) {
				}
				addHist();
			}
		});

		crypt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (combo.getSelectedItem().equals("JavaScript Blowfish")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")) {
							TA.setText("");
							TA.append(" Encryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsBlowfish.jsBlowfishEn(TA.getText());
								LB2.setText("The encryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully encrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript AES")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")) {
							TA.setText("");
							TA.append(" Encryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsAES.jsAESEn(TA.getText());
								LB2.setText("The encryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully encrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript Rabbit")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")) {
							TA.setText("");
							TA.append(" Encryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsRabbit.jsRabbitEn(TA.getText());
								LB2.setText("The encryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully encrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript MARC4")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")) {
							TA.setText("");
							TA.append(" Encryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsMARC4.jsMARC4En(TA.getText());
								LB2.setText("The encryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully encrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript TEA")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")) {
							TA.setText("");
							TA.append(" Encryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsTEA.jsTEAEn(TA.getText());
								LB2.setText("The encryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully encrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript Escape")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")) {
							TA.setText("");
							TA.append(" Encryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsEscape.jsEscapeText(TA.getText());
								LB2.setText("The encryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully encrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
				} catch (IllegalArgumentException e1) {
				}
			}
		});

		decrypt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (combo.getSelectedItem().equals("JavaScript Blowfish")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")) {
							TA.setText("");
							TA.append(" Decryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsBlowfish.jsBlowfishDe(TA.getText());
								LB2.setText("The decryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully decrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript AES")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")) {
							TA.setText("");
							TA.append(" Decryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsAES.jsAESDe(TA.getText());
								LB2.setText("The decryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully decrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript Rabbit")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")) {
							TA.setText("");
							TA.append(" Decryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsRabbit.jsRabbitDe(TA.getText());
								LB2.setText("The decryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully decrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript MARC4")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")) {
							TA.setText("");
							TA.append(" Decryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsMARC4.jsMARC4De(TA.getText());
								LB2.setText("The decryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully decrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript TEA")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")) {
							TA.setText("");
							TA.append(" Decryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsTEA.jsTEADe(TA.getText());
								LB2.setText("The decryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully decrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript Escape")) {
						if (TA.getText().contentEquals(" Failed connection!")
								|| TA.getText().contentEquals(
										" Decryption not possible!")
								|| TA.getText().contentEquals(
										" Encryption not possible!")) {
							TA.setText("");
							TA.append(" Decryption not possible!");
						} else {
							try {
								new Thread(new progress()).start();
								jsEscape.jsUnescapeText(TA.getText());
								LB2.setText("The decryption results are: ");
								TF2.setText(TF1.getText()
										+ " was succesfully decrypted");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					// else {
					// TA.setText("");
					// TA.append(" Metoda selectata nu este valida pentru decriptare!");
					// }
				} catch (IllegalArgumentException e1) {
				}
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		minim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (miTray.isSelected()) {
					inTray();
					setVisible(false);
				} else {
					setState(Crawler.ICONIFIED);
				}
			}
		});

		maxim.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// dimensiune ecran fara taskbar
				Rectangle maxBounds = GraphicsEnvironment
						.getLocalGraphicsEnvironment().getMaximumWindowBounds();

				if (getBounds().contains(maxBounds)) {
					onMove();
					setSize(800, 600);
					setLocationRelativeTo(null);
				} else {
					offMove();
					setBounds(maxBounds);
				}
			}
		});

		TA.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popUp.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popUp.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});

		// Setare numerotare linii
		TA.getDocument().addDocumentListener(new DocumentListener() {
			public String getText() {
				int caretPosition = TA.getDocument().getLength();
				Element root = TA.getDocument().getDefaultRootElement();
				String text = " 1\n";
				for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++)
					text += " " + i + "  \n";
				return text;
			}

			public void changedUpdate(DocumentEvent de) {
				TAlines.setText(getText());
			}

			public void insertUpdate(DocumentEvent de) {
				TAlines.setText(getText());
			}

			public void removeUpdate(DocumentEvent de) {
				TAlines.setText(getText());
			}

		});

		// Pentru ENTER
		TF1.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					try {
						if (TF1.getText().contentEquals("http://")) {
							TA.setText(" Please insert URL!!");
							TA.append("\n");
						} else {
							TA.setText("");
							LB2.setText("The search results are: ");
							new Thread(new progress()).start();
							ping();
							if (TA.getText().contentEquals("200")) {
								TA.setText("");
								crawl();
								TF2.setText(TF1.getText() + " was searched");
							} else {
								TA.append(" Failed connection!");
							}
						}
					} catch (IllegalArgumentException e1) {
					}
					addHist();
				}
			}
		});
	}

	/**
	 * Actiuni Butoane menu
	 */
	public void actMenu() {
		miFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TA.setText("");
				TF1.setText("http://");
				TF2.setText("");
				LB2.setText("The search results are: ");
				progbar.setValue(0);
			}
		});

		miOpen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TA.setText("");
				setFile();
			}
		});

		miSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (TA.getText().contentEquals("")
							|| TA.getText().contentEquals(
									"Nothing to save!")) {
						TA.setText("");
						TA.append("Nothing to save!");
					} else {
						save();
					}
				} catch (IllegalArgumentException e1) {
				}
			}
		});

		miExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		miAbout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new pAbout();
			}
		});

		miHelp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					new helpBox();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		miCopy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String selection = TA.getSelectedText();
				StringSelection data = new StringSelection(selection);
				Clipboard clipboard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipboard.setContents(data, data);
			}
		});

		miPaste.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Transferable clipData = clipboard.getContents(clipboard);
				if (clipData != null) {
					try {
						if (clipData
								.isDataFlavorSupported(DataFlavor.stringFlavor)) {
							String s = (String) (clipData
									.getTransferData(DataFlavor.stringFlavor));
							TA.replaceSelection(s);
						}
					} catch (UnsupportedFlavorException ufe) {
						TA.append("Unsupported value: " + ufe);
					} catch (IOException ioe) {
						TA.append("Unavailable data: " + ioe);
					}
				}
			}
		});

		miFind.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new inFind();
			}
		});

		miLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new gotoLine();
			}
		});

		miFull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miFull.isSelected()) {
					offMove();
					setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
				} else {
					onMove();
					setSize(800, 600);
					setLocationRelativeTo(null);
				}

			}
		});

		miBrowse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BrowserLaunch.openURL(TF1.getText().trim());
			}
		});

		miBlank.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = TA.getText();
				text = text.replaceAll("(\\r|\\n|\\t)", ""); // elimina
																// newline-urile
				TA.setText(text);
			}
		});

		miFTP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new uploadFTP();
				try {
					InetAddress thisIp = InetAddress.getLocalHost();
					uploadFTP.titleFTP.setText("FTP Transfer: "
							+ thisIp.getHostAddress() + " -> "
							+ uploadFTP.adressf.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		miNet.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new netInfo();
				String os_name = System.getProperty("os.name");
				String os_version = System.getProperty("os.version");
				String os_arch = System.getProperty("os.arch");
				String java_ver = System.getProperty("java.version");

				netInfo.win.setText("<html><b>Platform:</b> " + os_name
						+ "</html>");
				netInfo.ver.setText("<html><b>Version:</b> " + os_version
						+ "</html>");
				netInfo.arch.setText("<html><b>Architecture:</b> " + os_arch
						+ "</html>");
				netInfo.java.setText("<html><b>Java Version:</b> " + java_ver
						+ "</html>");
				try {
					InetAddress thisIp = InetAddress.getLocalHost();
					netInfo.ip.setText("<html><b>Local IP:</b> "
							+ thisIp.getHostAddress() + "</html>");
					netInfo.name.setText("<html><b>Localhost:</b> "
							+ thisIp.getHostName() + "</html>");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		miLog.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fileOpen(new File("resources/log/logfile" + sdf.format(date)
						+ ".txt"));
			}
		});

		// actiuni meniu click dreapta
		popCopy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String selection = TA.getSelectedText();
				StringSelection data = new StringSelection(selection);
				Clipboard clipboard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipboard.setContents(data, data);
			}
		});

		popPaste.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Transferable clipData = clipboard.getContents(clipboard);
				if (clipData != null) {
					try {
						if (clipData
								.isDataFlavorSupported(DataFlavor.stringFlavor)) {
							String s = (String) (clipData
									.getTransferData(DataFlavor.stringFlavor));
							TA.replaceSelection(s);
						}
					} catch (UnsupportedFlavorException ufe) {
						TA.append("Unsupported value: " + ufe);
					} catch (IOException ioe) {
						TA.append("Unavailable data: " + ioe);
					}
				}
			}
		});
	}

	/**
	 * Actiuni Butoane Sidebar
	 */
	public void actSidebar() {
		new_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TA.setText("");
				TF1.setText("http://");
				TF2.setText("");
				LB2.setText("The search results are: ");
				progbar.setValue(0);
			}
		});

		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TA.setText("");
				setFile();
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (TA.getText().contentEquals("")
							|| TA.getText().contentEquals(
									"Nothing to save!")) {
						TA.setText("");
						TA.append("Nothing to save!");
					} else {
						save();
					}
				} catch (IllegalArgumentException e1) {
				}
			}
		});

		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = TA.getSelectedText();
				StringSelection data = new StringSelection(selection);
				Clipboard clipboard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipboard.setContents(data, data);
			}
		});

		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transferable clipData = clipboard.getContents(clipboard);
				if (clipData != null) {
					try {
						if (clipData
								.isDataFlavorSupported(DataFlavor.stringFlavor)) {
							String s = (String) (clipData
									.getTransferData(DataFlavor.stringFlavor));
							TA.replaceSelection(s);
						}
					} catch (UnsupportedFlavorException ufe) {
						TA.append("Unsupported value: " + ufe);
					} catch (IOException ioe) {
						TA.append("Unavailable data: " + ioe);
					}
				}
			}
		});

		no_blank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = TA.getText();
				text = text.replaceAll("(\\r|\\n|\\t)", ""); // elimina
																// newline-urile
				TA.setText(text);
			}
		});

		upload.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new uploadFTP();
				try {
					InetAddress thisIp = InetAddress.getLocalHost();
					uploadFTP.titleFTP.setText("FTP Transfer: "
							+ thisIp.getHostAddress() + " -> "
							+ uploadFTP.adressf.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crawl URL
	 */
	public void crawl() {
		try {
			URL url = new URL(TF1.getText());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			char v[] = new char[1024];
			int len;
			while ((len = in.read(v)) != -1)
				TA.append(new String(v, 0, len));
			in.close();
		} catch (MalformedURLException e) {
			TA.append("MalformedURLException: " + e);
		} catch (IOException e) {
			TA.append("IOException: " + e);
		}
	}

	/**
	 * Ping URL
	 */
	public void ping() {
		HttpURLConnection connection = null;
		try {
			URL u = new URL(TF1.getText());
			connection = (HttpURLConnection) u.openConnection();
			connection.setRequestMethod("HEAD");
			int code = connection.getResponseCode();// HTTP codul de returnare -> 200 = OK.
			TA.append("" + code);
		} catch (MalformedURLException e) {
			printException(e);
		} catch (IOException e) {
			printException(e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	/**
	 * Progressbar thread
	 * 
	 * @author Steph
	 * 
	 */
	public class progress implements Runnable {
		public void run() {
			for (int i = 0; i <= 100; i++) { // incrementare i progresiva
				progbar.setValue(i); // setare valoare
				progbar.repaint(); // refresh progressbar
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try {
					Thread.sleep(5); // timer
				} catch (InterruptedException err) {
				}
			}
			setCursor(Cursor.getDefaultCursor());
		}
	}

	/**
	 * Panou Deschide Fisier
	 */
	public void setFile() {
		int retval = chooser.showOpenDialog(Crawler.this);
		if (retval == JFileChooser.APPROVE_OPTION) {
			inFile = chooser.getSelectedFile();
			try {
				FileReader fr = new FileReader(inFile);
				BufferedReader bufRdr = new BufferedReader(fr);
				String line = null;
				while ((line = bufRdr.readLine()) != null) {
					TA.append(line);
					TA.append("\n");
					TF2.setText(inFile.getAbsolutePath().toString());
				}
				bufRdr.close();

			} catch (IOException ioex) {
				TA.append("Error!");
			}
		}
	}

	/**
	 * Salvare Sursa
	 */
	public void save() {
		try {
			String s = TA.getText();
			if (s.length() > 0) {
				FileDialog fd = new FileDialog(this, "Save File",
						FileDialog.SAVE);
				if (inFile != null) {
					fd.setFile(inFile.getName()
							.substring(0, inFile.getName().length() - 5)
							.toString()
							+ "_en.html");
				} else {
					fd.setFile("file_en.html");
				}
				fd.setDirectory(".");
				fd.setVisible(true);
				fd.setLocationRelativeTo(null);
				String path = fd.getDirectory() + fd.getFile();
				FileOutputStream fos = new FileOutputStream(path);
				byte[] b = s.getBytes();
				fos.write(b);
				fos.close();
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * FullScreen cu miscare
	 */
	public void onMove() {
		cm.registerComponent(this);
		cr.registerComponent(this);
	}

	/**
	 * FullScreen fara miscare
	 */
	public void offMove() {
		cm.deregisterComponent(this);
		cr.deregisterComponent(this);
	}

	/**
	 * Deschide Fisier
	 * 
	 * @param name
	 */
	public void fileOpen(File name) {
		Desktop dt = null;
		if (Desktop.isDesktopSupported()) {
			dt = Desktop.getDesktop();
		} else {
			JOptionPane.showMessageDialog(null,
					"Desktop support is not supported!");
		}
		if (dt != null) {
			try {
				dt.open(name);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,
						"The file could not be opened:" + name);
			}
		}
	}

	/**
	 * Logfile Exceptie
	 * 
	 * @param ex
	 */
	public static void printException(Exception ex) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EEEE dd/MM/yyyy kk:mm:ss aa");
		Date date = new Date();
		log.println("--------------------------------------------");
		log.println("Date: " + sdf.format(date));
		log.println("Connection Error: " + ex.getMessage());
		log.println("--------------------------------------------");
	}

	/**
	 * Sistem Tray
	 */
	public void inTray() {
		final JPopupMenu popup = new JPopupMenu();
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem show = new JMenuItem("Show HTML Encrypter");
		JMenuItem about = new JMenuItem("About");
		JMenuItem search = new JMenuItem("Search URL / URI");
		JMenuItem help = new JMenuItem("Help");
		JMenuItem logfile = new JMenuItem("Show Log");
		JMenuItem upload = new JMenuItem("FTP Transfer");
		final TrayIcon tray = new TrayIcon(getIconImage().getScaledInstance(16,
				16, 0), "HTML Encrypter", null);

		popup.add(show);
		popup.add(about);
		popup.add(help);
		popup.addSeparator();
		popup.add(search);
		popup.add(upload);
		popup.addSeparator();
		popup.add(logfile);
		popup.add(exit);

		popup.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		exit.setBackground(Color.WHITE);
		show.setBackground(Color.WHITE);
		about.setBackground(Color.WHITE);
		search.setBackground(Color.WHITE);
		help.setBackground(Color.WHITE);
		logfile.setBackground(Color.WHITE);
		upload.setBackground(Color.WHITE);
		about.setIcon(new ImageIcon("resources/icons/menu/about.png"));
		exit.setIcon(new ImageIcon("resources/icons/menu/exit.png"));
		help.setIcon(new ImageIcon("resources/icons/menu/help.png"));
		upload.setIcon(new ImageIcon("resources/icons/menu/upload.png"));

		try {
			SystemTray.getSystemTray().add(tray);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}

		// Actiuni pentru jmenu si trayicon
		tray.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.setLocation(e.getX() + 10, e.getY());
					popup.setInvoker(popup);
					popup.setVisible(true);
				}
			}
		});

		tray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				setState(Crawler.NORMAL);
				SystemTray.getSystemTray().remove(tray);
			}
		});

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		show.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				setState(Crawler.NORMAL);
				SystemTray.getSystemTray().remove(tray);
			}
		});

		about.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new pAbout();
			}
		});

		search.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(null,
						"Insert URL / URI (without http:// ) : ", "Search URL / URI",
						JOptionPane.QUESTION_MESSAGE);
				if (str != null) {
					JOptionPane.showMessageDialog(null,
							"Have you entered the URL : " + str, "Search URL / URI",
							JOptionPane.INFORMATION_MESSAGE);
					TA.setText("");
					TF1.setText("http://" + str);
					setVisible(true);
					setState(Crawler.NORMAL);
					SystemTray.getSystemTray().remove(tray);
					LB2.setText("The search results are: ");
					new Thread(new progress()).start();
					ping();
					if (TA.getText().contentEquals("200")) {
						TA.setText("");
						crawl();
						TF2.setText(TF1.getText() + " was searched");
					} else {
						TA.append(" Failed connection!");
					}
					addHist();
				} else {
					// JOptionPane.showMessageDialog(null,
					// "A-ti apasat butonul renuntare.",
					// "Cautare URL",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		help.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					new helpBox();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		logfile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fileOpen(new File("resources/log/logfile" + sdf.format(date)
						+ ".txt"));
			}
		});

		upload.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new uploadFTP();
				try {
					InetAddress thisIp = InetAddress.getLocalHost();
					uploadFTP.titleFTP.setText("FTP Transfer: "
							+ thisIp.getHostAddress() + " -> "
							+ uploadFTP.adressf.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Adauga Item in istoric cautari
	 */
	public void addHist() {
		final JMenuItem item = new JMenuItem(TF1.getText());
		item.setBackground(Color.WHITE);
		item.setFont(new Font("Arial", Font.BOLD, 12));
		if (name.contentEquals("")) {
			mHist.add(item);
			name = item.getText();
		}
		if (item.getText().contentEquals(name)) {
			// System.out.println("Exista deja!!");
		} else {
			mHist.getMenuComponentCount();
			if (mHist.getMenuComponents().toString()
					.contentEquals(item.getText())) {
				// System.out.println("Exista deja!!");
			} else {
				mHist.add(item);
				name = item.getText();
			}
		}
		// System.out.println(mHist.getMenuComponentCount());
		// System.out.println(item.getText().toString());

		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TF1.setText(item.getText());
				TA.setText("");
				LB2.setText("The search results are: ");
				new Thread(new progress()).start();
				ping();
				if (TA.getText().contentEquals("200")) {
					TA.setText("");
					crawl();
					TF2.setText(TF1.getText() + " was searched");
				} else {
					TA.append(" Failed connection!");
				}
			}
		});
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(5000);
		splash.showSplashAndExit();
		new uiManager();
		new Crawler();
		// try {new helpBox();} catch (IOException e1){e1.printStackTrace();}
	}
}