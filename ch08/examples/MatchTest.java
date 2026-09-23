package ch08.examples;

import java.util.regex.*;

public class MatchTest {
  public static void main(String[] args) {
    String text="A horse is a horse, of course of course...";
    String pattern="horse|course";

    Matcher matcher = Pattern.compile(pattern).matcher(text);
    while (matcher.find())
      System.out.println(
        "Matched: '"+matcher.group()+"' at position "+matcher.start());
  }
}
