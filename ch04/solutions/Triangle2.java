package ch04.solutions;

// Exercise 2. Print out the contents of our
// "triangular" array, but this time arrange the
// output in a triangular shape.

public class Triangle1 {
  public static void main(String args[]) {
    // Create our "triangular" two-dimensional array
    int[][] triangle = new int[5][];

    // Use nested loops to fill it
    for (int i = 0; i < triangle.length; i++) {
        triangle[i] = new int [i + 1];
        for (int j = 0; j < i + 1; j++)
            triangle[i][j] = i + j;
    }

    // Add your code to display the nested arrays here
    for (int i = 0; i < triangle.length; i++) {
      for (int j = 0; j < triangle[i].length; j++) {
        System.out.print(triangle[i][j] + " ");
      }
      System.out.println();
    }
  }
}
