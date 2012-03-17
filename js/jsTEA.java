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

public class jsTEA {

	static String html_top = "<html><head><script src='http://tinyurl.com/7l3b2dp'></script>"
			+ "<script src='http://tinyurl.com/7yove8t'></script>"
			+ "<script src='http://tinyurl.com/7omcbsa'></script>"
			+ "<script>var hea5p = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
			+ "var hea5t = '";
	static String html_bottom = "';var output = Tea.decrypt(hea5t,hea5p);"
			+ "document.write(output)</script></head></html>";

	// Javascript TEA Encription
	public static void jsTEAEn(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {

			if(Crawler.no_click.isSelected()){
				String test = Crawler.TA.getText();
				Crawler.TA.insert(Crawler.no_click_script, test.indexOf("</head>"));
			}
			
			FileReader reader = new FileReader("js/tea/tea.js");
			FileReader reader1 = new FileReader("js/tea/utf8.js");
			FileReader reader2 = new FileReader("js/tea/base64.js");
			engine.eval(reader);
			engine.eval(reader1);
			engine.eval(reader2);
			engine.put("text", Crawler.TA.getText());
			engine.eval("var password = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
					+ "var plaintext = text;"
					+ "var crypted = Tea.encrypt(plaintext,password);");

			String text_out = (String) engine.get("crypted");

			Crawler.TA.setText("");
			Crawler.TA.append(html_top + text_out + html_bottom);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Javascript TEA Decription
	public static void jsTEADe(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {

			FileReader reader = new FileReader("js/tea/tea.js");
			FileReader reader1 = new FileReader("js/tea/utf8.js");
			FileReader reader2 = new FileReader("js/tea/base64.js");
			engine.eval(reader);
			engine.eval(reader1);
			engine.eval(reader2);
			engine.put(
					"text",
					Crawler.TA.getText().substring(
							html_top.length(),
							Crawler.TA.getText().length()
									- html_bottom.length()));
			engine.eval("var password = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
					+ "var plaintext = text;"
					+ "var crypted = Tea.decrypt(plaintext,password);");

			String text_out = (String) engine.get("crypted");

			Crawler.TA.setText("");
			Crawler.TA.append(text_out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
