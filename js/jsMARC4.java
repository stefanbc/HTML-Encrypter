package Proiect.js;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import Proiect.Crawler;

public class jsMARC4 {

	static String no_click = "<script language=JavaScript>"
			+ "var message='Deactivated function!';"
			+ "function clickIE4(){"
			+ "if (event.button==2){"
			+ "alert(message);"
			+ "return false;}}"
			+ "function clickNS4(e){"
			+ "if (document.layers||document.getElementById&&!document.all){"
			+ "if (e.which==2||e.which==3){"
			+ "alert(message);"
			+ "return false;}}}"
			+ "if (document.layers){"
			+ "document.captureEvents(Event.MOUSEDOWN);"
			+ "document.onmousedown=clickNS4;"
			+ "}else if (document.all&&!document.getElementById){"
			+ "document.onmousedown=clickIE4;}"
			+ "document.oncontextmenu=new Function('alert(message);return false')"
			+ "</script>\n";

	static String html_top = "<html><head><script src='http://html-encrypter.googlecode.com/svn/trunk/hea4.js'></script>"
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
				Crawler.TA.insert(no_click, test.indexOf("</head>"));
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
