import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* 多角形塗りつぶし用パネル */
/* このパネル自身がイベントリスナーとして機能する */
class ButtonTestPanel extends FillPolyPanelEv implements ActionListener {
    private JButton yellow;
    private JButton blue;
    private JButton green;

    public ButtonTestPanel() {
        yellow = new JButton("yellow");
        blue = new JButton("Blue");
        green = new JButton("Green");

        add(yellow);
        add(blue);
        add(green);

        /* リスナーオブジェクトの登録 */
        yellow.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
    }

    /* ボタンクリック時の処理 */
    /* 受信イベントオブジェクトはActionEvent */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == yellow) color = Color.yellow;
        else if(source == blue) color = Color.blue;
        else if(source == green) color = Color.green;

        /* 描画更新 */
        repaint();
    }
}
