import java.awt.*;
import javax.swing.*;

class DrawRectPanel extends JPanel {
    private final int width = 100;
    private final int height = 50;
    private final int thickness = 5;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Dimension d = getSize();
        int cx = d.width /2;
        int cy = d.height / 10;

        g.setColor(Color.BLUE);
        g.translate(cx,cy);
        //g.drawRect(-width / 2,0,width,height);
        g.fillRect(-width / 2, 0, width, height);

        g.translate(0,height + 20);
        g.setColor(Color.RED);
        //g.drawRoundRect(-width /2,0,width,height,10,10);
        g.fillRoundRect(-width /2,0,width,height,10,10);

        g.translate(0,height +20);
        g.setColor(Color.DARK_GRAY);
        g.fill3DRect((-width / 2),0,width,height,true);
        int i;
        for( i = 0; i < thickness; ++i ) {
            g.draw3DRect((-width / 2) - i,0 - i,width + 2*i,height + 2*i,true);
            //g.fill3DRect((-width / 2) - i,0 - i,width + 2*i,height + 2*i,true);
        }
        

        g.translate(0,height + 20);
        g.setColor(Color.GRAY);

        for( i = 0; i < thickness; ++i ) {
            g.draw3DRect((-width / 2) - i,0 - i,width + 2*i,height + 2*i,false);
        }

        g.translate(0,height + 20);
        g.setColor(Color.GREEN);
        //g.drawOval(-width / 2,0,width,height);
        g.fillOval(-width / 2,0,width,height);
    }
}

class DrawRectFrame extends JFrame {
    DrawRectFrame() {
        addWindowListener(new WindowTerminator());
        setTitle("This is a DrawRect Frame");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width / 2,d.height / 2);
        setLocation(d.width / 4,d.height / 4);
        setIconImage(t.getImage("javaex.jpg"));
        getContentPane().add(new DrawRectPanel());
    }
}

public class DrawRect {
    public static void main(String[] args) {
        JFrame f = new DrawRectFrame();
        f.setVisible(true);
    }
}