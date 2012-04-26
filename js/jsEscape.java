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

package Proiect.js;

import java.io.*;
import javax.script.*;
import Proiect.Encrypter;

public class jsEscape{
	
	public static String html_top = "<html><head><script type=text/javascript>var jsESC='";
	static String html_bottom = "';document.write(unescape(jsESC))</script></head></html>";
	
	// JavaScript Escape Function
	public static void jsEscapeText(String text) throws FileNotFoundException {		
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("javascript");
	    
	    try {
	    	if(Encrypter.no_click.isSelected()){
				String test = Encrypter.TA.getText();
				Encrypter.TA.insert(Encrypter.no_click_script, test.indexOf("</head>"));
			}
	    	
	      engine.put ("text", Encrypter.TA.getText());
	      engine.eval("var output = escape(text)");
	      
	      String text_out = (String) engine.get("output");
	      
	      Encrypter.TA.setText("");
	      Encrypter.TA.append(html_top + text_out + html_bottom);
	      
	    } catch (ScriptException e) {
	      System.err.println(e);
	    }
	}
	
	// JavaScript Unescape Function
	public static void jsUnescapeText(String text) throws FileNotFoundException{
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("javascript");
	    
	    try {
	      engine.put ("text", Encrypter.TA.getText());
	      engine.eval("var output = unescape(text)");
	      
	      String text_out = (String) engine.get("output");
	      
	      Encrypter.TA.setText("");
	      Encrypter.TA.append(text_out.substring(53,text_out.lastIndexOf("</html>")-50));
	      
	    } catch (ScriptException e) {
	      System.err.println(e);
	    }
	}
}
