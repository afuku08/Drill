import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TickTackToe extends BaseFrame implements ActionListener{
    ImageIcon maru = new ImageIcon("./maru.png");
    ImageIcon batu = new ImageIcon("./batu.png");
    JButton[] buttons = new JButton[9];
    boolean[] isUsed = new boolean[9];
    int[][] ans = {{0,3,6},{1,4,7},{2,5,8},{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};

    TickTackToe(){
        super("○×ゲーム", 0.4, 0.4, 0.2, 0.2);
        addWindowListener(new WindowTerminator());
        JPanel p = new JPanel();
        p.setBackground(Color.white);
        p.setLayout(new GridLayout(3,3));
        for(int i=1;i<=9;++i){
            JButton b = createButton(""+i);
            p.add(b);
            buttons[i-1] = b;
            isUsed[i-1] = false;
        }

        Container c = getContentPane();
        c.add(p);
    }

    public void actionPerformed(ActionEvent e){
        int num = Integer.parseInt(e.getActionCommand());
        JButton b = (JButton)e.getSource();
        b.setIcon(maru);
        b.setEnabled(false);
        b.setText("");
        b.setActionCommand("me");
        //b.setBackground(Color.BLUE);
        isUsed[num-1] = true;
        if(judgeWin()){
            return;
        }
        enemyAction();
        if(judgeWin()){
            return;
        }
        repaint();
    }

    private void enemyAction(){
        int buttonNum = 0;
        for(int i=0;i<9;i++){
            if(!isUsed[i]){
                buttonNum = i;
                break;
            }
        }
        buttons[buttonNum].setActionCommand("enemy");
        buttons[buttonNum].setEnabled(false);
        buttons[buttonNum].setIcon(batu);
        buttons[buttonNum].setText("");
        //buttons[buttonNum].setBackground(Color.RED);
        isUsed[buttonNum] = true;
    }

    private boolean judgeWin(){
        boolean completed = false;

        for(int i=0;i<ans.length;++i){
            String s1 = buttons[ans[i][0]].getActionCommand();
            String s2 = buttons[ans[i][1]].getActionCommand();
            String s3 = buttons[ans[i][2]].getActionCommand();
            if(s1.equals(s2) && s2.equals(s3)){
                completed = true;
            }
            if (completed) break;
        }
        return completed;
    }

    private JButton createButton(String s){
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.addActionListener(this);
        b.setBackground(Color.WHITE);
        return b;
    }
}

public class TickTackToeTest {
    public static void main(String[] args){
        JFrame f = new TickTackToe();
        f.setVisible(true);
    }
}
