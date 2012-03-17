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
 *  Proprietati elemente generale
 */

package Proiect;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.*;

public class setProp{
	Color color = Color.WHITE;//new Color(0x00BFFF)
	
	public setProp() {	
		Crawler.Crw.setBackground(color); 
		Crawler.West.setBackground(color);
		Crawler.East.setBackground(color);
		Crawler.South.setBackground(color);
			Crawler.main_North.setBackground(color);
			Crawler.main_South.setBackground(color);
			Crawler.main_West.setBackground(color);
			Crawler.main_East.setBackground(color);
				Crawler.pan1.setBackground(color);
				Crawler.pan2.setBackground(color);
				Crawler.pan3.setBackground(color);
				Crawler.pan4.setBackground(color);
				Crawler.pan5.setBackground(color);
					Crawler.in_pan11.setBackground(color);
					Crawler.in_pan21.setBackground(color);
						Crawler.in_pan211.setBackground(color);
					Crawler.in_pan22.setBackground(color);
					Crawler.in_pan41.setBackground(color);
					Crawler.in_pan42.setBackground(color);
					Crawler.in_pan51.setBackground(color);
		Crawler.ad_pan1.setBackground(color);
			Crawler.ad_pan11.setBackground(color);
		Crawler.in_pan21.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
		Crawler.in_pan41.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
					
		//textarea,scrollpane,filechooser - proprietati
		Crawler.TA.setEditable(false);
		Crawler.TA.setBackground(Color.WHITE);
		Crawler.TA.setForeground(Color.BLACK);
		Crawler.TA.setSelectionColor(Color.BLACK);						//culoare selectie
		Crawler.TA.setSelectedTextColor(Color.WHITE);					//culoare text selectat
		Crawler.TA.setLineWrap(true);									//wordwrap
		Crawler.TA.setWrapStyleWord(true);
		Crawler.TA.setBorder(BorderFactory.createMatteBorder(0, 6, 0, 0, Color.WHITE));
		DefaultCaret caret = (DefaultCaret)Crawler.TA.getCaret();		//fara autoscroll
	    caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);				//la textarea
	    
	    Crawler.TAlines.setEditable(false);
	    Crawler.TAlines.setBackground(Color.WHITE);
	    Crawler.TAlines.setForeground(Color.BLACK);
	    Crawler.TAlines.setSelectionColor(Color.WHITE);					
	    Crawler.TAlines.setSelectedTextColor(Color.BLACK);
	    Crawler.TAlines.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 7, Color.WHITE));
	    Crawler.TAlines.setColumns(2);
	    
	    Crawler.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    Crawler.scroll.setViewportBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
	    Crawler.scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));			//fara scroll
	    Crawler.scroll.setRowHeaderView(Crawler.TAlines);									//adaugare numar linii textarea
	    Crawler.scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    
	    Crawler.chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text", "txt"));
	    Crawler.chooser.addChoosableFileFilter(new FileNameExtensionFilter("HTM", "htm"));
	    Crawler.chooser.addChoosableFileFilter(new FileNameExtensionFilter("XHTML", "xhtml"));
	    Crawler.chooser.addChoosableFileFilter(new FileNameExtensionFilter("HTML", "html"));
	    Crawler.chooser.setAcceptAllFileFilterUsed(false);
		
		//progressbar - proprieties
	    Crawler.progbar.setBackground(Color.WHITE);
	    Crawler.progbar.setForeground(Color.BLACK);
	    Crawler.progbar.setBorderPainted(false);
	    Crawler.progbar.setMinimum(0);
	    Crawler.progbar.setMaximum(100);
