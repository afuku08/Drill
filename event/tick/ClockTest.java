import java.awt.*;
import javax.swing.*;
import java.text.*;

class ClockPanel extends JPanel {
    Font myfont = new Font("SansSerif",Font.BOLD,20);
    DecimalFormat df = new DecimalFormat("00");
    Time t = new Time(0,0,0);
    ClockMethods clock;

    public ClockPanel(ClockMethods ck){
        clock = ck;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        clock.getTime(t);
        g.setFont(myfont);
        g.drawString(df.format(t.hour)  +":" + df.format(t.minute)+":" + df.format(t.second),10,100);
    }
}

class ClockFrame0 extends JFrame {
    protected ClockMethods clock;
    protected ClockAction stopA, startA, resetA, defaultA;

    ClockFrame0(){
        clock = new Clock();

        setTitle("Simple Type Clock");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.35),(int)(d.height * 0.3));
        setLocation((int)(d.width * 0.1),(int)(d.height * 0.1));
        addWindowListener(new WindowTerminator());

        stopA = new ClockAction("Stop", ClockMethods.STOP_CLOCK, clock);
        startA = new ClockAction("Start", ClockMethods.START_CLOCK, clock);
        resetA = new ClockAction("Reset", ClockMethods.RESET_CLOCK, clock);
        defaultA = new ClockAction("Default", ClockMethods.DEFAULT_CLOCK, clock);

        JToolBar tb = new JToolBar();

        tb.add(stopA);
        tb.add(startA);
        tb.add(resetA);
        tb.add(defaultA);

        Container c = getContentPane();
        c.add(tb,BorderLayout.NORTH);
        JPanel p = new ClockPanel(clock);
        c.add(p);
        clock.setViewer(p);

    }
}

public class ClockTest {
    public static void main(String[] args) {
        JFrame f = new ClockFrame0();
        f.setVisible(true);
    }
}
