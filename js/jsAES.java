package Proiect.js;

import java.io.*;
import javax.script.*;
import Proiect.Crawler;

public class jsAES {
	
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
	
	static String html_top = "<html><head><script src='http://html-encrypter.googlecode.com/svn/trunk/hea2.js'></script>"
			+ "<script>var hea2p = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');"
			+ "var hea2t = '";
	static String html_bottom = "';var output = Aes.Ctr.decrypt(hea2t, hea2p, 256);"
			+ "document.write(output)</script></head></html>";

	//Javascript AES Encription
	public static void jsAESEn(String text) throws FileNotFoundException {		
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("js");
	    try {
	      
	    	if(Crawler.no_click.isSelected()){
				String test = Crawler.TA.getText();
				Crawler.TA.insert(no_click, test.indexOf("</head>"));
			}
	    	
	      FileReader reader = new FileReader("js/aes.js");
	      engine.eval(reader);
	      engine.put ("text", Crawler.TA.getText());
		  engine.eval("var password = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');" +
				  	  "var plaintext = text;"+
				  	  "var ciphertext = Aes.Ctr.encrypt(plaintext, password, 256)");
	      
	      String text_out = (String) engine.get("ciphertext");
	      
	      Crawler.TA.setText("");
	      Crawler.TA.append(html_top + text_out + html_bottom);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	//Javascript AES Decription
	public static void jsAESDe(String text) throws FileNotFoundException {		
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("js");
	    try {
	      
	      FileReader reader = new FileReader("js/aes.js");
	      engine.eval(reader);
	      engine.put ("text",Crawler.TA.getText().substring(html_top.length(),Crawler.TA.getText().length()- html_bottom.length()));
		  engine.eval("var password = ('0123456789?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz');" +
				  	  "var plaintext = text;"+
				  	  "var ciphertext = Aes.Ctr.decrypt(plaintext, password, 256)");
	      
	      String text_out = (String) engine.get("ciphertext");
	      
	      Crawler.TA.setText("");
	      Crawler.TA.append(text_out);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
