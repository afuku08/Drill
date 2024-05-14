import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class JankenFrame extends BaseFrame implements ActionListener {
    JLabel label = new JLabel();
    Random rand = new Random();
    String[] janken = {"グー","チョキ","パー"};
    JankenFrame(){
        super("じゃんけんゲーム",0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());
        Box b = Box.createHorizontalBox();

        /* ボタンを中央にする方法がわかりませんでした． */
        b.add(createButton(janken[0],0.5f));
        b.add(createButton(janken[1],0.5f));
        b.add(createButton(janken[2],0.5f));
        
        label.setText("じゃんけんポン！");
        label.setHorizontalAlignment(JLabel.CENTER);

        Container c = getContentPane();
        c.setLayout(new GridLayout(2,1));
        c.add(b);
        c.add(label);
        c.setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        int nowHand = searchIndex(janken, s);
        int rnd = rand.nextInt(3);
        label.setText("私は" + janken[rnd] + "を出しました．あなたの" + judgeJanken(nowHand, rnd) + "です！" );
        label.setHorizontalAlignment(JLabel.CENTER);

        repaint();
    }

    private int searchIndex(String[] sarr, String s){
        for(int i=0;i<sarr.length;i++){
            if(sarr[i].equals(s)) return i;
        }
        return -1;
    }

    private String judgeJanken(int nowHand,int enemyHand){
        int sub = nowHand - enemyHand;
        if(sub == 0){
            return "引き分け";
        }else if(sub == -1 || sub == 2){
            return "勝ち";
        }else{
            return "負け";
        }
    }

    private JButton createButton(String s){
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.addActionListener(this);
        b.setBackground(Color.LIGHT_GRAY);
        b.setOpaque(false);
        return b;
    }

    private JButton createButton(String s, float align){
        JButton b = createButton(s);

        b.setAlignmentX(align);
        return b;
    }
}

public class JankenTest {
    public static void main(String[] args){
        JFrame f = new JankenFrame();
        f.setVisible(true);
    }
}
