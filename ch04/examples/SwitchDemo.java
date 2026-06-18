package ch04.examples;

public class SwitchDemo {
  // Constants for use in various switch cases
  // Chapter 5 covers the "public static final" modifiers for constants
  public static final int GOOD = 1;
  public static final int BAD = 2;
  public static final int MINISCULE = 0;
  public static final int TEENYWEENY = 1;
  public static final int SMALL = 2;
  public static final int MEDIUM = 4;
  public static final int LARGE = 7;
  public static final int EXTRALARGE = 10;

    
  public static void main(String args[]) {
    // "Bad" version that prints unexpected numbers
    int value = 2;

    switch(value) {
      case 1:
        System.out.println(1);
      case 2:
        System.out.println(2);
      case 3:
        System.out.println(3);
    }

    // "Good" version that uses breaks to get expected results
    value = GOOD;

    switch ( value ) {
      case GOOD:
        // something good
        System.out.println("Good");
        break;
      case BAD:
        // something bad
        System.out.println("Bad");
        break;
      default:
        // neither one
        System.out.println("Not sure");
        break;
    }

    // A more interesting combination of cases and breaks
    value = MINISCULE;
    String label = "Unknown";

    switch( value ) {
      case MINISCULE:
      case TEENYWEENY:
      case SMALL:
        label = "Small";
        break;
      case MEDIUM:
        label = "Medium";
        break;
      case LARGE:
      case EXTRALARGE:
        label = "Large";
        break;
    }
    System.out.println("Your size is: " + label);

    // Similar idea, but use the "expression" version of switch
    value = EXTRALARGE;

    label = switch( value ) {
      case MINISCULE, TEENYWEENY, SMALL -> "Small";
      case MEDIUM -> "Medium";
      case LARGE, EXTRALARGE -> "Large";
      default -> "Unknown";
    };
    System.out.println("Your size is: " + label);

    value = switch( label ) {
      case "Small", "Miniscule", "Teenyweeny" -> SMALL;
      case "Medium" -> MEDIUM;
      case "Large", "Extra large" -> LARGE;
      default -> 0;
    };
    System.out.println("Standardized value via String lookup: " + value);

    Size size = new Size("Medium", MEDIUM);
    Object unknown = size;
    switch ( unknown ) {
      case String str:
        System.out.println("Via String: " + str);
        break;
      case Size sz:
        System.out.println("Via Size object: " + sz.getLabel());
        break;
      default:
        System.out.println("Maybe via value?" + size);
    }
  }
}

class Size {
  String label;
  int value;

  public Size(String label, int value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }
  public int getValue() {
    return value;
  }
}

