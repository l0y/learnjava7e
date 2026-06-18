package ch05.examples;

public class PrintUserDetails {
  public static void main(String args[]) {
    User u1 = new User();
    System.out.println("User u1:");
    System.out.println("  name: " + u1.username);
    System.out.println("  host: " + u1.hostname);
    System.out.println("  status: " + u1.status);
    System.out.println("  authenticated? " + u1.authenticated);
  }
}

