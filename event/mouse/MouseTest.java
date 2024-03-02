import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MousePanel extends JPanel implements MouseMotionListener {
    private int current_x;
    private int current_y;
    private int left_x; private int left_y;
    private int right_x;
    private int right_y;
    private boolean select = false;
    private Color select_color = Color.BLUE;
    private Color draw_color = Color.BLACK;

    private class MouseClickCheckListener extends MouseAdapter {
        public void mouseClicked(MouseEvent ev) {
            int x = ev.getX();
            int y = ev.getY();

            if (ev.getClickCount() >= 2) {
                eraseLine();
                current_x = x;
                current_y = y;
                if ( !select ) {
                    select = true;
                    drawLine();
                    setCursor(Cursor.getPredefinedCursor(
                        Cursor.CROSSHAIR_CURSOR));
                } else {
                    select = false;
                    drawLine();
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        }
    }

    public MousePanel() {
        addMouseListener(new MouseClickCheckListener());
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
    }

    public void mouseDragged(MouseEvent ev) {
        eraseLine();
        select = true;
        current_x = ev.getX();
        current_y = ev.getY();
        drawLine();
    }

    public void mouseMoved(MouseEvent ev) {
        if ( select ) {
            eraseLine();
            current_x = ev.getX();
            current_y = ev.getY();
            drawLine();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = getSize();
        right_x = d.width;
        left_x  = 0;
        right_y = left_y = d.height / 2;
        current_x = (right_x + left_x) / 2;
        current_y = right_y;
        g.setColor(draw_color);
        g.drawLine(left_x,left_y,current_x,current_y);
        g.drawLine(right_x,right_y,current_x,current_y);
        select = false;
    }

    /* 線をDrawモードで描画する */
    private void drawLine() {
        Graphics g = getGraphics();
        if ( select ) {
            g.setColor(select_color);
        } else {
            g.setColor(draw_color);
        }
        g.drawLine(left_x,left_y,current_x,current_y);
        g.drawLine(right_x,right_y,current_x,current_y);
        g.dispose();
    }

    /* 線をXORモードで描画する */
    private void eraseLine() {
        Graphics g = getGraphics();
        if ( select ) {
            g.setColor(select_color);
        } else {
            g.setColor(draw_color);
        }
        g.setXORMode(getBackground());
        g.drawLine(left_x,left_y,current_x,current_y);
        g.drawLine(right_x,right_y,current_x,current_y);
        g.drawLine(current_x,current_y,current_x,current_y);
        g.dispose();
    }
}

class MouseFrame extends JFrame {
    MouseFrame() {
        setTitle("MouseEvent test.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        getContentPane().add(new MousePanel());
    }
}

public class MouseTest {
    public static void main(String[] args) {
        JFrame f = new MouseFrame();
        f.setVisible(true);
    }
}