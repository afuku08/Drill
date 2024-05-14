import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GridLayoutFrame2 extends BaseFrame implements ActionListener {
    GridLayoutFrame2() {
        super("GridLayout Test 2", 0.4,0.2,0.2,0.2);
        addWindowListener(new WindowTerminator());

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,7,3,3));
        for(int i=1;i<=35;++i){
            p.add(createButton(""+i));
        }
        p.setBackground(Color.WHITE);

        Container c = getContentPane();
        c.add(p);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        JButton b = (JButton)e.getSource();
        if(b.isOpaque()){
            b.setOpaque(false);
            b.setText(s);
        }else{
            b.setOpaque(true);
            b.setText(s+"!");
        }
        repaint();
    }

    private JButton createButton(String s){
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.setBackground(Color.LIGHT_GRAY);
        b.setOpaque(false);
        b.addActionListener(this);
        return b;
    }
}

public class GridLayoutFrameTest2 {
    public static void main(String[] args){
        JFrame f = new GridLayoutFrame2();
        f.setVisible(true);
    }
}
