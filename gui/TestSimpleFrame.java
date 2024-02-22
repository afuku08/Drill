import javax.swing.*;
import java.awt.event.*;

class SimpleFrame extends JFrame {
    SimpleFrame() {
        setTitle("This is a Simple Frame");
        setSize(300,200);
        addWindowListener(new WindowTerminator());
    }
}

class SimpleFrameWithSize extends JFrame {
    SimpleFrameWithSize(int width, int height) {
        setTitle("This is a Simple Frame With Size");
        setSize(width, height);
    }

    public static JFrame makeFrame(int width, int height) {
        return new SimpleFrameWithSize(width,height);
    }
}

class ClosableSimpleFrameAnonymous extends JFrame {
    ClosableSimpleFrameAnonymous() {
        setTitle("This is a Closable Simple Frame Anonymous");
        setSize(300, 200);
        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            }
        );
    }
}

public class TestSimpleFrame {
    public static void main(String [] args) {
        SimpleFrame f = new SimpleFrame();
        f.setVisible(true);
    }
}