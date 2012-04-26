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

import javax.swing.*;

/**
 * This class changes the Look and Feel of certain components
 * 
 * @author Stefan Cosma
 * 
 */
public class uiManager {

	public uiManager() {

		if (Encrypter.isMacOS) {
			try {
				UIManager
						.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		}
		UIManager.put("MenuBar.background", Encrypter.color_dark);
		UIManager.put("MenuBar.borderColor", Encrypter.color_dark);
		UIManager.put("Menu.background", Encrypter.color_dark);
		UIManager.put("Menu.selectionBackground", Encrypter.color_white);
		UIManager.put("Menu.selectionForeground", Encrypter.color_black);
		UIManager.put("MenuItem.selectionBackground", Encrypter.color_blue);
		UIManager.put("MenuItem.border",
				BorderFactory.createLineBorder(Encrypter.color_white, 2));
		UIManager.put("MenuItem.acceleratorForeground", Encrypter.color_black);

		UIManager.put("PopupMenu.background", Encrypter.color_white);
		UIManager.put("PopupMenu.selectionBackground", Encrypter.color_blue);
		UIManager.put("PopupMenu.selectionForeground", Encrypter.color_black);

		UIManager.put("Button.select", Encrypter.color_light);
		UIManager.put("Button.focus", Encrypter.color_light);
		UIManager.put("Separator.background", Encrypter.color_light);
		UIManager.put("Separator.foreground", Encrypter.color_light);
		UIManager.put("Separator.highlight", Encrypter.color_light);
		UIManager.put("Separator.shadow", Encrypter.color_light);

		UIManager.put("ToolTip.background", Encrypter.color_blue);
		UIManager.put("ToolTip.foreground", Encrypter.color_white);
		UIManager.put("ToolTip.font", Encrypter.font16);
		UIManager.put("ToolTip.border",
				BorderFactory.createLineBorder(Encrypter.color_black, 0));

		UIManager.put("ComboBox.selectionBackground", Encrypter.color_blue);
		UIManager.put("ComboBox.selectionForeground", Encrypter.color_black);
		UIManager.put("ComboBox.buttonBackground", Encrypter.color_light);
		UIManager.put("ComboBox.buttonDarkShadow", Encrypter.color_black);
		UIManager.put("ComboBox.buttonHighlight", Encrypter.color_light);
		UIManager.put("ComboBox.buttonShadow", Encrypter.color_light);

		UIManager.put("CheckBox.focus", Encrypter.color_light);
		UIManager.put("CheckBox.select", Encrypter.color_light);
		UIManager.put("CheckBox.border",
				BorderFactory.createLineBorder(Encrypter.color_light, 1));

		UIManager.put("ToggleButton.background", Encrypter.color_white);
		UIManager.put("ToggleButton.select", Encrypter.color_white);
		UIManager.put("ToggleButton.shadow", Encrypter.color_white);
		UIManager.put("ToggleButton.focus", Encrypter.color_white);
		UIManager.put("ToggleButton.darkShadow", Encrypter.color_white);

		UIManager.put("ScrollPane.background", Encrypter.color_light);
		UIManager.put("ScrollPane.border", Encrypter.color_light);
		UIManager.put("ScrollBar.background", Encrypter.color_light);
		UIManager.put("ScrollBar.foreground", Encrypter.color_light);
		UIManager.put("ScrollBar.thumbHighlight", Encrypter.color_light);
		UIManager.put("ScrollBar.thumbShadow", Encrypter.color_light);
		UIManager.put("ScrollBar.thumbDarkShadow", Encrypter.color_light);
		UIManager.put("ScrollBar.thumbLightShadow ", Encrypter.color_light);
		UIManager.put("ScrollBar.track", Encrypter.color_light);
		UIManager.put("ScrollBar.trackHighlight", Encrypter.color_light);
		UIManager.put("ScrollBar.shadow", Encrypter.color_light);
		UIManager.put("ScrollBar.darkShadow", Encrypter.color_light);
		UIManager.put("ScrollBar.highlight", Encrypter.color_light);

		UIManager.put("control", Encrypter.color_white);
		UIManager.put("controlDkShadow", Encrypter.color_white);
		UIManager.put("controlHighlight", Encrypter.color_white);
		UIManager.put("controlLtHighlight", Encrypter.color_white);
		UIManager.put("controlShadow", Encrypter.color_white);
		UIManager.put("controlText", Encrypter.color_white);

		UIManager.put("OptionPane.background", Encrypter.color_white);
		UIManager.put("OptionPane.okButtonText", "Search");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");

	}
}
