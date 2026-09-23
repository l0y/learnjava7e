package ch08.solutions;

import java.util.regex.*;

public class ThrowSomeDice {
  public static void main(String args[]) {
    if (args.length < 1) {
      System.out.println("Usage is: java ThrowSomeDice {nds} [nds [nds ...]]");
    } else {
      if (args.length == 1) {
        // Just parse this one die and display its output
        DieRoll dieroll = new DieRoll(args[0]);
        int[] rolls = dieroll.roll();
        for (int r : rolls) {
          System.out.print(r + " ");
        }
        System.out.println();
      } else {
        // Multiple arguments, display both the current die roll and its output
        for (String die : args) {
          DieRoll dieroll = new DieRoll(die);
          System.out.print(die + ": ");
          int[] rolls = dieroll.roll();
          for (int r : rolls) {
            System.out.print(r + " ");
          }
          System.out.println();
        }
      }
    }
  }
}

class DieRoll {
  int count;
  int sides;

  public DieRoll(String roll) {
    if (Pattern.matches("\\d+[dD]\\d+", roll)) {
      // We have a valid roll representation, go ahead and break it up
      String[] parts = roll.split("d|D");
      count = Integer.parseInt(parts[0]);
      sides = Integer.parseInt(parts[1]);
    } else {
      throw new IllegalArgumentException("Invalid roll: " + roll);
    }
  }

  public int getNumberOfDice() {
    return count;
  }

  public int getNumberOfSides() {
    return sides;
  }

  public int[] roll() {
    int[] result = new int[count];
    for (int r = 0; r < count; r++) {
      result[r] = 1 + (int)(Math.random() * sides);
    }
    return result;
  }

  public String toString() {
    return count + "d" + sides;
  }
}
