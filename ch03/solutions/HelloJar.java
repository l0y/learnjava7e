package ch03.solutions;

public class HelloJar {
  public static void main( String[] args ) {
    String msg = "You cheated! :)";
    if ( HelloJar.class.getProtectionDomain()
           .getCodeSource()
           .getLocation()
           .getFile()
           .endsWith(".jar") ) {
      // You didn't cheat (hooray!), so let's fix the message
      msg = "Hello from a JAR file!";
    }
    System.out.println(msg);
  }
}
