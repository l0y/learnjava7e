package ch10.examples;

import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServer {
  // 3283 == D-A-T-E on a phonepad :)
  static int port = 3283;

  // seconds from start of 20th century to Jan 1, 1970 00:00 GMT
  static final long offset = 2208988800L;

  public static void serveDateAndTime() {
    for (;;) { // this is sometimes called the "forever" loop
      System.out.println("Waiting ...");
      try (ServerSocket listener = new ServerSocket(port)) {
        Socket client = listener.accept();
        System.out.println("Incoming request from " + client.getInetAddress());
        long millis = System.currentTimeMillis();
        long seconds1970 = millis / 1000;
        int seconds1900 = (int)(seconds1970 + offset);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
	dos.writeInt(seconds1900);
        dos.close();
      } catch(Exception e) {
        // We're being a bit lazy here, but this server is so
        // simple, there's not much else to do.
        System.err.println("Oh no! Server error: " + e);
        break;
      }
    }
  }

  public static void main(String args[]) {
    System.out.println("Starting up. Press Ctrl-C to quit.");
    serveDateAndTime();
  }
}
