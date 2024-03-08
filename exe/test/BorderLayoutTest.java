import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BorderLayoutFrame extends BaseFrame implements ActionListener {
    BorderLayoutFrame() {
        super("BorderLayout test.",0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout((new BorderLayout()));
        p.add(createButton(""+1), BorderLayout.NORTH);
        p.add(createButton(""+2), BorderLayout.SOUTH);
        p.add(createButton(""+3), BorderLayout.EAST);
        p.add(createButton(""+4), BorderLayout.WEST);
        p.add(createButton(""+5), BorderLayout.CENTER);

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

    private JButton createButton(String s){
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.addActionListener(this);
        b.setBackground(Color.LIGHT_GRAY);
        b.setOpaque(false);
        return b;
    }
}

public class BorderLayoutTest {
    public static void main(String[] args){
        JFrame f = new BorderLayoutFrame();
        f.setVisible(true);
    }
}
