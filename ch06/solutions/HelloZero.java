package ch06.solutions;

public class HelloZero {
  public static void main( String[] args ) {
    assert(args.length > 0);
    System.out.println("Hi " + args[0] + "!");
  }
}
