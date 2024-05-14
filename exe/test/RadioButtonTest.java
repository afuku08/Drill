import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RadioButtonFrame extends BaseFrame implements ActionListener {
    JRadioButton small,medium,large,exlarge;
    static final String cmdSmall = "Small";
    static final String cmdMedium = "Medium";
    static final String cmdLarge = "Large";
    static final String cmdExlarge = "Ex Large";
    ButtonGroup group;
    JTextArea ta;
    JScrollPane scroll;

    RadioButtonFrame() {
        super("Test for Scroll and RadioButton.", 0.3,0.3,0.2,0.2);
        setBackground(Color.WHITE);
        addWindowListener(new WindowTerminator());

        ta = new JTextArea(12,40);
        scroll = new JScrollPane(ta);
        group = new ButtonGroup();
        JPanel p = new JPanel();
        small = addRadioButton(cmdSmall,p,group,this);
        medium = addRadioButton(cmdMedium,p,group,this);
        large = addRadioButton(cmdLarge,p,group,this);
        exlarge = addRadioButton(cmdExlarge,p,group,this);

        ta.setFont(new Font("SansSerif",Font.PLAIN,14));
        Container c = getContentPane();
        c.add(scroll,BorderLayout.CENTER);
        c.add(p,BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        int size = 14;
        String cmd = group.getSelection().getActionCommand();
        if( cmd.equals(cmdSmall) ) size = 8;
        else if( cmd.equals(cmdMedium) ) size = 14;
        else if( cmd.equals(cmdLarge) ) size = 20;
        else if( cmd.equals(cmdExlarge) ) size = 25;

        ta.setFont(new Font("SansSerif",Font.PLAIN,size));
        ta.repaint();
    }

    JRadioButton addRadioButton(String cmd,JPanel p,ButtonGroup g,ActionListener act){
        JRadioButton b = new JRadioButton(cmd);
        p.add(b);
        g.add(b);
        b.addActionListener(act);
        b.setActionCommand(cmd);
        return b;
    }
}

public class RadioButtonTest {
    public static void main(String[] arg) {
        JFrame f = new RadioButtonFrame();
        f.setVisible(true);
    }
}
