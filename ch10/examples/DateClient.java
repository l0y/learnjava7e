package ch10.examples;

import java.io.*;
import java.util.Date;

public class DateClient {
  static int defaultPort = 37;
  static String defaultHost = "time.nist.gov"; 

  // seconds from start of 20th century to Jan 1, 1970 00:00 GMT
  static final long offset = 2208988800L;

  public static void main(String args[]) {
    try {
      String h = defaultHost;
      int p = defaultPort;
      if (args.length == 1) {
        h = args[0];
      } else if (args.length == 2) {
        h = args[0];
        p = Integer.parseInt(args[1]);
      }
      Date d = new DateAtHost(h, p);
      System.out.println("The time at " + h + " is: " + d);
    } catch(IOException e) {
      System.err.println("Failed to get the time: " + e);
    }
  }
}
