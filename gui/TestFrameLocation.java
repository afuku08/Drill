import java.awt.*;
import javax.swing.*;

class FrameLocated extends JFrame {
    private Dimension d;
    FrameLocated() {
        addWindowListener(new WindowTerminator());
        setTitle("This is a Located Frame");
        Toolkit t = Toolkit.getDefaultToolkit();
        d = t.getScreenSize();
        setSize(d.width / 2,d.height / 2);
        setLocation(d.width / 4,d.height / 4);
        setIconImage(t.getImage("./logo.jpg"));
    }
}

class VariableFrame extends JFrame {
    private Dimension d;
    VariableFrame() {
        addWindowListener(new WindowTerminator());
        setTitle("This is a Variable Frame");
        Toolkit t = Toolkit.getDefaultToolkit();
        d = t.getScreenSize();
        changeSize(0.5, 0.5);
        changeLocation(0.25, 0.25);
        setIconImage(t.getImage("./logo.jpg"));
    }

    public void changeLocation(double w, double h) {
        setLocation((int)(d.width * w), (int)(d.height * h));
    }

    public void changeSize(double w, double h) {
        setSize((int)(d.width * w), (int)(d.height * h));
    }
}

public class TestFrameLocation {
    public static void main(String[] args) {
        JFrame f = new FrameLocated();
        f.setVisible(true);
        VariableFrame f1 = new VariableFrame();
        f1.changeSize(0.3, 0.3);
        f1.changeLocation(0, 0);
        f1.setVisible(true);
    }
}