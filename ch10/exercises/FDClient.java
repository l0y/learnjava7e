package ch10.exercises;

import java.net.*;
import java.io.*;

// Create you own Friendly Date Client. This client should create a
// connection to a Friendly Date Server and read a one-line response.
// You don't need to convert the response to an Instant, although you
// certainly can if you want to practice creating objects from strings.
// Be sure to print out the date at the end, whether you convert it or
// not.

public class FDClient {
  public static void main(String args[]) {
    if (args.length != 1) {
      // We're expecting a command-line argument, but you could also
      // prompt the user with IO.readln() if no arg was supplied.
      System.err.println("Please provide a host to contact.");
      System.exit(1);
    }
  }
}
