import java.awt.*;
import javax.swing.*;
class DrawPolyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        Polygon p = makePolygon(5,110,110,100,1);
        Polygon p2 = makePolygon(5,110,110,100,2);

        g.setColor(Color.BLACK);
        g.drawPolygon(p);
        g.drawPolygon(p2);

        p = makePolygon(7,110,110,100,1);
        p2 = makePolygon(7,110,110,100,2);
        g.setColor(Color.BLUE);
        g.translate(250,0);
        g.drawPolygon(p);
        g.drawPolygon(p2);

        p = makePolygon(31, 110, 110, 100, 1);
        
        p2 = makePolygon(31, 110, 110, 100, 2);
        Polygon p3 = makePolygon(31, 110, 110, 100, 3);
        Polygon p4 = makePolygon(31, 110, 110, 100, 4);
        Polygon p5 = makePolygon(31, 110, 110, 100, 5);
        Polygon p6 = makePolygon(31, 110, 110, 100, 6);
        Polygon p7 = makePolygon(31, 110, 110, 100, 7);
        g.translate(250, 0);
        g.setColor(Color.BLACK);
        g.drawPolygon(p);
        g.setColor(Color.MAGENTA);
        g.drawPolygon(p2);
        g.setColor(Color.BLUE);
        g.drawPolygon(p3);
        g.setColor(Color.GREEN);
        g.drawPolygon(p4);
        g.setColor(Color.YELLOW);
        g.drawPolygon(p5);
        g.setColor(Color.ORANGE);
        g.drawPolygon(p6);
        g.setColor(Color.RED);
        g.drawPolygon(p7);
        
    }

    /* ポリゴンを生成する */
    /* @return java.awt.Polygon */
    /* @param n int 頂点の数 */
    /* @param x int 中心点x座標 */
    /* @param y int 中心点y座標 */
    /* @param r int 半径 */
    /* @param s int スキップ値 */
    Polygon makePolygon(int n, int x, int y, int r,int s) {
        Polygon p = new Polygon();
        double angle = (Math.PI * 2) / n;
        int  i,j;
        int  px,py;
        for( i = j = 0; i < n; ++i, j += s ) {
            px = (int)(Math.cos(angle * (j % n)) * r) + x;
            py = (int)(Math.sin(angle * (j % n)) * r) + y;
            p.addPoint(px,py);
        }
        return p;
    }
}

class DrawPolyPanel2 extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Dimension d = getSize();
        int cx = d.width / 2;
        int cy = d.height / 2;
        int r = (cx > cy ? cy -30 : cx -30);
        g.translate(cx, cy);

        Polygon p = makePolygon(31, 0, 0, r, 1);
        g.setColor(Color.BLACK);
        g.fillPolygon(p);
        //g.drawPolygon(p);

        p = makePolygon(31, 0, 0, r, 2);
        g.setColor(Color.MAGENTA);
        g.fillPolygon(p);
        //g.drawPolygon(p);

        p = makePolygon(31, 0, 0, r, 3);
        g.setColor(Color.BLUE);
        g.fillPolygon(p);
        //g.drawPolygon(p);

        p = makePolygon(31, 0, 0, r, 4);
        g.setColor(Color.GREEN);
        g.fillPolygon(p);
        //g.drawPolygon(p);

        p = makePolygon(31, 0, 0, r, 5);
        g.setColor(Color.YELLOW);
        g.fillPolygon(p);
        //g.drawPolygon(p);

        p = makePolygon(31, 0, 0, r, 6);
        g.setColor(Color.ORANGE);
        g.fillPolygon(p);
        //g.drawPolygon(p);

        p = makePolygon(31, 0, 0, r, 7);
        g.setColor(Color.RED);
        g.fillPolygon(p);
        //g.drawPolygon(p);
    }

    Polygon makePolygon(int n, int x, int y, int r,int s) {
        Polygon p = new Polygon();
        double angle = (Math.PI * 2) / n;
        int  i,j;
        int  px,py;
        for( i = j = 0; i < n; ++i, j += s ) {
            px = (int)(Math.cos(angle * (j % n)) * r) + x;
            py = (int)(Math.sin(angle * (j % n)) * r) + y;
            p.addPoint(px,py);
        }
        return p;
    }
}

class DrawPolyFrame extends JFrame {
    DrawPolyFrame() {
        addWindowListener(new WindowTerminator());
        setTitle("This is a DrawPoly Frame");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width / 2,d.height / 2);
        setLocation(d.width / 4,d.height / 4);
        setIconImage(t.getImage("javaex.jpg"));
        getContentPane().add(new DrawPolyPanel());
    }
}

class DrawPolyFrame2 extends JFrame {
    DrawPolyFrame2() {
        addWindowListener(new WindowTerminator());
        setTitle("This is a DrawPoly Frame2");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width / 2,d.height / 2);
        setLocation(d.width / 4,d.height / 4);
        setIconImage(t.getImage("javaex.jpg"));
        getContentPane().add(new DrawPolyPanel2());
    }
}

public class DrawPoly {
    public static void main(String[] args) {
        JFrame f = new DrawPolyFrame2();
        f.setVisible(true);
    }
}