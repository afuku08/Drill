import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GridLayoutFrame extends BaseFrame implements ActionListener {
    GridLayoutFrame() {
        super("GridLayout Test", 0.4, 0.4, 0.2, 0.2);
        addWindowListener(new WindowTerminator());

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,8,3,3));
        for(int i=1;i<=40;++i){
            p.add(createButton(""+i));
        }
        p.setBackground((Color.WHITE));

        Container c = getContentPane();
        c.add(p);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        JButton b = (JButton)e.getSource();
        if(b.isOpaque()) {
            b.setOpaque(false);
            b.setText(s);
        } else {
            b.setOpaque(true);
            b.setText(s + "!");
        }
        repaint();
    }

    private JButton createButton(String s) {
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.setBackground(Color.LIGHT_GRAY);
        b.setOpaque(false);
        b.addActionListener(this);
        return b;
    }
}
public class GridLayoutTest {
    public static void main(String[] args){
        JFrame f = new GridLayoutFrame();
        f.setVisible(true);
    }
}
