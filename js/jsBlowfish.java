package Proiect.js;

import java.io.*;
import javax.script.*;
import Proiect.Crawler;

public class jsBlowfish {
	
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
		
	static String html_top = "<html><head><script src='http://html-encrypter.googlecode.com/svn/trunk/hea1.js'></script>"
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
				Crawler.TA.insert(no_click, test.indexOf("</head>"));
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
