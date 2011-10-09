package Proiect;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {

	private static final long serialVersionUID = 1L;

	private int duration;

	Image bi = Toolkit.getDefaultToolkit().getImage("resources/logo_main.png");
	ImageIcon ii = new ImageIcon(bi);

	public SplashScreen(int d) {
		duration = d;
	}

	public void showSplash() {

		int width = 254;
		int height = 276;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		setBackground(new Color(255, 255, 255, 0));
		setVisible(true);

		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}

		setVisible(false);

	}

	public void showSplashAndExit() {
		showSplash();
		dispose();

	}

	public void paint(Graphics g) {
		g.drawImage(bi, 0, 0, this);
	}
}