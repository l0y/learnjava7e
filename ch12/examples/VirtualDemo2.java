package ch12.examples;

public class VirtualDemo2 {
  public static void main(String args[]) throws Exception {
    Thread t = Thread.startVirtualThread( () ->
      System.out.println("Hello thread! " +
          "ID: " + Thread.currentThread().threadId())
    );
    t.join();
  }
}

