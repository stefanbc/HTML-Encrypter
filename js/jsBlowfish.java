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

import java.io.*;
import javax.script.*;
import Proiect.Crawler;

public class jsBlowfish {
	
	static String html_top = "<html><head><script src='http://tinyurl.com/7lebe96'></script>"
			+ "<script>var hea1p = new Blowfish('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
			+ "var hea1t = hea1p.decrypt('";
	static String html_bottom = "');document.write(hea1t)</script></head></html>";
	
	//Javascript Blowfish Encription
	public static void jsBlowfishEn(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			if(Crawler.no_click.isSelected()){
				String test = Crawler.TA.getText();
				Crawler.TA.insert(Crawler.no_click_script, test.indexOf("</head>"));
			}
									
			FileReader reader = new FileReader("js/blowfish.js");
			engine.eval(reader);
			engine.put("text", Crawler.TA.getText());
			engine.eval("var bf = new Blowfish('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
					+ "var ciphertext = bf.encrypt(text);");

			String text_out = (String) engine.get("ciphertext");

			Crawler.TA.setText("");
			Crawler.TA.append(html_top + text_out + html_bottom);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Javascript Blowfish Decription
	public static void jsBlowfishDe(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {			
			FileReader reader = new FileReader("js/blowfish.js");
			engine.eval(reader);
			engine.put("text",Crawler.TA.getText().substring(html_top.length(),Crawler.TA.getText().length()- html_bottom.length()));
			engine.eval("var bf = new Blowfish('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
					+ "var ciphertext = bf.decrypt(text);");

			String text_out = (String) engine.get("ciphertext");
									
			Crawler.TA.setText("");
			Crawler.TA.append(text_out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
