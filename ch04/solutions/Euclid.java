package ch04.solutions;

/**
 * A basic implementation of Euclid's greatest common denominator
 * algorithm.
 *
 * https://en.wikipedia.org/wiki/Algorithm
 */
public class Euclid {
  public static void main(String args[]) {
    // For now, just "hard code" the two numbers to compare
    int a = 2701;
    int b = 222;

    // Keep the originals around for some nicer output
    int a0 = a;
    int b0 = b;

    // Exercise 1, fill in the algorithm from Chapter 4
    while (b != 0) {
      if (a > b) {
        a = a - b;
      } else {
        b = b - a;
      }
    }

    // Can you include the original numbers in the output?
    //System.out.println("The GCD is " + a);
    System.out.println("The GCD of " + a0 + " and " + b0 + " is " + a);
  }
}
