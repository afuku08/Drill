import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BoxLayoutFrame extends BaseFrame implements ActionListener {
    BoxLayoutFrame() {
        super("BoxLayout Test",0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());
        int i;
        /*ボックスレイアウト付きコンテナを作るスタティックファクトリ呼び出し */
        Box b = Box.createVerticalBox();

        /*ボタンの登録左詰 */
        for(i=1;i<=5;++i) {
            b.add(createButton(""+i));
        }

        Box b1 = Box.createVerticalBox();

        /*ボタンの登録左詰 */
        for(i=8;i<=10;++i){
            b1.add(createButton(""+i));
        }

        Box b2 = Box.createVerticalBox();

        /*ボタンの登録中央にあわせる */
        for(i=13;i<=15;++i){
            b2.add(createButton(""+i,0.5f));
        }
        b2.add(Box.createVerticalStrut(30));
        b2.add(createButton("Button A",0.5f));

        Box b3 = Box.createVerticalBox();

        /*ボタンの登録右詰 */
        for(i=16;i<=20;++i){
            b3.add(createButton(""+i, 1.0f));
        }
        b3.add(Box.createGlue());
        b3.add(createButton("Button B",1.0f));

        Container c = getContentPane();

        /*2行2列のぎりっどレイアウト設定 */
        c.setLayout(new GridLayout(2,2));

    /*ボックスレイアウトつきコンテナをグリッドに登録 */
    c.add(b);
    c.add(b1);
    c.add(b2);
    c.add(b3);
    c.setBackground(Color.WHITE);
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

    private JButton createButton(String s, float align){
        JButton b = createButton(s);

        /*x方向のAlignmentを設定する */
        b.setAlignmentX(align);
        return b;
    }
}

public class BoxLayoutTest {
    public static void main(String[] args){
        JFrame f = new BoxLayoutFrame();
        f.setVisible(true);
    }
}
