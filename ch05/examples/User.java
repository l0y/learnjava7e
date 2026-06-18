package ch05.examples;

class User {
  public static final int ACTIVE=1;
  public static final int IDLE=2;
  public static final int LOGGED_IN=3;

  String username;
  String hostname;
  boolean authenticated;
  int status;

  boolean authenticate(int pin) {
    return false;
  }

  public static String nameForStatus(int status) {
    if (status == ACTIVE) {
      return "Active";
    } else if (status == IDLE) {
      return "Idle";
    } else if (status == LOGGED_IN) {
      return "Logged in";
    } else {
      return "Unknown";
    }
  }
  
  public void printDetails() {
    System.out.println("  name: " + username);
    System.out.println("  host: " + hostname);
    System.out.println("  status: " + status);
    System.out.println("  authenticated? " + authenticated);
  }
}


