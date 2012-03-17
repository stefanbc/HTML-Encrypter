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

package Proiect;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class BrowserLaunch {

   static final String[] browsers = { "google-chrome", "firefox", "opera",
      "epiphany", "konqueror", "conkeror", "midori", "kazehakase", "mozilla" };
   static final String errMsg = "Error on trying to open the default browser!";

   /**
    * Opens the specified web page in the user's default browser
    * @param url A web address (URL) of a web page (ex: "http://www.google.com/")
    */
   public static void openURL(String url) {
      try {  //attempt to use Desktop library from JDK 1.6+
         Class<?> d = Class.forName("java.awt.Desktop");
         d.getDeclaredMethod("browse", new Class[] {java.net.URI.class}).invoke(
            d.getDeclaredMethod("getDesktop").invoke(null),
            new Object[] {java.net.URI.create(url)});
         //above code mimicks:  java.awt.Desktop.getDesktop().browse()
         }
      catch (Exception ignore) {  //library not available or failed
         String osName = System.getProperty("os.name");
         try {
            if (osName.startsWith("Mac OS")) {
               Class.forName("com.apple.eio.FileManager").getDeclaredMethod(
                  "openURL", new Class[] {String.class}).invoke(null,
                  new Object[] {url});
               }
            else if (osName.startsWith("Windows"))
               Runtime.getRuntime().exec(
                  "rundll32 url.dll,FileProtocolHandler " + url);
            else { //assume Unix or Linux
               String browser = null;
               for (String b : browsers)
                  if (browser == null && Runtime.getRuntime().exec(new String[]
                        {"which", b}).getInputStream().read() != -1)
                     Runtime.getRuntime().exec(new String[] {browser = b, url});
               if (browser == null)
                  throw new Exception(Arrays.toString(browsers));
               }
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, errMsg + "\n" + e.toString());
            }
         }
      }

   }
