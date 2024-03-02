import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ChangeColorAction extends AbstractAction {
    private Component target;

    ChangeColorAction(String name,Icon icon,Color c,Component comp) {
        target = comp;
        putValue(Action.NAME,name);
        putValue(Action.SMALL_ICON,icon);
        putValue("color",c);
    }
    public void actionPerformed(ActionEvent ev) {
        Color c = (Color)getValue("color");
        target.setBackground(c);
        target.repaint();
    }
}

class ActionTestFrame extends JFrame {
    ActionTestFrame() {
        setTitle("This is an Action Test.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.4),(int)(d.height * 0.4));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        Image jimg = t.getImage("javaex.jpg");
        setIconImage(jimg);

        JPanel p = new JPanel();

        ChangeColorAction yellow = new ChangeColorAction("Yellow",
                new ImageIcon("Yellow_ba.gif"),Color.YELLOW,p);
        ChangeColorAction blue = new ChangeColorAction("Blue",
                new ImageIcon("Blue_ba.gif"),Color.BLUE,p);
        ChangeColorAction green = new ChangeColorAction("Green",
                new ImageIcon("Green_ba.gif"),Color.GREEN,p);
        ChangeColorAction magenta = new ChangeColorAction("Magenta",
                new ImageIcon("Magenta_ba.gif"),Color.MAGENTA,p);
        ChangeColorAction black = new ChangeColorAction("Black",
                new ImageIcon("Black_ba.gif"),Color.BLACK,p);
        ChangeColorAction red = new ChangeColorAction("Red",
                new ImageIcon("Red_ba.gif"),Color.RED,p);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(p,BorderLayout.CENTER);
        JMenu m = new JMenu("Color Control");
        m.add(red);
        m.add(magenta);
        m.add(yellow);
        m.add(green);
        m.add(blue);
        m.add(black);

        JMenuBar b = new JMenuBar();
        b.add(m);
        setJMenuBar(b);

        JToolBar to = new JToolBar(JToolBar.VERTICAL);
        to.add(red);
        to.add(magenta);
        to.add(yellow);
        to.add(green);
        to.add(blue);
        to.add(black);

        contentPane.add(to,BorderLayout.EAST);
    }
}

public class ActionTest {
    public static void main(String[] args) {
        JFrame f = new ActionTestFrame();
        f.setVisible(true);
    }
}