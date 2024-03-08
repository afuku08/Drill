import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FlowLayoutFrame extends BaseFrame implements ActionListener {
    FlowLayoutFrame(){
        super("FlowLayout Test", 0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());

        /*ボタンを配置するパネル */
        JPanel p = new JPanel();

        //p.setLayout(new FlowLayout(FlowLayout.RIGHT));
        /*背景色は白 */
        p.setBackground(Color.WHITE);

        /*1から30まで数字のついたボタンを生成 */
        for(int i=1;i<=30;++i) {
            p.add(createButton(""+i));
        }
        Container c = getContentPane();
        c.add(p);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        JButton b = (JButton) e.getSource();

        /*ボタンは不透明か？ */
        if(b.isOpaque()){

            /*ボタンを透明に設定 */
            b.setOpaque(false);

            /*ボタンテキストをコマンド文字列に戻す */
            b.setText(s);
        }else{
            /*不透明に設定 */
            b.setOpaque(true);

            /*ボタンテキストの末尾に'!'を追加 */
            b.setText((s+"!"));
        }
        repaint();
    }
    
    /*コマンドsを持つボタンを生成する */
    private JButton createButton(String s){
        JButton b = new JButton(s);

        /*パラメータをコマンド文字列として設定 */
        b.setActionCommand(s);

        /*Frame自体をActionListenerとする */
        b.addActionListener(this);

        /*ボタンの背景色をライトグレーにする */
        b.setBackground(Color.LIGHT_GRAY);

        /*ボタンを透明とする */
        b.setOpaque(false);
        return b;
    }
}

public class FlowLayoutTest {
    public static void main(String[] args){
        JFrame f = new FlowLayoutFrame();
        f.setVisible(true);
    }
}
