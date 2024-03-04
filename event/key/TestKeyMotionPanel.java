import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class KeyMotionPanel extends JPanel{
    private int curX = 0;
    private int curY = 0;
    private int maxX = 100;
    private int maxY = 100;
    private final int size = 20;

    public KeyMotionPanel(){
        setBackground(Color.WHITE);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ev){
                int delta = (ev.isShiftDown() ? 5 : 1);
                int x = curX;
                int y = curY;

                switch(ev.getKeyCode()){
                    case KeyEvent.VK_UP : y -= delta; break;
                    case KeyEvent.VK_DOWN : y += delta; break;
                    case KeyEvent.VK_RIGHT : x += delta; break;
                    case KeyEvent.VK_LEFT : x -= delta; break;
                    default : break;
                }

                if(y > maxY - size) y = maxY - size;
                else if(y < 0) y = 0;
                if(x > maxX - size) x = maxX - size;
                else if(x < 0) x = 0;

                if( x != curX || y != curY ){
                    curX = x;
                    curY = y;
                    repaint();
                }

            }
        });
    }

    public boolean isFocusable(){
        return true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension d = getSize();
        maxX = d.width;
        maxY = d.height;

        g.setColor(Color.RED);
        g.fillOval(curX, curY, size, size);
    }
}

class KeyMotionFrame extends JFrame {
    KeyMotionFrame() {
        setTitle("Key Input Test.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        getContentPane().add(new KeyMotionPanel());
    }
}

public class TestKeyMotionPanel {
    public static void main(String[] args){
        JFrame f = new KeyMotionFrame();
        f.setVisible(true);
    }
}
