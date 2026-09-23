package ch06.examples;

import java.util.Locale;

public class Greeting6 {
  String name;
  Locale region;

  public Greeting6(String name) throws ShortNameException {
    if (name == null || name.length() < 3) {
      throw new ShortNameException(name, 
          "Names must be at least 3 characters long.");
    }
    // name is now guaranteed to exist and be "long enough"
    this.name = name;
    this.region = Locale.getDefault();
  }
}

