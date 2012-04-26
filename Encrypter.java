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
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JPopupMenu.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import Proiect.js.*;

/**
 * <b>Author</b>: Stefan Cosma <br>
 * <b>Description</b>: Using encryption/decryption algorithms to hide HTML code <br>
 * <b>Name</b>: HTML Encrypter <br>
 * <b>URL</b>: <a
 * href="http://htmlencrypter.call-to-action.ro">www.htmlencrypter.ro</a> <br>
 * <b>Year</b>: 2011 - 2012 <br>
 * <b>Last stable version</b>: 2.0 [25.04.2012] <br>
 * <b>Status</b>: In development
 */
public class Encrypter extends JFrame {

	/*
	 * Create all the panels
	 */

	// ***************************************//

	// Main panel
	static JPanel Center = new JPanel();
	// Main side panels
	static JPanel West = new JPanel();
	static JPanel East = new JPanel();
	static JPanel South = new JPanel();
	// Additional panels
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
	static JPanel ad_pan1 = new JPanel();
	static JPanel ad_pan11 = new JPanel();
	// ***************************************//

	/*
	 * Create general window components
	 */

	// ***************************************//

	// Search URL texfield
	static JTextField TF1 = new JTextField(
			"http://htmlencrypter.call-to-action.ro", 30);
	// Status textfield
	static JTextField TF2 = new JTextField(30);

	// Search URL label
	static JLabel LB1 = new JLabel("Insert URL / URI: ");
	// Status label
	static JLabel LB2 = new JLabel("The search results are: ");
	// Choose methods label
	static JLabel LB3 = new JLabel("Encryption/decryption method: ");
	// Version label
	static JLabel LB4 = new JLabel("HTML Encrypter 2.0");

	// Undo Manager for the Textarea
	static public UndoManager undoM = new UndoManager();
	// Main Textarea for results
	public static JTextArea TA = new JTextArea(20, 50);
	// Line counts left of the textarea
	static JTextArea TAlines = new JTextArea();
	// Main Scroll pane for the main Textarea
	static JScrollPane scroll = new JScrollPane(TA);
	// Highlight row textarea
	LinePainter painter = new LinePainter(TA);

	// Search button
	static JButton search = new JButton("");
	// Encrypt button
	static JButton crypt = new JButton("Encrypt");
	// Decrypt button
	static JButton decrypt = new JButton("Decrypt");
	// Main Window Exit button
	static JButton exit = new JButton();
	// Main Window Maximize button
	static JButton maxim = new JButton();
	// Main Window Minimize button
	static JButton minim = new JButton();

	// Combobox choose Encryption/Decryption method
	static JComboBox combo = new JComboBox();
	// Checkbox for the no click script
	public static JCheckBox no_click = new JCheckBox("Disable right click");
	// Variable for the no click script
	public static String no_click_script = "<!-- NO CLICK SCRIPT -->\n"
			+ "<script src='http://tinyurl.com/7xdymfx' type='text/javascript'></script>\n"
			+ "<!-- END NO CLICK SCRIPT -->\n";
	// ***************************************//

	/*
	 * Create main menu components
	 */

	// ***************************************//

