import java.awt.*;
import javax.swing.*;

class AnotherHelloWorldPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Another Hello World!",75,100);
    }
}

class CommandLinePanel extends JPanel {
    private String msg;

    CommandLinePanel(String msg) {
        this.msg = msg;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(msg, 75, 100);
    }
}

class AnotherHelloWorldFrame extends JFrame {
    AnotherHelloWorldFrame() {
        addWindowListener(new WindowTerminator());
        setTitle("This is a Another HelloWorldFrame.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width / 2,d.height / 2);
        setLocation(d.width / 4,d.height / 4);
        setIconImage(t.getImage("javaex.jpg"));
        getContentPane().add(new AnotherHelloWorldPanel());
    }
}

public class AnotherHelloWorld {
    public static void main(String[] args) {
        JFrame f = new AnotherHelloWorldFrame();
        f.setVisible(true);
    }
}
