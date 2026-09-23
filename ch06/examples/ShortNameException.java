package ch06.examples;

public class ShortNameException extends Exception {
  String shortName;

  public ShortNameException(String name, String message) {
    super(message);
    shortName = name;
  }

  public String getShortName() { return shortName; }
}

