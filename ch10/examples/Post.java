package ch10.examples;

import java.net.*;
import java.io.*;

/**
 * A small command-line utility that demonstrates use of the
 * HTTP POST mechanism. Provide a POST-able URL, name and password
 * when prompted. The data is then sent to the Postman echo
 * service.  to the command line
 *
 * https://learning.postman.com/docs/reference/developer-resources/echo-api
 */
public class Post {
  String name;
  String password;

  String postURL = "https://postman-echo.com/post";

  protected void getUserInput() {
    Console cons;
    char[] raw;
    if ((cons = System.console()) != null) {
      name = cons.readLine("Username: ");
      raw = cons.readPassword("Password: ");
      if (name == null || raw == null) {
        System.err.println("Did not get valid input!");
      } else {
        password = new String(raw);
      }
    } else {
      System.err.println("Could not connect to a console.");
    }
  }

  protected boolean hasValidInput() {
    // Small convenience check to make our main() logic simpler
    return name != null && password != null;
  }

  protected void postData() {
    StringBuilder sb = new StringBuilder();
    try {
      sb.append( URLEncoder.encode("Name", "UTF-8") + "=" );
      sb.append( URLEncoder.encode(name, "UTF-8") );
      sb.append( "&" + URLEncoder.encode("Password", "UTF-8") + "=" );
      sb.append( URLEncoder.encode(password, "UTF-8") );
    } catch (UnsupportedEncodingException uee) {
      System.out.println(uee);
    }
    String formData = sb.toString();

    try {
      URL url = new URI(postURL).toURL();
      HttpURLConnection urlcon =
          (HttpURLConnection) url.openConnection(  );
      urlcon.setRequestMethod("POST");
      urlcon.setRequestProperty("Content-type",
          "application/x-www-form-urlencoded");
      urlcon.setDoOutput(true);
      urlcon.setDoInput(true);
      PrintWriter pout = new PrintWriter( new OutputStreamWriter(
          urlcon.getOutputStream(  ), "8859_1"), true );
      pout.print( formData );
      pout.flush(  );

      // Did the post succeed?
      if ( urlcon.getResponseCode() == HttpURLConnection.HTTP_OK )
        System.out.println("Posted ok!");
      else {
        System.out.println("Bad post...");
        return;
      }
      // Hooray! Go ahead and read the results
      InputStream is = urlcon.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      br.close();
    } catch (URISyntaxException e) {
      System.out.println(e);     // bad postURL
    } catch (IOException e2) {
      System.out.println(e2);    // I/O error
    }
  }

  public static void main( String [] args ) {
    Post p = new Post();
    p.getUserInput();
    if (p.hasValidInput()) {
      p.postData();
    } else {
      System.err.println("Didn't have valid data to post.");
    }
  }
}
