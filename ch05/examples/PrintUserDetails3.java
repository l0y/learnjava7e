package ch05.examples;

public class PrintUserDetails3 {
  public static void main(String args[]) {
    User u1 = new User();
    System.out.println("User u1:");
    u1.printDetails();

    // fill in some information
    u1.username = "Duke";
    u1.hostname = "localhost";
    u1.authenticated = true;

    System.out.println("Updated u1:");
    u1.printDetails();
  }
}

