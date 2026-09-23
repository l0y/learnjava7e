package ch10.examples;

// We don't touch on Swing applications (graphical interfaces), but
// it's worth seeing a quick example of using URL resources outside
// of console or backend apps. Feel free to lookup the graphical
// classes we use in this example: JFrame, JLabel, and ImageIcon.
// Early in Java's history, entire web browsers were built with Java.

import javax.swing.*;
import java.net.*;

public class IconLabel extends JFrame {
  public IconLabel() {
    super("Web Icon Demo");
    setSize(400,220);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    try {
      URL favUrl = new URL("https://www.oracle.com/asset/web/favicons/favicon-192.png");
      ImageIcon image1 = new ImageIcon(favUrl);
      JLabel iconLabel = new JLabel(image1);
      add(iconLabel);
    } catch (MalformedURLException mfe) {
      add(new JLabel("Error: " + mfe));
    }
  }

  public static void main(String args[]) {
    IconLabel demo = new IconLabel();
    SwingUtilities.invokeLater(() -> demo.setVisible(true));
  }
}
