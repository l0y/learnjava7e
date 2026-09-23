package ch06.examples;

public class HelloJava6 {
  public static void main(String args[]) {
    try {
      Greeting6 g6 = new Greeting6("Al");
      System.out.println("Hi " + g6.name);
    } catch (ShortNameException sne) {
      System.out.println("Bad greeting: " + sne.getShortName());
      System.out.println(sne.getMessage());
    }
  }
}

