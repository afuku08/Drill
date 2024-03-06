import java.awt.*;
import java.awt.event.*;

class TickTestListener implements ActionListener{
    Tick tick;
    int count;

    TickTestListener(Tick t){
        tick = t;
        t.addActionListener(this);
        count = 0;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("*** Tick *** : " + count++);
    }
}

public class TickTest {
    
    public static void main(String[] args) {
        new TickTestListener(new Tick(1000));
    }
}
