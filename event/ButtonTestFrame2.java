import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* ボタンテスト用フレーム */
/* 主要な処理は、ButtonTestPanelにて行われる */
class ButtonTestFrame2 extends JFrame {
    ButtonTestFrame2() {
        setTitle("This is a Button Test.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        //getContentPane().add(new ButtonTestPanel());

        JPanel p = new FillPolyPanelEv();

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
        m.add(black);
        m.add(yellow);
        m.add(green);
        m.add(blue);

        JMenuBar b = new JMenuBar();
        b.add(m);
        setJMenuBar(b);
    }
}
