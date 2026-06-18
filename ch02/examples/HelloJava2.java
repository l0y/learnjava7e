package ch02.examples;

import java.util.*;

public class HelloJava2 {
  public static void main(String[] args) {
    // we expect one command-line argument, the first index is 0--not 1
    Greeting2 g2 = new Greeting2(args[0]);
    // g2 now handles the actual output
    g2.sayHi();
  }
}

class Greeting2 {
  private String name;
  private Locale region;

  public Greeting2(String newName) {
    name = newName;
    region = Locale.getDefault();
  }

  public void sayHi() {
    System.out.println("Hi, " + name + "!");
  }
}