	// Main menu component
	static JMenuBar mb = new JMenuBar();
	static JMenu mFile = new JMenu("File");
	static JMenuItem miFile = new JMenuItem("New Search");
	static JMenuItem miOpen = new JMenuItem("Open File...");
	static JMenuItem miSave = new JMenuItem("Save Source Code");
	static JMenuItem miExit = new JMenuItem("Exit");
	// Submenu in the File menu
	static JMenu mHist = new JMenu("Search History");
	static JMenu mEdit = new JMenu("Edit");
	static JMenuItem miUndo = new JMenuItem("Undo");
	static JMenuItem miRedo = new JMenuItem("Redo");
	static JMenuItem miCopy = new JMenuItem("Copy");
	static JMenuItem miPaste = new JMenuItem("Paste");
	static JMenuItem miFind = new JMenuItem("Find");
	static JMenuItem miLine = new JMenuItem("Find Line...");
	// Submenu in the Edit menu
	static JMenu mPref = new JMenu("Preferences");
	static JToggleButton miTray = new JToggleButton("Show system tray", true);
	static JToggleButton miOpenURL = new JToggleButton("Open file after save",
			false);
	static JToggleButton miEditText = new JToggleButton("Edit source code",
			false);
	public static JToggleButton miOTE = new JToggleButton(
			"Use One Time Encryption", false);
	static JMenu mTools = new JMenu("Tools");
	static JMenuItem miBrowse = new JMenuItem("Open current URL");
	static JMenuItem miBlank = new JMenuItem("Remove _blank");
	static JMenuItem miFTP = new JMenuItem("FTP Transfer");
	static JMenu mAbout = new JMenu("Help");
	static JMenuItem miAbout = new JMenuItem("About HTML Encrypter");
	static JMenuItem miHelp = new JMenuItem("Help");
	static JMenuItem miLog = new JMenuItem("Show Log");
	static JMenuItem miUpdate = new JMenuItem("Check for Updates");
	static JMenuItem miNet = new JMenuItem("System Information");
	// ***************************************//

	/*
	 * Create right click menu components
	 */

	// ***************************************//

	// Popup menu main component
	static JPopupMenu popUp = new JPopupMenu();
	// Copy component
	static JMenuItem popCopy = new JMenuItem("Copy");
	// Paste component
	static JMenuItem popPaste = new JMenuItem("Paste");
	// ***************************************//

	/*
	 * Create sidebar components
	 */

	// ***************************************//

	// New document/file/search
	static JButton new_doc = new JButton(" ");
	// Open file
	static JButton open = new JButton(" ");
	// Copy text
	static JButton copy = new JButton(" ");
	// Paste text
	static JButton paste = new JButton(" ");
	// Save source code
	static JButton save = new JButton(" ");
	// Remove all blank spaces from the document
	static JButton no_blank = new JButton(" ");
	// Open the Upload to FTP window
	static JButton upload = new JButton(" ");
	// ***************************************//

	/*
	 * Other variables/components
	 */

	// ***************************************//

	// File chooser component
	static JFileChooser chooser = new JFileChooser(".");
	// Clipboard variable
	final Clipboard clipboard = getToolkit().getSystemClipboard();
	// Application version type
	private static final long serialVersionUID = 1L;
	// Move windows variable
	ComponentMover cm = new ComponentMover();
	// Resize window variable
	// ComponentResizer cr = new ComponentResizer();
	// Logfile date format
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
	// Date variable for logfile
	Date date = new Date();
	// File variable for logfile
	File logfile = new File("assets/log/" + "logfile" + sdf.format(date)
			+ ".txt");
	// Write stream for logfile
	static PrintStream log = null;
	// Show date for logfile
	Calendar cal = Calendar.getInstance();
	// Variable for search history
	String name = "";
	// Open file variable
	static File inFile;
	// Get OS name
	static String osName = System.getProperty("os.name").toLowerCase();
	// Check is OS is Mac OS
	public static boolean isMacOS = osName.startsWith("mac");
	// Check is OS is Linux
	public static boolean isLinux = osName.startsWith("linux");
	// Check if file needs to be saved
	public static boolean needSave = false;
	// ***************************************//

	/*
	 * Encryption/Decryption keys
	 */

	// ***************************************//
	// Encryption/Decryption inner key
	public static String key;
	// Encryption/Decryption main key
	public static String mainKey;
	// Normal Encryption/Decryption key
	public static String normalKey = "0123456789ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvxyz";
	// ***************************************//

	/*
	 * Global styles
	 */

	// ***************************************//

	// 12px font size
	static Font font12 = new Font("Trebuchet MS", Font.PLAIN, 12);
	// 14px font size
	static Font font16 = new Font("Trebuchet MS", Font.PLAIN, 14);
	// Light color
	static public Color color_light = new Color(0xf5f5f5);
	// Dark color
	static public Color color_dark = new Color(0x282828);
	// Blue color
	static public Color color_blue = new Color(0x33b5e5);
	// Global blank color
	static public Color color_black = Color.BLACK;
	// Global white color
	static public Color color_white = Color.WHITE;
	// ***************************************//

