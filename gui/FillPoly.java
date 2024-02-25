import java.awt.*;
import javax.swing.*;


class FillPolyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Polygon p = makePolygon(5,110,110,100,1);
        Polygon p2 = makePolygon(5,110,110,100,2);

        g.setColor(Color.BLACK);

        g.fillPolygon(p);

        g.translate(250,0);
        g.fillPolygon(p2);

        p = makePolygon(7,110,110,100,1);
        p2 = makePolygon(7,110,110,100,2);

        g.setColor(Color.BLUE);

        g.translate(-250,250);
        g.fillPolygon(p);

        g.translate(250,0);
        g.fillPolygon(p2);
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
        int i,j;
        int px,py;
        for( i = j = 0; i < n; ++i, j += s ) {
            px = (int)(Math.cos(angle * (j % n)) * r) + x;
            py = (int)(Math.sin(angle * (j % n)) * r) + y;
            p.addPoint(px,py);
        }
        return p;
    }
}

class FillPolyFrame extends JFrame {
    FillPolyFrame() {
        addWindowListener(new WindowTerminator());
        setTitle("This is a FillPoly Frame");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width / 2,d.height / 2);
        setLocation(d.width / 4,d.height / 4);
        setIconImage(t.getImage("javaex.jpg"));
        getContentPane().add(new FillPolyPanel());
    }
}

public class FillPoly {
    public static void main(String[] args) {
        JFrame f = new FillPolyFrame();
        f.setVisible(true);
    }
}