package ch11.examples;

/*
 * This is a GUI (graphical user interface) application. It creates
 * a window on your desktop and can respond to mouse clicks. We
 * don't cover the graphical features of Java in this edition, but
 * you can find many tutorials online. For books, Java Swing 2e, by
 * Loy et al. from O'Reilly covers a broad range of Java's graphical
 * components in great detail.
 */

// The javax.swing and java.awt packages contain the vast bulk of 
// Java's graphical components.
import javax.swing.*;
import java.awt.*;

// The java.awt.event package has classes covering the creation and
// handling of events common in desktop applications such as button
// clicks, mouse movements, and text entry. This applicaion only
// needs to worry about mouse clicks.
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// JFrame is a Swing top-level component for creating a windowed
// application on your desktop. Implementing the MouseListener
// interface tells the compiler we're expecting to handle mouse
// events.
public class Interruption extends JFrame implements MouseListener {

  // JLabel is a simple component for displaying text or icons.
  JLabel message;
  Thread fiveSeconds;

  // label bounds
  int labelX = 10;
  int labelY = 20;
  int labelW = 120;
  int labelH = 20;

  // frame size and edges (including a margin based on label bounds)
  int frameW = 400, frameH = 200;
  int margin = 10;
  int left = margin, right = frameW - labelW - margin;
  int top = margin, bottom = frameH - labelH - margin - 32; // 32 for average title bar

  public Interruption() {
    // Create our JFrame object with an appropriate title and size
    super("interrupt() Demo");
    setSize(frameW, frameH);

    // Make sure the application exits when the user closes the window
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // We are moving our label around to random coordinates manually,
    // so we don't need (or want) a layout manager that would normally
    // help us arrange components on the screen.
    setLayout(null);

    // Setup our label and give it an initial size and location
    message = new JLabel ("Pausing...");
    message.setBounds(labelX, labelY, labelW, labelH);

    // Add the label to our JFrame (this) so it is displayed when
    // the window is created
    this.add(message);

    // And make sure our mouse click events get sent to our handlers
    addMouseListener(this);
  }

  public static void main(String args[]) {
    Interruption i = new Interruption();
    i.setVisible(true);
    i.startPause();
  }

  // Helper method to scoot our label around the screen
  public void moveMessage() {
    // Keep our message visible within the frame using the range formula from ch8
    //int randomValue = min + (int)(Math.random() * (max - min));
    labelX = left + (int)(Math.random() * (right - left));
    labelY = top + (int)(Math.random() * (bottom - top));
    message.setLocation(labelX, labelY);
    repaint();
  }

  // The guts of the interesting thread logic. We move our label and
  // sleep for five seconds in an infinite loop. If we get interrupted,
  // we change the text of the label to provide visual feedback to the
  // user. The loop will keep going so you can interrupt the thread
  // again if you're curious.
  public void startPause() {
    fiveSeconds = new Thread(new Runnable() {
      public void run() {
        while (true) {
          try {
            moveMessage();
            Thread.sleep(5000);
            message.setForeground(Color.BLACK);
            message.setText("Done. Pausing...");
          } catch (InterruptedException ie) {
            message.setForeground(Color.RED);
            message.setText("Interrupted!");
          }
        }
      }
    });
    fiveSeconds.start();
  }

  // This method is part of the MouseListener interface.
  // Any time the mouse is clicked on the window, a MouseEvent
  // is generated and passed to this method. We call the
  // interrupt() method on our label-moving thread.
  public void mouseClicked(MouseEvent e) {
    fiveSeconds.interrupt();
  }

  // The MouseListener interface also allows you to handle other
  // types of mouse events. We need to implement them to fulfill
  // the interface contract, but we don't really care about any
  // of these events themselves so we just use empty bodies that
  // effectively ignore these events. Feel free to try interrupting
  // the fiveSeconds thread using any of these methods if you're
  // curious about them.
  public void mousePressed(MouseEvent e) { }
  public void mouseReleased(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
}
