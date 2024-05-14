import java.awt.*;
import javax.swing.*;

public class BaseFrame extends JFrame {
    BaseFrame(String title,double high,double width,double down,double right) {
        setTitle(title);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * high),(int)(d.height * width));
        setLocation((int)(d.width * down), (int)(d.height * right));
        Image jimg = t.getImage("./javaex.jpg");
        setIconImage((jimg));
    }
}