package Proiect.js;

import java.io.*;
import javax.script.*;
import Proiect.Crawler;

public class jsEscape{
	
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
	
	// JavaScript Escape Function
	public static void jsEscapeText(String text) throws FileNotFoundException {
		String html_top = "<html><head><script type=text/javascript>var jsESC='";
		String html_bottom = "';document.write(unescape(jsESC))</script></head></html>";
		
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("javascript");
	    
	    try {
	    	if(Crawler.no_click.isSelected()){
				String test = Crawler.TA.getText();
				Crawler.TA.insert(no_click, test.indexOf("</head>"));
			}
	    	
	      engine.put ("text", Crawler.TA.getText());
	      engine.eval("var output = escape(text)");
	      
	      String text_out = (String) engine.get("output");
	      
	      Crawler.TA.setText("");
	      Crawler.TA.append(html_top + text_out + html_bottom);
	      
	    } catch (ScriptException e) {
	      System.err.println(e);
	    }
	}
	
	// JavaScript Unescape Function
	public static void jsUnescapeText(String text) throws FileNotFoundException{
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("javascript");
	    
	    try {
	      engine.put ("text", Crawler.TA.getText());
	      engine.eval("var output = unescape(text)");
	      
	      String text_out = (String) engine.get("output");
	      
	      Crawler.TA.setText("");
	      Crawler.TA.append(text_out.substring(53,text_out.lastIndexOf("</html>")-50));
	      
	    } catch (ScriptException e) {
	      System.err.println(e);
	    }
	}
}