	/*
	 * Global alerts
	 */

	// ***************************************//

	// Ping failed connection
	String error1 = " Failed connection!";
	// Encryption failed
	String error2 = " Encryption not possible!";
	// Decryption failed
	String error3 = " Decryption not possible!";
	// No URL in search textfield
	String error4 = " Please insert a URL in box above!";
	// Empty result area
	String error5 = " Nothing to save!";

	/**
	 * Get absolute path for any image
	 * 
	 * @param name
	 * @return
	 */
	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	/**
	 * Constructor
	 */
	public Encrypter() {
		super(LB4.getText());
		// For Alt+F4
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Main Icon
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		// Remove window decorations
		setUndecorated(true);
		// And remove the border
		getRootPane().setBorder(BorderFactory.createLineBorder(color_black, 0));

		// Move window
		cm.registerComponent(this);
		// cr.setSnapSize(new Dimension(10, 10));
		// Resize Window
		// cr.registerComponent(this);
		// cm.setDragInsets(cr.getDragInsets());

		// Add transparency on the sides of the main window
		Transparency west = new Transparency(this);
		Transparency east = new Transparency(this);

		setLayout(new BorderLayout());
		Center.setLayout(new BorderLayout());
		West.setLayout(new FlowLayout());
		East.setLayout(new FlowLayout());
		South.setLayout(new GridBagLayout());
		main_North.setLayout(new BorderLayout());
		main_Center.setLayout(new BorderLayout());
		main_South.setLayout(new BorderLayout());
		main_West.setLayout(new BorderLayout());
		main_East.setLayout(new FlowLayout());
		pan1.setLayout(new BorderLayout());
		pan2.setLayout(new BorderLayout());
		pan3.setLayout(new BorderLayout());
		pan4.setLayout(new BorderLayout());
		in_pan41.setLayout(new GridLayout(1, 3, 10, 0));
		pan5.setLayout(new BorderLayout());
		in_pan21.setLayout(new BorderLayout());
		in_pan211.setLayout(new BorderLayout());
		in_pan22.setLayout(new BorderLayout());
		ad_pan1.setLayout(new BorderLayout());
		ad_pan11.setLayout(new GridLayout(0, 1));
		// ***************************************//

		add(Center, BorderLayout.CENTER);
		getContentPane().add(west, BorderLayout.WEST);
		getContentPane().add(east, BorderLayout.EAST);
		add(South, BorderLayout.SOUTH);
		// ***************************************//

		Center.add(main_North, BorderLayout.NORTH);
		main_North.add(pan1);
		pan1.add(Box.createHorizontalStrut(20), BorderLayout.WEST);
		pan1.add(mb, BorderLayout.CENTER);
		mb.add(mFile);
		mFile.add(miFile);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(mHist);
		mFile.add(miExit);
		mb.add(mEdit);
		mEdit.add(miUndo);
		mEdit.add(miRedo);
		mEdit.add(miCopy);
		mEdit.add(miPaste);
		mEdit.add(new Separator());
		mEdit.add(miFind);
		mEdit.add(miLine);
		mEdit.add(new Separator());
		mEdit.add(mPref);
		mPref.add(miTray);
		mPref.add(miOpenURL);
		mPref.add(miEditText);
		mPref.add(miOTE);
		mb.add(mTools);
		mTools.add(miBrowse);
		mTools.add(miBlank);
		mTools.add(miFTP);
		mb.add(mAbout);
		mAbout.add(miHelp);
		mAbout.add(miLog);
		mAbout.add(miUpdate);
		mAbout.add(miAbout);
		mAbout.add(miNet);
		pan1.add(in_pan11, BorderLayout.EAST);
		in_pan11.add(minim);
		in_pan11.add(maxim);
		in_pan11.add(exit);
		// ***************************************//

		Center.add(main_West, BorderLayout.WEST);
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
		// ***************************************//

		Center.add(main_Center, BorderLayout.CENTER);
		main_Center.add(pan2, BorderLayout.NORTH);
		pan2.add(in_pan21, BorderLayout.NORTH);
		in_pan21.add(LB1, BorderLayout.WEST);
		in_pan21.add(in_pan211, BorderLayout.CENTER);
		in_pan211.add(Box.createHorizontalStrut(50), BorderLayout.WEST);
		in_pan211.add(TF1, BorderLayout.CENTER);
		in_pan211.add(search, BorderLayout.EAST);
		pan2.add(in_pan22, BorderLayout.SOUTH);
		in_pan22.add(LB2, BorderLayout.WEST);
		in_pan22.add(TF2, BorderLayout.CENTER);
		main_Center.add(pan3, BorderLayout.CENTER);
		pan3.add(scroll);
		// ***************************************//

		Center.add(main_East, BorderLayout.EAST);
		main_East.add(Box.createHorizontalStrut(20));
		// ***************************************//

		Center.add(main_South, BorderLayout.SOUTH);
		main_South.add(pan4, BorderLayout.NORTH);
		pan4.add(Box.createHorizontalStrut(20), BorderLayout.WEST);
		pan4.add(in_pan41, BorderLayout.CENTER);
		in_pan41.add(LB3);
		in_pan41.add(combo);
		combo.insertItemAt("JavaScript Blowfish", 0);
		combo.insertItemAt("JavaScript AES", 1);
		combo.insertItemAt("JavaScript Rabbit", 2);
		combo.insertItemAt("JavaScript MARC4", 3);
		combo.insertItemAt("JavaScript TEA", 4);
		combo.insertItemAt("JavaScript Escape", 5);
		combo.setSelectedIndex(0);
		in_pan41.add(no_click);
		pan4.add(in_pan42, BorderLayout.NORTH);
		in_pan42.add(crypt);
		in_pan42.add(Box.createHorizontalStrut(10));
		in_pan42.add(decrypt);
		main_South.add(pan5, BorderLayout.SOUTH);
		pan5.add(Box.createVerticalStrut(20));
		// ***************************************//

		South.add(LB4);
		// ***************************************//

		popUp.add(popCopy);
		popUp.add(popPaste);
		// ***************************************//

		// Write exception in logfile
		try {
			log = new PrintStream(logfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Call methods for all the components
		// Styles for all the components
		new setProp();
		// Styles for the main menu
		new propMenu();
		action();
		actMenu();
		actSidebar();

		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * Buttons actions
	 */
	public void action() {
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (TF1.getText().contentEquals("http://")
							|| TF1.getText().contentEquals("")) {
						TA.setText("");
						TA.append(error4);
					} else {
						new Thread(new progress()).start();
						TA.setText("");
						LB2.setText("The search results are: ");
						ping();
						if (TA.getText().contentEquals("200")) {
							TA.setText("");
							crawl();
							TF2.setText(TF1.getText() + " was searched");
						} else {
							TA.append(error1);
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
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error2);
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
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error2);
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
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error2);
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
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error2);
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
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error2);
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
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error2);
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
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error3);
						} else {
							if (TA.getText().startsWith(
									jsBlowfish.html_top_start)) {
								try {
									new Thread(new progress()).start();
									jsBlowfish.jsBlowfishDe(TA.getText());
									LB2.setText("The decryption results are: ");
									TF2.setText(TF1.getText()
											+ " was succesfully decrypted");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
							} else {
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript AES")) {
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error3);
						} else {
							if (TA.getText().startsWith(jsAES.html_top_start)) {
								try {
									new Thread(new progress()).start();
									jsAES.jsAESDe(TA.getText());
									LB2.setText("The decryption results are: ");
									TF2.setText(TF1.getText()
											+ " was succesfully decrypted");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
							} else {
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript Rabbit")) {
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error3);
						} else {
							if (TA.getText()
									.startsWith(jsRabbit.html_top_start)) {
								try {
									new Thread(new progress()).start();
									jsRabbit.jsRabbitDe(TA.getText());
									LB2.setText("The decryption results are: ");
									TF2.setText(TF1.getText()
											+ " was succesfully decrypted");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
							} else {
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript MARC4")) {
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error3);
						} else {
							if (TA.getText().startsWith(jsMARC4.html_top_start)) {
								try {
									new Thread(new progress()).start();
									jsMARC4.jsMARC4De(TA.getText());
									LB2.setText("The decryption results are: ");
									TF2.setText(TF1.getText()
											+ " was succesfully decrypted");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
							} else {
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript TEA")) {
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error3);
						} else {
							if (TA.getText().startsWith(jsTEA.html_top_start)) {
								try {
									new Thread(new progress()).start();
									jsTEA.jsTEADe(TA.getText());
									LB2.setText("The decryption results are: ");
									TF2.setText(TF1.getText()
											+ " was succesfully decrypted");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
							} else {
							}
						}
					}
					if (combo.getSelectedItem().equals("JavaScript Escape")) {
						if (TA.getText().contentEquals(error1)
								|| TA.getText().contentEquals(error2)
								|| TA.getText().contentEquals(error3)
								|| TA.getText().contentEquals(error4)
								|| TA.getText().contentEquals(error5)
								|| TA.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error3);
						} else {
							if (TA.getText().startsWith(jsEscape.html_top)) {
								try {
									new Thread(new progress()).start();
									jsEscape.jsUnescapeText(TA.getText());
									LB2.setText("The decryption results are: ");
									TF2.setText(TF1.getText()
											+ " was succesfully decrypted");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
							} else {
							}
						}
					}
				} catch (IllegalArgumentException e1) {
				}
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TA.getText().contentEquals(error1)
						|| TA.getText().contentEquals(error2)
						|| TA.getText().contentEquals(error3)
						|| TA.getText().contentEquals(error4)
						|| TA.getText().contentEquals(error5)
						|| TA.getText().contentEquals("")) {
					saveState();
					System.exit(0);
				} else {
					if (needSave == false) {
						saveState();
						new needSave();
					} else {
						saveState();
						System.exit(0);
					}
				}
			}
		});

		maxim.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isMacOS) {
					Rectangle maxBounds = GraphicsEnvironment
							.getLocalGraphicsEnvironment()
							.getMaximumWindowBounds();

					if (getBounds().contains(maxBounds)) {
						onMove();
						setSize(800, 600);
						setLocationRelativeTo(null);
					} else {
						offMove();
						setBounds(maxBounds);
					}
				} else {
					Rectangle maxBounds = GraphicsEnvironment
							.getLocalGraphicsEnvironment()
							.getMaximumWindowBounds();

					if (getBounds().contains(maxBounds)) {
						onMove();
						Window w_normal = Encrypter.this;
						com.sun.awt.AWTUtilities.setWindowShape(w_normal,
								new RoundRectangle2D.Double(0, 0, 800, 600, 15,
										15));
						repaint(0, 0, 800, 600);
						setSize(800, 600);
						update(getGraphics());
						setLocationRelativeTo(null);
					} else {
						offMove();
						Window w = Encrypter.this;
						com.sun.awt.AWTUtilities.setWindowShape(w,
								new Rectangle2D.Double());
						setBounds(maxBounds);
						repaint();
						updateUI();
					}
				}
			}
		});

		minim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (miTray.isSelected()) {
					inTray();
					setVisible(false);
				} else {
					setState(Encrypter.ICONIFIED);
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

		TA.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				undoM.addEdit(e.getEdit());
				updateButtons();
			}
		});

		TA.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				if (miEditText.isSelected()) {
					TA.setEditable(true);
				} else {
					TA.setEditable(false);
				}
			}
		});

		TF1.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					try {
						if (TF1.getText().contentEquals("http://")
								|| TF1.getText().contentEquals("")) {
							TA.setText("");
							TA.append(error4);
						} else {
							new Thread(new progress()).start();
							TA.setText("");
							LB2.setText("The search results are: ");
							ping();
							if (TA.getText().contentEquals("200")) {
								TA.setText("");
								crawl();
								TF2.setText(TF1.getText() + " was searched");
							} else {
								TA.append(error1);
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
	 * Menu Items actions
	 */
	public void actMenu() {
		miFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TA.setText("");
				TF1.setText("http://");
				TF2.setText("");
				LB2.setText("The search results are: ");
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
							|| TA.getText().contentEquals("Nothing to save!")) {
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
				if (TA.getText().contentEquals(error1)
						|| TA.getText().contentEquals(error2)
						|| TA.getText().contentEquals(error3)
						|| TA.getText().contentEquals(error4)
						|| TA.getText().contentEquals(error5)
						|| TA.getText().contentEquals("")) {
					saveState();
					System.exit(0);
				} else {
					if (needSave == false) {
						saveState();
						new needSave();
					} else {
						saveState();
						System.exit(0);
					}
				}
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
					uploadFTP.titleFTP.setText("Connection: "
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

				netInfo.win.setText("Platform: " + os_name);
				netInfo.ver.setText("Version: " + os_version);
				netInfo.arch.setText("Architecture: " + os_arch);
				netInfo.java.setText("Java Version: " + java_ver);
				try {
					InetAddress thisIp = InetAddress.getLocalHost();
					netInfo.ip.setText("Local IP: " + thisIp.getHostAddress());
					netInfo.name.setText("Localhost: " + thisIp.getHostName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		miLog.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BrowserLaunch.openURL(logfile.getAbsolutePath());
			}
		});

		miUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BrowserLaunch.openURL("http://tinyurl.com/7a779xz");
			}
		});

		miUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					undoM.undo();
				} catch (CannotRedoException cre) {
					cre.printStackTrace();
				}
				updateButtons();
			}
		});

		miRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					undoM.redo();
				} catch (CannotRedoException cre) {
					cre.printStackTrace();
				}
				updateButtons();
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
	 * Sidebar buttons actions
	 */
	public void actSidebar() {
		new_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TA.setText("");
				TF1.setText("http://");
				TF2.setText("");
				LB2.setText("The search results are: ");
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
					if (TA.getText().contentEquals(error1)
							|| TA.getText().contentEquals(error2)
							|| TA.getText().contentEquals(error3)
							|| TA.getText().contentEquals(error4)
							|| TA.getText().contentEquals(error5)
							|| TA.getText().contentEquals("")) {
						TA.setText("");
						TA.append(error5);
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
					uploadFTP.titleFTP.setText("Connection: "
							+ thisIp.getHostAddress() + " -> "
							+ uploadFTP.adressf.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crawl the URL and get the source code
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
	 * Ping the URL
	 */
	public void ping() {
		HttpURLConnection connection = null;
		try {
			URL u = new URL(TF1.getText());
			connection = (HttpURLConnection) u.openConnection();
			connection.setRequestMethod("HEAD");
			// 200 is the OK response code
			int code = connection.getResponseCode();
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
	 * Start thread and add spinner
	 */
	public class progress implements Runnable {
		public void run() {
			long start = System.nanoTime();
			long end = System.nanoTime();

			loadSpinner spinner = new loadSpinner((int) ((int) end - start));
			spinner.showLoaderAndExit();
		}
	}

	/**
	 * Open the file reader
	 */
	public void setFile() {
		int retval = chooser.showOpenDialog(Encrypter.this);
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
	 * Save the source code
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

				if (miOpenURL.isSelected()) {
					if (fd.getFile() == null) {
						return;
					} else {
						BrowserLaunch.openURL(path);
					}
				}

				needSave = true;

				if (fd.getFile() == null) {
					return;
				} else {
					FileOutputStream fos = new FileOutputStream(path);
					byte[] b = s.getBytes();
					fos.write(b);
					fos.close();
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Add movement to the window when exiting fullscreen
	 */
	public void onMove() {
		cm.registerComponent(this);
		// cr.registerComponent(this);
	}

	/**
	 * Remove movement from the window when in fullscreen
	 */
	public void offMove() {
		cm.deregisterComponent(this);
		// cr.deregisterComponent(this);
	}

	/**
	 * If exception write to logfile
	 * 
	 * @param ex
	 */
	public static void printException(Exception ex) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EEEE dd/MM/yyyy kk:mm:ss aa");
		Date date = new Date();
		log.println("--------------------------------------------\n");
		log.println("Date: " + sdf.format(date) + "\n");
		log.println("Error: " + ex.getMessage() + "\n");
		log.println("Cause: You typed the URL incorrectly, probably!" + "\n");
		log.println("--------------------------------------------");
	}

	/**
	 * Add to system tray
	 */
	public void inTray() {
		if (SystemTray.isSupported()) {

			SystemTray systemTray = SystemTray.getSystemTray();

			Image icon = null;

			if (isLinux) {
				icon = Toolkit.getDefaultToolkit().getImage(
						getClass().getClassLoader().getResource(
								"assets/tray_linux.png"));
			} else {
				icon = Toolkit.getDefaultToolkit().getImage(
						getClass().getClassLoader().getResource(
								"assets/tray_win.png"));
			}

			final TrayIcon tray = new TrayIcon(icon);
			final PopupMenu popup = new PopupMenu();

			// tray.setImageAutoSize(true);

			MenuItem exit = new MenuItem("Exit");
			MenuItem show = new MenuItem("Show HTML Encrypter");
			MenuItem about = new MenuItem("About");
			MenuItem search = new MenuItem("Search URL / URI");
			MenuItem help = new MenuItem("Help");
			final MenuItem logfile = new MenuItem("Show Log");
			MenuItem upload = new MenuItem("FTP Transfer");

			popup.add(show);
			popup.add(about);
			popup.add(help);
			popup.addSeparator();
			popup.add(search);
			popup.add(upload);
			popup.addSeparator();
			popup.add(logfile);
			popup.add(exit);

			tray.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(true);
					setState(Encrypter.NORMAL);
					SystemTray.getSystemTray().remove(tray);
				}
			});

			exit.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (TA.getText().contentEquals(error1)
							|| TA.getText().contentEquals(error2)
							|| TA.getText().contentEquals(error3)
							|| TA.getText().contentEquals(error4)
							|| TA.getText().contentEquals(error5)
							|| TA.getText().contentEquals("")) {
						saveState();
						System.exit(0);
					} else {
						if (needSave == false) {
							saveState();
							new needSave();
						} else {
							saveState();
							System.exit(0);
						}
					}
				}
			});

			show.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					setVisible(true);
					setState(Encrypter.NORMAL);
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
					new searchTray();
				}
			});

			searchTray.searchB.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (searchTray.searchF.getText().contentEquals("http://")
							|| searchTray.searchF.getText().contentEquals("")) {
						return;
					} else {
						String str = searchTray.searchF.getText();
						TA.setText("");
						TF1.setText(str);
						setVisible(true);
						setState(Encrypter.NORMAL);
						SystemTray.getSystemTray().remove(tray);
						new Thread(new progress()).start();
						TA.setText("");
						LB2.setText("The search results are: ");
						ping();
						if (TA.getText().contentEquals("200")) {
							TA.setText("");
							crawl();
							TF2.setText(TF1.getText() + " was searched");
						} else {
							TA.append(error1);
						}
					}
					addHist();
					searchTray.searchTray.dispose();
				}
			});

			searchTray.searchF.addKeyListener(new KeyListener() {

				public void keyTyped(KeyEvent e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_ENTER) {
						if (searchTray.searchF.getText().contentEquals(
								"http://")
								|| searchTray.searchF.getText().contentEquals(
										"")) {
							return;
						} else {
							String str = searchTray.searchF.getText();
							TA.setText("");
							TF1.setText(str);
							setVisible(true);
							setState(Encrypter.NORMAL);
							SystemTray.getSystemTray().remove(tray);
							new Thread(new progress()).start();
							TA.setText("");
							LB2.setText("The search results are: ");
							ping();
							if (TA.getText().contentEquals("200")) {
								TA.setText("");
								crawl();
								TF2.setText(TF1.getText() + " was searched");
							} else {
								TA.append(error1);
							}
						}
						addHist();
						searchTray.searchTray.dispose();
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
					BrowserLaunch.openURL(logfile.toString());
				}
			});

			upload.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					new uploadFTP();
					try {
						InetAddress thisIp = InetAddress.getLocalHost();
						uploadFTP.titleFTP.setText("Connection: "
								+ thisIp.getHostAddress() + " -> "
								+ uploadFTP.adressf.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});

			try {
				tray.setPopupMenu(popup);
				systemTray.add(tray);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Save URL in search history menu
	 */
	public void addHist() {
		final JMenuItem item = new JMenuItem(TF1.getText());
		item.setBackground(color_white);
		item.setFont(font12);
		item.setBorder(BorderFactory.createLineBorder(color_white, 3));
		if (name.contentEquals("")) {
			mHist.add(item);
			name = item.getText();
		}
		if (item.getText().contentEquals(name)) {
			// System.out.println("You have already searched for this URL!");
		} else {
			mHist.getMenuComponentCount();
			if (mHist.getMenuComponents().toString()
					.contentEquals(item.getText())) {
				// System.out.println("You have already searched for this URL!!");
			} else {
				mHist.add(item);
				name = item.getText();
			}
		}

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
					TA.append(error1);
				}
			}
		});
	}

	/**
	 * Action for undo/redo button in Edit menu
	 */
	public void updateButtons() {
		miUndo.setText(undoM.getUndoPresentationName());
		miRedo.setText(undoM.getRedoPresentationName());
		miUndo.setEnabled(undoM.canUndo());
		miRedo.setEnabled(undoM.canRedo());
	}

	/**
	 * Save preferences/state
	 */
	public void saveState() {
		try {
			String url = TF1.getText();
			FileOutputStream fileStream = new FileOutputStream(ClassLoader
					.getSystemResource("config.prop").getPath());
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(miTray);
			os.writeObject(miOpenURL);
			os.writeObject(miEditText);
			os.writeObject(miOTE);
			os.writeObject(url);
			os.close();
			fileStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load preferences/state
	 */
	public static void loadState() {
		try {
			FileInputStream fileStream = new FileInputStream(ClassLoader
					.getSystemResource("config.prop").getPath());
			ObjectInputStream os = new ObjectInputStream(fileStream);
			miTray = (JToggleButton) os.readObject();
			miOpenURL = (JToggleButton) os.readObject();
			miEditText = (JToggleButton) os.readObject();
			miOTE = (JToggleButton) os.readObject();
			TF1.setText(os.readObject().toString());
			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update components UI
	 */
	public static void updateUI() {
		mb.updateUI();
		mFile.updateUI();
		miFile.updateUI();
		miOpen.updateUI();
		miSave.updateUI();
		miExit.updateUI();
		mHist.updateUI();
		mEdit.updateUI();
		miUndo.updateUI();
		miRedo.updateUI();
		miCopy.updateUI();
		miPaste.updateUI();
		miFind.updateUI();
		miLine.updateUI();
		mPref.updateUI();
		miTray.updateUI();
		miOpenURL.updateUI();
		miEditText.updateUI();
		miOTE.updateUI();
		mTools.updateUI();
		miBrowse.updateUI();
		miBlank.updateUI();
		miFTP.updateUI();
		mAbout.updateUI();
		miAbout.updateUI();
		miHelp.updateUI();
		miLog.updateUI();
		miUpdate.updateUI();
		miNet.updateUI();
		popUp.updateUI();
		popCopy.updateUI();
		popPaste.updateUI();
		no_click.updateUI();
	}

	/**
	 * Generate key for the encryption/decryption
	 * 
	 * @param keyGen
	 * @return keyGen
	 */
	public static String genKey(String keyGen) {
		if (Encrypter.miOTE.isSelected()) {
			keyGen = Long.toHexString(Double.doubleToLongBits(Math.random()));
		} else {
			keyGen = normalKey;
		}
		return keyGen;
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		loadSpinner splash = new loadSpinner(5000);
		splash.showLoaderAndExit();

		new uiManager();
		updateUI();

		loadState();

		if (isMacOS) {
			new Encrypter();
		} else {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Window w = new Encrypter();
					com.sun.awt.AWTUtilities.setWindowShape(
							w,
							new RoundRectangle2D.Double(0, 0, w.getWidth(), w
									.getHeight(), 15, 15));
				}
			});
		}
	}
}