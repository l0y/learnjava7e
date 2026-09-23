package ch08.exercises;

public class ThrowSomeDice {
  public static void main(String args[]) {
    if (args.length < 1) {
      System.out.println("Usage is: java ThrowSomeDice {nds} [nds [nds ...]]")
    } else {
      System.out.println("Parsing " + args.length + " throws");
    }
  }
}
