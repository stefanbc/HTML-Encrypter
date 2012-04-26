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
import javax.swing.*;

/**
 * This class applies the styles to all the main menu components.
 * 
 * @author Stefan Cosma
 *
 */
public class propMenu {

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public propMenu() {

		Encrypter.mb.setBackground(Encrypter.color_dark);
		Encrypter.mb.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Encrypter.mb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		Encrypter.mFile.setMnemonic('F');
		Encrypter.mFile.setDisplayedMnemonicIndex(-1);
		Encrypter.mEdit.setMnemonic('E');
		Encrypter.mEdit.setDisplayedMnemonicIndex(-1);
		Encrypter.mTools.setMnemonic('T');
		Encrypter.mTools.setDisplayedMnemonicIndex(-1);
		Encrypter.mAbout.setMnemonic('H');
		Encrypter.mAbout.setDisplayedMnemonicIndex(-1);

		Encrypter.miFile.setMnemonic('N');
		Encrypter.miOpen.setMnemonic('O');
		Encrypter.miSave.setMnemonic('S');
		Encrypter.miExit.setMnemonic('E');

		Encrypter.miCopy.setMnemonic('C');
		Encrypter.miPaste.setMnemonic('P');

		Encrypter.miBrowse.setMnemonic('U');

		Encrypter.miAbout.setMnemonic('A');
		Encrypter.miHelp.setMnemonic('L');

		Encrypter.mFile.setFont(Encrypter.font16);
		Encrypter.mFile.setBackground(Encrypter.color_dark);
		Encrypter.mFile.setForeground(Encrypter.color_white);
		Encrypter.mFile.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_dark, 2));
		Encrypter.mFile.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 1));

		Encrypter.mEdit.setFont(Encrypter.font16);
		Encrypter.mEdit.setBackground(Encrypter.color_dark);
		Encrypter.mEdit.setForeground(Encrypter.color_white);
		Encrypter.mEdit.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_dark, 2));
		Encrypter.mEdit.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 1));

		Encrypter.mHist.setFont(Encrypter.font12);
		Encrypter.mHist.setPreferredSize(new Dimension(0, 36));
		Encrypter.mHist.setBackground(Encrypter.color_white);
		Encrypter.mHist.setForeground(Encrypter.color_black);
		Encrypter.mHist.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.mHist.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 1));

		Encrypter.mTools.setFont(Encrypter.font16);
		Encrypter.mTools.setBackground(Encrypter.color_dark);
		Encrypter.mTools.setForeground(Encrypter.color_white);
		Encrypter.mTools.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_dark, 3));
		Encrypter.mTools.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 1));

		ImageIcon mPref_icon = getImageIcon("assets/icons/settings.png");
		Encrypter.mPref.setIcon(mPref_icon);
		Encrypter.mPref.setFont(Encrypter.font12);
		Encrypter.mPref.setBackground(Encrypter.color_white);
		Encrypter.mPref.setForeground(Encrypter.color_black);
		Encrypter.mPref.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.mPref.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 1));

		Encrypter.mAbout.setFont(Encrypter.font16);
		Encrypter.mAbout.setBackground(Encrypter.color_dark);
		Encrypter.mAbout.setForeground(Encrypter.color_white);
		Encrypter.mAbout.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_dark, 2));
		Encrypter.mAbout.getPopupMenu().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 1));

		ImageIcon miFile_icon = getImageIcon("assets/icons/new.png");
		Encrypter.miFile.setFont(Encrypter.font12);
		Encrypter.miFile.setBackground(Encrypter.color_white);
		Encrypter.miFile.setForeground(Encrypter.color_black);
		Encrypter.miFile.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miFile.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
		Encrypter.miFile.setIcon(miFile_icon);

		ImageIcon miOpen_icon = getImageIcon("assets/icons/open.png");
		Encrypter.miOpen.setFont(Encrypter.font12);
		Encrypter.miOpen.setBackground(Encrypter.color_white);
		Encrypter.miOpen.setForeground(Encrypter.color_black);
		Encrypter.miOpen.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miOpen.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		Encrypter.miOpen.setIcon(miOpen_icon);

		ImageIcon miSave_icon = getImageIcon("assets/icons/save.png");
		Encrypter.miSave.setFont(Encrypter.font12);
		Encrypter.miSave.setBackground(Encrypter.color_white);
		Encrypter.miSave.setForeground(Encrypter.color_black);
		Encrypter.miSave.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miSave.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
		Encrypter.miSave.setIcon(miSave_icon);

		ImageIcon miExit_icon = getImageIcon("assets/icons/exit.png");
		Encrypter.miExit.setFont(Encrypter.font12);
		Encrypter.miExit.setBackground(Encrypter.color_white);
		Encrypter.miExit.setForeground(Encrypter.color_black);
		Encrypter.miExit.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miExit.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		Encrypter.miExit.setIcon(miExit_icon);

		ImageIcon miUndo_icon = getImageIcon("assets/icons/undo.png");
		Encrypter.miUndo.setFont(Encrypter.font12);
		Encrypter.miUndo.setBackground(Encrypter.color_white);
		Encrypter.miUndo.setForeground(Encrypter.color_black);
		Encrypter.miUndo.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miUndo.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_Z, java.awt.Event.CTRL_MASK));
		Encrypter.miUndo.setIcon(miUndo_icon);

		ImageIcon miRedo_icon = getImageIcon("assets/icons/redo.png");
		Encrypter.miRedo.setFont(Encrypter.font12);
		Encrypter.miRedo.setBackground(Encrypter.color_white);
		Encrypter.miRedo.setForeground(Encrypter.color_black);
		Encrypter.miRedo.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miRedo.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_Y, java.awt.Event.CTRL_MASK));
		Encrypter.miRedo.setIcon(miRedo_icon);

		ImageIcon miCopy_icon = getImageIcon("assets/icons/copy.png");
		Encrypter.miCopy.setFont(Encrypter.font12);
		Encrypter.miCopy.setBackground(Encrypter.color_white);
		Encrypter.miCopy.setForeground(Encrypter.color_black);
		Encrypter.miCopy.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miCopy.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		Encrypter.miCopy.setIcon(miCopy_icon);

		ImageIcon miPaste_icon = getImageIcon("assets/icons/paste.png");
		Encrypter.miPaste.setFont(Encrypter.font12);
		Encrypter.miPaste.setBackground(Encrypter.color_white);
		Encrypter.miPaste.setForeground(Encrypter.color_black);
		Encrypter.miPaste.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miPaste.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_V, java.awt.Event.CTRL_MASK));
		Encrypter.miPaste.setIcon(miPaste_icon);

		ImageIcon miFind_icon = getImageIcon("assets/icons/search.png");
		Encrypter.miFind.setFont(Encrypter.font12);
		Encrypter.miFind.setBackground(Encrypter.color_white);
		Encrypter.miFind.setForeground(Encrypter.color_black);
		Encrypter.miFind.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miFind.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
		Encrypter.miFind.setIcon(miFind_icon);

		Encrypter.miLine.setFont(Encrypter.font12);
		Encrypter.miLine.setPreferredSize(new Dimension(0, 36));
		Encrypter.miLine.setBackground(Encrypter.color_white);
		Encrypter.miLine.setForeground(Encrypter.color_black);
		Encrypter.miLine.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miLine.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_L, java.awt.Event.CTRL_MASK));

		ImageIcon normal = getImageIcon("assets/icons/checkbox_normal.png");
		ImageIcon checked = getImageIcon("assets/icons/checkbox_checked.png");
		Encrypter.miTray.setIcon(normal);
		Encrypter.miTray.setSelectedIcon(checked);
		Encrypter.miTray.setFont(Encrypter.font12);
		Encrypter.miTray.setBackground(Encrypter.color_white);
		Encrypter.miTray.setForeground(Encrypter.color_black);
		Encrypter.miTray.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));

		Encrypter.miOpenURL.setIcon(normal);
		Encrypter.miOpenURL.setSelectedIcon(checked);
		Encrypter.miOpenURL.setFont(Encrypter.font12);
		Encrypter.miOpenURL.setBackground(Encrypter.color_white);
		Encrypter.miOpenURL.setForeground(Encrypter.color_black);
		Encrypter.miOpenURL.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));

		Encrypter.miEditText.setIcon(normal);
		Encrypter.miEditText.setSelectedIcon(checked);
		Encrypter.miEditText.setFont(Encrypter.font12);
		Encrypter.miEditText.setBackground(Encrypter.color_white);
		Encrypter.miEditText.setForeground(Encrypter.color_black);
		Encrypter.miEditText.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		
		Encrypter.miOTE.setIcon(normal);
		Encrypter.miOTE.setSelectedIcon(checked);
		Encrypter.miOTE.setFont(Encrypter.font12);
		Encrypter.miOTE.setBackground(Encrypter.color_white);
		Encrypter.miOTE.setForeground(Encrypter.color_black);
		Encrypter.miOTE.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miOTE.setToolTipText("Recommended to be used only once");

		ImageIcon miAbout_icon = getImageIcon("assets/icons/about.png");
		Encrypter.miAbout.setFont(Encrypter.font12);
		Encrypter.miAbout.setBackground(Encrypter.color_white);
		Encrypter.miAbout.setForeground(Encrypter.color_black);
		Encrypter.miAbout.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miAbout.setIcon(miAbout_icon);

		ImageIcon miHelp_icon = getImageIcon("assets/icons/help.png");
		Encrypter.miHelp.setFont(Encrypter.font12);
		Encrypter.miHelp.setBackground(Encrypter.color_white);
		Encrypter.miHelp.setForeground(Encrypter.color_black);
		Encrypter.miHelp.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
		Encrypter.miHelp.setIcon(miHelp_icon);

		ImageIcon miUpdate_icon = getImageIcon("assets/icons/update.png");
		Encrypter.miUpdate.setFont(Encrypter.font12);
		Encrypter.miUpdate.setBackground(Encrypter.color_white);
		Encrypter.miUpdate.setForeground(Encrypter.color_black);
		Encrypter.miUpdate.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miUpdate.setIcon(miUpdate_icon);

		Encrypter.miLog.setFont(Encrypter.font12);
		Encrypter.miLog.setPreferredSize(new Dimension(0, 36));
		Encrypter.miLog.setBackground(Encrypter.color_white);
		Encrypter.miLog.setForeground(Encrypter.color_black);
		Encrypter.miLog.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miLog.setAccelerator(KeyStroke.getKeyStroke("F2"));

		ImageIcon miBrowse_icon = getImageIcon("assets/icons/show_url.png");
		Encrypter.miBrowse.setFont(Encrypter.font12);
		Encrypter.miBrowse.setBackground(Encrypter.color_white);
		Encrypter.miBrowse.setForeground(Encrypter.color_black);
		Encrypter.miBrowse.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miBrowse.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_U, java.awt.Event.CTRL_MASK));
		Encrypter.miBrowse.setIcon(miBrowse_icon);

		ImageIcon miBlank_icon = getImageIcon("assets/icons/no_blank.png");
		Encrypter.miBlank.setFont(Encrypter.font12);
		Encrypter.miBlank.setBackground(Encrypter.color_white);
		Encrypter.miBlank.setForeground(Encrypter.color_black);
		Encrypter.miBlank.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miBlank.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_B, java.awt.Event.CTRL_MASK));
		Encrypter.miBlank.setIcon(miBlank_icon);

		ImageIcon miFTP_icon = getImageIcon("assets/icons/upload.png");
		Encrypter.miFTP.setFont(Encrypter.font12);
		Encrypter.miFTP.setBackground(Encrypter.color_white);
		Encrypter.miFTP.setForeground(Encrypter.color_black);
		Encrypter.miFTP.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miFTP.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_T, java.awt.Event.CTRL_MASK));
		Encrypter.miFTP.setIcon(miFTP_icon);

		ImageIcon miNet_icon = getImageIcon("assets/icons/network.png");
		Encrypter.miNet.setFont(Encrypter.font12);
		Encrypter.miNet.setBackground(Encrypter.color_white);
		Encrypter.miNet.setForeground(Encrypter.color_black);
		Encrypter.miNet.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_white, 3));
		Encrypter.miNet.setAccelerator(KeyStroke.getKeyStroke("F3"));
		Encrypter.miNet.setIcon(miNet_icon);

		ImageIcon popCopy_icon = getImageIcon("assets/icons/copy.png");
		ImageIcon popPaste_icon = getImageIcon("assets/icons/paste.png");
		Encrypter.popUp.setBackground(Encrypter.color_light);
		Encrypter.popUp.setForeground(Encrypter.color_black);
		Encrypter.popUp.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_black, 1));
		Encrypter.popCopy.setBackground(Encrypter.color_light);
		Encrypter.popCopy.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_light, 2));
		Encrypter.popCopy.setIcon(popCopy_icon);
		Encrypter.popPaste.setBackground(Encrypter.color_light);
		Encrypter.popPaste.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_light, 2));
		Encrypter.popPaste.setIcon(popPaste_icon);
	}

}
