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

package Proiect.js;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import Proiect.Crawler;

public class jsMARC4 {

	static String html_top = "<html><head><script src='http://tinyurl.com/6pvtkjg'></script>"
			+ "<script>var hea4p = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
			+ "var hea4t = '";
	static String html_bottom = "';var output = Crypto.MARC4.decrypt(hea4t,hea4p);"
			+ "document.write(output)</script></head></html>";

	/**
	 * Javascript MARC4 Encription
	 * 
	 * @param text
	 * @throws FileNotFoundException
	 */
	public static void jsMARC4En(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {

			if (Crawler.no_click.isSelected()) {
				String test = Crawler.TA.getText();
				Crawler.TA.insert(Crawler.no_click_script, test.indexOf("</head>"));
			}

			FileReader reader = new FileReader("js/marc4.js");
			engine.eval(reader);
			engine.put("text", Crawler.TA.getText());
			engine.eval("var password = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
					+ "var plaintext = text;"
					+ "var crypted = Crypto.MARC4.encrypt(plaintext,password);");

			String text_out = (String) engine.get("crypted");

			Crawler.TA.setText("");
			Crawler.TA.append(html_top + text_out + html_bottom);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Javascript MARC4 Decription
	 * 
	 * @param text
	 * @throws FileNotFoundException
	 */
	public static void jsMARC4De(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {

			FileReader reader = new FileReader("js/marc4.js");
			engine.eval(reader);
			engine.put(
					"text",
					Crawler.TA.getText().substring(
							html_top.length(),
							Crawler.TA.getText().length()
									- html_bottom.length()));
			engine.eval("var password = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
					+ "var plaintext = text;"
					+ "var crypted = Crypto.MARC4.decrypt(plaintext,password);");

			String text_out = (String) engine.get("crypted");

			Crawler.TA.setText("");
			Crawler.TA.append(text_out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
