package ch02.examples;

import java.util.*;

public class HelloJava {
  public static void main(String[] args) {
    Greeting g = new Greeting();
    g.name = "Duke"; // Java&rsquo;s original "mascot"
    System.out.println("Hello, " + g.name);
  }
}

class Greeting {
  String name;
  Locale region;
}

