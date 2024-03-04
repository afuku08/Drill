import java.awt.*;
import javax.swing.*;

class FillPolyPanelEv extends JPanel {
    /* 色を変数で指定する */
    protected Color color = Color.BLACK;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* 座標変換の整合性をとるために作業用のGraphicsを複製する */
        Graphics g2 = g.create();
        setBackground(Color.WHITE);
        Polygon p = makePolygon(5,110,110,100,1);
        Polygon p2 = makePolygon(5,110,110,100,2);

        g2.setColor(color);

        /* ボタンの表示位置を避ける */
        g2.translate(0,100);
        g2.fillPolygon(p);

        g2.translate(250,0);
        g2.fillPolygon(p2);

        p = makePolygon(7,110,110,100,1);
        p2 = makePolygon(7,110,110,100,2);

        g2.setColor(color);

        g2.translate(-250,250);
        g2.fillPolygon(p);

        g2.translate(250,0);
        g2.fillPolygon(p2);

        /* 作業用のGraphicsを廃棄する */
        g2.dispose();
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