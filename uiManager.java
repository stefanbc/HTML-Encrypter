package Proiect;

import java.awt.*;
import javax.swing.*;

public class uiManager {

	public uiManager(){
		// Culori generale
		UIManager.put( "Menu.selectionBackground", Color.WHITE);			//menu selection color
		UIManager.put( "Menu.selectionForeground", Color.BLACK);			//menu selection color
		UIManager.put( "MenuItem.selectionBackground", Color.LIGHT_GRAY);	//item meniu
		UIManager.put( "MenuItem.border",BorderFactory.createLineBorder(Color.WHITE, 2));
		UIManager.put( "MenuItem.acceleratorForeground", Color.BLACK);		//culoare menu accelerator
		
		UIManager.put( "PopupMenu.background", Color.WHITE);				//culoare popup menu
		UIManager.put( "PopupMenu.selectionBackground", Color.LIGHT_GRAY);
		UIManager.put( "PopupMenu.selectionForeground", Color.WHITE);
				
		UIManager.put( "Button.select", Color.WHITE);						//culoare buton onClick
		UIManager.put( "Button.focus", Color.WHITE);						//culoare buton focus [blue line]
		UIManager.put( "Separator.background", Color.BLACK);
		UIManager.put( "Separator.foreground", Color.BLACK);
		UIManager.put( "Separator.highlight", Color.BLACK);
		UIManager.put( "Separator.shadow", Color.BLACK);
				
		UIManager.put( "ToolTip.background", Color.WHITE);					//pentru tooltip
		UIManager.put( "ToolTip.foreground", Color.BLACK);					//culoare scris tooltip
		UIManager.put( "ToolTip.border", BorderFactory.createLineBorder(Color.BLACK, 2));	//border tooltip
				
		UIManager.put( "ComboBox.selectionBackground", Color.LIGHT_GRAY);	//highlight combobox
		UIManager.put( "ComboBox.selectionForeground", Color.BLACK);
		UIManager.put( "ComboBox.buttonBackground", Color.WHITE);
		UIManager.put( "ComboBox.buttonDarkShadow", Color.BLACK);
		UIManager.put( "ComboBox.buttonHighlight", Color.WHITE);
		UIManager.put( "ComboBox.buttonShadow", Color.WHITE);		
		
		UIManager.put( "CheckBoxMenuItem.acceleratorForeground", Color.BLACK);
		UIManager.put( "CheckBoxMenuItem.acceleratorSelectionForeground", Color.BLACK);
		UIManager.put( "CheckBoxMenuItem.background", Color.WHITE);
		UIManager.put( "CheckBoxMenuItem.border",BorderFactory.createLineBorder(Color.WHITE, 2));
		UIManager.put( "CheckBoxMenuItem.disabledBackground", Color.WHITE);
		UIManager.put( "CheckBoxMenuItem.disabledForeground", Color.WHITE);
		UIManager.put( "CheckBoxMenuItem.foreground", Color.BLACK);
		UIManager.put( "CheckBoxMenuItem.selectionBackground", Color.LIGHT_GRAY);
		UIManager.put( "CheckBoxMenuItem.selectionForeground", Color.BLACK);
				
		UIManager.put( "ScrollPane.background", Color.WHITE);
		UIManager.put( "ScrollPane.border", Color.WHITE);
		UIManager.put( "ScrollBar.background", Color.WHITE);				
		UIManager.put( "ScrollBar.foreground", Color.WHITE);
		UIManager.put( "ScrollBar.thumb", Color.BLACK);						// nu merge momentan		
		UIManager.put( "ScrollBar.thumbHighlight", Color.WHITE);	
		UIManager.put( "ScrollBar.thumbShadow", Color.WHITE);
		UIManager.put( "ScrollBar.thumbDarkShadow",Color.WHITE);
		UIManager.put( "ScrollBar.thumbLightShadow ", Color.WHITE);
		UIManager.put( "ScrollBar.track",Color.WHITE);
		UIManager.put( "ScrollBar.trackHighlight", Color.WHITE);
		UIManager.put( "ScrollBar.shadow", Color.WHITE);
		UIManager.put( "ScrollBar.darkShadow", Color.WHITE);
		UIManager.put( "ScrollBar.highlight", Color.WHITE);	
		
		UIManager.put( "control", Color.WHITE);
		UIManager.put( "controlDkShadow",Color.WHITE);
		UIManager.put( "controlHighlight", Color.WHITE);
		UIManager.put( "controlLtHighlight", Color.WHITE);
		UIManager.put( "controlShadow", Color.WHITE);
		UIManager.put( "controlText", Color.WHITE);
		
		UIManager.put( "OptionPane.background", Color.WHITE);
		UIManager.put( "OptionPane.okButtonText", "Cautare");
		UIManager.put( "OptionPane.cancelButtonText", "Renunta");
	}
}
