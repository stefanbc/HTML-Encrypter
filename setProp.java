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
import javax.swing.filechooser.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.*;

/**
 * This class applies all the styles to all the components.
 * 
 * @author Stefan Cosma
 * 
 */
public class setProp {

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public setProp() {
		
		// Get current delay
		int initialDelay = ToolTipManager.sharedInstance().getInitialDelay();

		// Show tool tips immediately
		ToolTipManager.sharedInstance().setInitialDelay(0);

		// Show tool tips after some delay
		initialDelay = 200;
		ToolTipManager.sharedInstance().setInitialDelay(initialDelay);
		
		Encrypter.Center.setBackground(Encrypter.color_light);
		Encrypter.West.setBackground(Encrypter.color_dark);
		Encrypter.East.setBackground(Encrypter.color_dark);
		Encrypter.South.setBackground(Encrypter.color_dark);
		Encrypter.main_North.setBackground(Encrypter.color_light);
		Encrypter.main_South.setBackground(Encrypter.color_light);
		Encrypter.main_West.setBackground(Encrypter.color_light);
		Encrypter.main_East.setBackground(Encrypter.color_light);
		Encrypter.pan1.setBackground(Encrypter.color_dark);
		Encrypter.pan2.setBackground(Encrypter.color_light);
		Encrypter.pan3.setBackground(Encrypter.color_light);
		Encrypter.pan4.setBackground(Encrypter.color_light);
		Encrypter.pan5.setBackground(Encrypter.color_light);
		Encrypter.in_pan11.setBackground(Encrypter.color_dark);
		Encrypter.in_pan21.setBackground(Encrypter.color_light);
		Encrypter.in_pan211.setBackground(Encrypter.color_light);
		Encrypter.in_pan22.setBackground(Encrypter.color_light);
		Encrypter.in_pan41.setBackground(Encrypter.color_light);
		Encrypter.in_pan42.setBackground(Encrypter.color_light);
		Encrypter.ad_pan1.setBackground(Encrypter.color_light);
		Encrypter.ad_pan11.setBackground(Encrypter.color_light);
		Encrypter.in_pan21.setBorder(BorderFactory
				.createEmptyBorder(5, 0, 0, 0));
		Encrypter.in_pan41.setBorder(BorderFactory.createEmptyBorder(10, 0, 0,
				0));

		Encrypter.TA.setEditable(false);
		Encrypter.TA.setBackground(Encrypter.color_light);
		Encrypter.TA.setForeground(Encrypter.color_black);
		Encrypter.TA.setSelectionColor(Encrypter.color_blue);
		Encrypter.TA.setSelectedTextColor(Encrypter.color_white);
		Encrypter.TA.setLineWrap(true);
		Encrypter.TA.setFont(Encrypter.font12);
		Encrypter.TA.setWrapStyleWord(true);
		Encrypter.TA.setBorder(BorderFactory.createMatteBorder(0, 6, 0, 0,
				Encrypter.color_light));
		DefaultCaret caret = (DefaultCaret) Encrypter.TA.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

		Encrypter.TAlines.setEditable(false);
		Encrypter.TAlines.setBackground(Encrypter.color_light);
		Encrypter.TAlines.setForeground(Encrypter.color_black);
		Encrypter.TAlines.setSelectionColor(Encrypter.color_light);
		Encrypter.TAlines.setSelectedTextColor(Encrypter.color_black);
		Encrypter.TAlines.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 7,
				Encrypter.color_light));
		Encrypter.TAlines.setColumns(2);

		Encrypter.scroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		Encrypter.scroll.setViewportBorder(BorderFactory.createMatteBorder(0,
				1, 0, 0, new Color(0xC9C9C9)));
		Encrypter.scroll.getVerticalScrollBar().setPreferredSize(
				new Dimension(0, 0));
		Encrypter.scroll.setRowHeaderView(Encrypter.TAlines);
		Encrypter.scroll.setBorder(BorderFactory.createLineBorder(new Color(
				0xC9C9C9), 2));

		Encrypter.chooser.addChoosableFileFilter(new FileNameExtensionFilter(
				"Text", "txt"));
		Encrypter.chooser.addChoosableFileFilter(new FileNameExtensionFilter(
				"HTM", "htm"));
		Encrypter.chooser.addChoosableFileFilter(new FileNameExtensionFilter(
				"XHTML", "xhtml"));
		Encrypter.chooser.addChoosableFileFilter(new FileNameExtensionFilter(
				"HTML", "html"));
		Encrypter.chooser.setAcceptAllFileFilterUsed(false);

		Encrypter.TF1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Encrypter.color_dark));
		Encrypter.TF1.setToolTipText("<html>&#8226; Enter the URL / URI"
				+ "<br />&#8226; You can use <i><b>ENTER</b></i></html>");
		Encrypter.TF1.setSelectionColor(Encrypter.color_blue);
		Encrypter.TF1.setSelectedTextColor(Encrypter.color_white);
		Encrypter.TF1.setBackground(Encrypter.color_light);

		Encrypter.TF2.setEditable(false);
		Encrypter.TF2.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_light, 9));
		Encrypter.TF2.setBackground(Encrypter.color_light);
		Encrypter.TF2.setForeground(Encrypter.color_black);
		Encrypter.TF2.setFont(Encrypter.font12);
		Encrypter.TF2.setSelectionColor(Encrypter.color_black);
		Encrypter.TF2.setSelectedTextColor(Encrypter.color_white);

		Encrypter.LB1.setForeground(Encrypter.color_blue);
		Encrypter.LB1.setFont(Encrypter.font16);

		Encrypter.LB2.setForeground(Encrypter.color_blue);
		Encrypter.LB2.setFont(Encrypter.font16);

		Encrypter.LB3.setForeground(Encrypter.color_blue);
		Encrypter.LB3.setFont(Encrypter.font16);

		Encrypter.LB4.setForeground(Encrypter.color_white);
		Encrypter.LB4.setFont(new Font("Arial", Font.PLAIN, 10));

		ImageIcon but = getImageIcon("assets/icons/search.png");
		ImageIcon but_r = getImageIcon("assets/icons/search_r.png");
		Encrypter.search.setBackground(Encrypter.color_light);
		Encrypter.search
				.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		Encrypter.search.setForeground(Encrypter.color_white);
		Encrypter.search.setFont(Encrypter.font16);
		Encrypter.search.setToolTipText("Search URL / URI");
		Encrypter.search.setIcon(but);
		Encrypter.search.setPressedIcon(but_r);
		Encrypter.search.setRolloverIcon(but_r);
		Encrypter.search.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.search.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		Encrypter.combo.setBackground(Encrypter.color_light);
		Encrypter.combo.setForeground(Encrypter.color_black);
		Encrypter.combo.setUI(new BasicComboBoxUI());
		Encrypter.combo.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_black, 1));
		Encrypter.combo
				.setToolTipText("Choose the method of encryption / decryption");

		ImageIcon normal = getImageIcon("assets/icons/checkbox_normal.png");
		ImageIcon checked = getImageIcon("assets/icons/checkbox_checked.png");
		Encrypter.no_click.setIcon(normal);
		Encrypter.no_click.setSelectedIcon(checked);
		Encrypter.no_click.setBackground(Encrypter.color_light);
		Encrypter.no_click.setForeground(Encrypter.color_blue);
		Encrypter.no_click.setFont(Encrypter.font16);

		ImageIcon crypt = getImageIcon("assets/icons/crypt.png");
		ImageIcon crypt_r = getImageIcon("assets/icons/crypt_r.png");
		Encrypter.crypt.setBackground(Encrypter.color_light);
		Encrypter.crypt.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.crypt.setForeground(Encrypter.color_black);
		Encrypter.crypt.setFont(Encrypter.font16);
		Encrypter.crypt.setToolTipText("Encrypt the source code");
		Encrypter.crypt.setIcon(crypt);
		Encrypter.crypt.setPressedIcon(crypt_r);
		Encrypter.crypt.setRolloverIcon(crypt_r);
		Encrypter.crypt.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon decrypt = getImageIcon("assets/icons/decrypt.png");
		ImageIcon decrypt_r = getImageIcon("assets/icons/decrypt_r.png");
		Encrypter.decrypt.setBackground(Encrypter.color_light);
		Encrypter.decrypt.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.decrypt.setForeground(Encrypter.color_black);
		Encrypter.decrypt.setFont(Encrypter.font16);
		Encrypter.decrypt.setToolTipText("Decrypt the source code");
		Encrypter.decrypt.setIcon(decrypt);
		Encrypter.decrypt.setPressedIcon(decrypt_r);
		Encrypter.decrypt.setRolloverIcon(decrypt_r);
		Encrypter.decrypt.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon exit = getImageIcon("assets/icons/exit_light.png");
		Encrypter.exit.setBackground(Encrypter.color_dark);
		Encrypter.exit.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_dark, 0));
		Encrypter.exit.setIcon(exit);
		Encrypter.exit.setToolTipText("Exit");

		ImageIcon minimize = getImageIcon("assets/icons/minimize_light.png");
		Encrypter.minim.setBackground(Encrypter.color_dark);
		Encrypter.minim.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_dark, 0));
		Encrypter.minim.setIcon(minimize);
		Encrypter.minim.setToolTipText("Minimize");

		ImageIcon maximize = getImageIcon("assets/icons/maximize_light.png");
		Encrypter.maxim.setBackground(Encrypter.color_dark);
		Encrypter.maxim.setBorder(BorderFactory.createLineBorder(
				Encrypter.color_dark, 0));
		Encrypter.maxim.setIcon(maximize);
		Encrypter.maxim.setToolTipText("Maximize");

		ImageIcon new_doc = getImageIcon("assets/icons/new.png");
		ImageIcon new_doc_r = getImageIcon("assets/icons/new_r.png");
		Encrypter.new_doc.setBackground(Encrypter.color_light);
		Encrypter.new_doc.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.new_doc.setIcon(new_doc);
		Encrypter.new_doc.setPressedIcon(new_doc_r);
		Encrypter.new_doc.setRolloverIcon(new_doc_r);
		Encrypter.new_doc.setToolTipText("New Search");
		Encrypter.new_doc.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.new_doc.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon open = getImageIcon("assets/icons/open.png");
		ImageIcon open_r = getImageIcon("assets/icons/open_r.png");
		Encrypter.open.setBackground(Encrypter.color_light);
		Encrypter.open.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.open.setIcon(open);
		Encrypter.open.setPressedIcon(open_r);
		Encrypter.open.setRolloverIcon(open_r);
		Encrypter.open.setToolTipText("Open File");
		Encrypter.open.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.open
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon copy = getImageIcon("assets/icons/copy.png");
		ImageIcon copy_r = getImageIcon("assets/icons/copy_r.png");
		Encrypter.copy.setBackground(Encrypter.color_light);
		Encrypter.copy.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.copy.setIcon(copy);
		Encrypter.copy.setPressedIcon(copy_r);
		Encrypter.copy.setRolloverIcon(copy_r);
		Encrypter.copy.setToolTipText("Copy");
		Encrypter.copy.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.copy
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon paste = getImageIcon("assets/icons/paste.png");
		ImageIcon paste_r = getImageIcon("assets/icons/paste_r.png");
		Encrypter.paste.setBackground(Encrypter.color_light);
		Encrypter.paste.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.paste.setIcon(paste);
		Encrypter.paste.setPressedIcon(paste_r);
		Encrypter.paste.setRolloverIcon(paste_r);
		Encrypter.paste.setToolTipText("Paste");
		Encrypter.paste.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.paste.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon save = getImageIcon("assets/icons/save.png");
		ImageIcon save_r = getImageIcon("assets/icons/save_r.png");
		Encrypter.save.setBackground(Encrypter.color_light);
		Encrypter.save.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.save.setIcon(save);
		Encrypter.save.setPressedIcon(save_r);
		Encrypter.save.setRolloverIcon(save_r);
		Encrypter.save.setToolTipText("Save");
		Encrypter.save.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.save
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon no_blank = getImageIcon("assets/icons/no_blank.png");
		ImageIcon no_blank_r = getImageIcon("assets/icons/no_blank_r.png");
		Encrypter.no_blank.setBackground(Encrypter.color_light);
		Encrypter.no_blank.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.no_blank.setIcon(no_blank);
		Encrypter.no_blank.setPressedIcon(no_blank_r);
		Encrypter.no_blank.setRolloverIcon(no_blank_r);
		Encrypter.no_blank.setToolTipText("Remove _blank");
		Encrypter.no_blank.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.no_blank.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		ImageIcon upload = getImageIcon("assets/icons/upload.png");
		ImageIcon upload_r = getImageIcon("assets/icons/upload_r.png");
		Encrypter.upload.setBackground(Encrypter.color_light);
		Encrypter.upload.setBorder(BorderFactory.createEmptyBorder());
		Encrypter.upload.setIcon(upload);
		Encrypter.upload.setPressedIcon(upload_r);
		Encrypter.upload.setRolloverIcon(upload_r);
		Encrypter.upload.setToolTipText("FTP Transfer");
		Encrypter.upload.setHorizontalTextPosition(AbstractButton.LEFT);
		Encrypter.upload.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

	}
}