//	    Crawler.progbar.setStringPainted(true); //pentru afisare procentaj
		
		// textfield URL proprietati
	    Crawler.TF1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    Crawler.TF1.setToolTipText("<html>&#8226; Here enter the desired URL / URI" +
	    							"<br />&#8226; You can use <i><b>ENTER</b></i></html>");
	    Crawler.TF1.setSelectionColor(Color.BLACK);
	    Crawler.TF1.setSelectedTextColor(Color.WHITE);
	    
		// textfield rezultate proprietati
	    Crawler.TF2.setEditable(false);
	    Crawler.TF2.setBorder(BorderFactory.createLineBorder(color, 9));
	    Crawler.TF2.setBackground(color);
	    Crawler.TF2.setForeground(Color.BLACK);
	    Crawler.TF2.setFont(Crawler.font12);
	    Crawler.TF2.setSelectionColor(Color.BLACK);
	    Crawler.TF2.setSelectedTextColor(Color.WHITE);

		// Label 1 properties
	    Crawler.LB1.setForeground(Color.BLACK);
	    Crawler.LB1.setFont(Crawler.font16);

		// Label 2 properties
	    Crawler.LB2.setForeground(Color.BLACK);
	    Crawler.LB2.setFont(Crawler.font16);
		
		// Label 3 - proprieties
	    Crawler.LB3.setForeground(Color.BLACK);
	    Crawler.LB3.setFont(Crawler.font16);
		
		// Label 4 - proprieties
	    Crawler.LB4.setForeground(Color.BLACK);
	    Crawler.LB4.setFont(new Font("Arial",Font.PLAIN,10));
		
		// buton cautare - properties
	    Crawler.but.setBackground(color);
	    Crawler.but.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));			//top,left,bottom,right
	    Crawler.but.setForeground(Color.BLACK);
	    Crawler.but.setFont(Crawler.font16);
	    Crawler.but.setToolTipText("<html><center>Search URL / URI<br><i>www</i> is optional.</center></html>");
	    Crawler.but.setIcon(new ImageIcon("resources/icons/search.png"));
	    Crawler.but.setHorizontalTextPosition(AbstractButton.LEFT);					//orientare text pe buton 
		Crawler.but.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		//schimbare cursor
		
		//combobox metode - properties
	    Crawler.combo.setBackground(Color.WHITE);
	    Crawler.combo.setForeground(Color.BLACK);
	    Crawler.combo.setUI(new BasicComboBoxUI());
	    Crawler.combo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    Crawler.combo.setToolTipText("Choose the method of encryption / decryption");
	    
	    Crawler.no_click.setBackground(color);
	    Crawler.no_click.setForeground(Color.BLACK);
	    		
		//buton criptare - proprieties
	    Crawler.crypt.setBackground(color);
	    Crawler.crypt.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.crypt.setForeground(Color.BLACK);
	    Crawler.crypt.setFont(Crawler.font16);
	    Crawler.crypt.setToolTipText("<html>Encrypt the source code using algorithms" +
	    							 "<br>made available by the encryption tool!</html>");
	    Crawler.crypt.setIcon(new ImageIcon("resources/icons/crypt.png"));
	    Crawler.crypt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//buton decriptare - proprieties
	    Crawler.decrypt.setBackground(color);
	    Crawler.decrypt.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.decrypt.setForeground(Color.BLACK);
	    Crawler.decrypt.setFont(Crawler.font16);
	    Crawler.decrypt.setToolTipText("Decrypt source code");
	    Crawler.decrypt.setIcon(new ImageIcon("resources/icons/decrypt.png"));
	    Crawler.decrypt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//buton exit - proprieties
	    Crawler.exit.setBackground(Color.WHITE);
	    Crawler.exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    Crawler.exit.setForeground(Color.BLACK);
	    Crawler.exit.setFont(Crawler.font16);
	    Crawler.exit.setToolTipText("Exit");
		
		//buton minimizare - proprieties
	    Crawler.minim.setBackground(Color.WHITE);
	    Crawler.minim.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    Crawler.minim.setForeground(Color.BLACK);
	    Crawler.minim.setFont(Crawler.font16);
	    Crawler.minim.setToolTipText("Minimize");
	    
	    //buton maximizare - proprieties
	    Crawler.maxim.setBackground(Color.WHITE);
	    Crawler.maxim.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    Crawler.maxim.setForeground(Color.BLACK);
	    Crawler.maxim.setFont(Crawler.font16);
	    Crawler.maxim.setToolTipText("Maximize");
	    
	    //butoane sidebar
	    Crawler.new_doc.setBackground(color);
	    Crawler.new_doc.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.new_doc.setIcon(new ImageIcon("resources/icons/sidebar/new.png"));
	    Crawler.new_doc.setPressedIcon(new ImageIcon("resources/icons/sidebar/new_r.png"));
	    Crawler.new_doc.setRolloverIcon(new ImageIcon("resources/icons/sidebar/new_r.png"));
	    Crawler.new_doc.setToolTipText("New Search");
	    Crawler.new_doc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    Crawler.open.setBackground(color);
	    Crawler.open.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.open.setIcon(new ImageIcon("resources/icons/sidebar/open.png"));
	    Crawler.open.setPressedIcon(new ImageIcon("resources/icons/sidebar/open_r.png"));
	    Crawler.open.setRolloverIcon(new ImageIcon("resources/icons/sidebar/open_r.png"));
	    Crawler.open.setToolTipText("Open File");
	    Crawler.open.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    Crawler.copy.setBackground(color);
	    Crawler.copy.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.copy.setIcon(new ImageIcon("resources/icons/sidebar/copy.png"));
	    Crawler.copy.setPressedIcon(new ImageIcon("resources/icons/sidebar/copy_r.png"));
	    Crawler.copy.setRolloverIcon(new ImageIcon("resources/icons/sidebar/copy_r.png"));
	    Crawler.copy.setToolTipText("Copy");
	    Crawler.copy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    Crawler.paste.setBackground(color);
	    Crawler.paste.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.paste.setIcon(new ImageIcon("resources/icons/sidebar/paste.png"));
	    Crawler.paste.setPressedIcon(new ImageIcon("resources/icons/sidebar/paste_r.png"));
	    Crawler.paste.setRolloverIcon(new ImageIcon("resources/icons/sidebar/paste_r.png"));
	    Crawler.paste.setToolTipText("Paste");
	    Crawler.paste.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    Crawler.save.setBackground(color);
	    Crawler.save.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.save.setIcon(new ImageIcon("resources/icons/sidebar/save.png"));
	    Crawler.save.setPressedIcon(new ImageIcon("resources/icons/sidebar/save_r.png"));
	    Crawler.save.setRolloverIcon(new ImageIcon("resources/icons/sidebar/save_r.png"));
	    Crawler.save.setToolTipText("Save");
	    Crawler.save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    Crawler.no_blank.setBackground(color);
	    Crawler.no_blank.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.no_blank.setIcon(new ImageIcon("resources/icons/sidebar/no_blank.png"));
	    Crawler.no_blank.setPressedIcon(new ImageIcon("resources/icons/sidebar/no_blank_r.png"));
	    Crawler.no_blank.setRolloverIcon(new ImageIcon("resources/icons/sidebar/no_blank_r.png"));
	    Crawler.no_blank.setToolTipText("Remove _blank");
	    Crawler.no_blank.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    Crawler.upload.setBackground(color);
	    Crawler.upload.setBorder(BorderFactory.createEmptyBorder());
	    Crawler.upload.setIcon(new ImageIcon("resources/icons/sidebar/upload.png"));
	    Crawler.upload.setPressedIcon(new ImageIcon("resources/icons/sidebar/upload_r.png"));
	    Crawler.upload.setRolloverIcon(new ImageIcon("resources/icons/sidebar/upload_r.png"));
	    Crawler.upload.setToolTipText("FTP Transfer");
	    Crawler.upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	}
}
