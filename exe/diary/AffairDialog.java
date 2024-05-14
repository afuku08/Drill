import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AffairDialog extends JDialog implements ActionListener {
        private Container mycontentPane = getContentPane();
        private JTextField hour = new JTextField(4);
        private JTextField minute = new JTextField(4);
        private JTextField what = new JTextField(30);
        private JTextField where  = new JTextField(30);
        private JTextField who = new JTextField(30);
        private JLabel hourLabel  = new JLabel(" 時：");
        private JLabel minuteLabel  = new JLabel(" 分：");
        private JLabel whatLabel  = new JLabel("用件：");
        private JLabel whereLabel  = new JLabel("場所：");
        private JLabel whoLabel = new JLabel("誰と：");
        private JButton okButton = new JButton("OK");
        private JButton cancelButton = new JButton("Cancel");
        private boolean status = false;

    AffairDialog(JFrame parent) {
        super(parent,"Edit Affair",true);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.20),(int)(d.height * 0.2));

        JPanel itempanel = new JPanel();
        itempanel.setLayout(new GridLayout(5,1));

        Container timecont = Box.createHorizontalBox();
        timecont.add(hourLabel);
        timecont.add(hour);
        timecont.add(minuteLabel);
        timecont.add(minute);

        Container whatcont = Box.createHorizontalBox();
        whatcont.add(whatLabel);
        whatcont.add(what);
        Container wherecont = Box.createHorizontalBox();
        wherecont.add(whereLabel);
        wherecont.add(where);
        Container whocont = Box.createHorizontalBox();
        whocont.add(whoLabel);
        whocont.add(who);
        JPanel okpanel = new JPanel();
        okpanel.add(okButton);
        okpanel.add(cancelButton);

        itempanel.add(timecont);
        itempanel.add(whatcont);
        itempanel.add(wherecont);
        itempanel.add(whocont);
        itempanel.add(okpanel);

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        mycontentPane.add(itempanel,BorderLayout.CENTER);
    }

    private void setAffair(Affair a) {
        int[] tim = a.getWheninInt();
        hour.setText(""+tim[0]);
        minute.setText(""+tim[1]);
        what.setText(a.getWhat());
        where.setText(a.getWhere());
        who.setText(a.getWho());
    }

    private void getAffair(Affair a) {
        a.setWhen(Convert.atoi(hour.getText()),Convert.atoi(minute.getText()));
        a.setWhat(what.getText());
        a.setWhere(where.getText());
        a.setWho(who.getText());
    }

    public void actionPerformed(ActionEvent ev) {
        Object ob = ev.getSource();
        if(ob == okButton) {
            status = true;
            setVisible(false);
        } else if(ob == cancelButton) {
            status = false;
            setVisible(false);
        }
    }

    public boolean showAffairDialog(Affair a) {
        setAffair(a);
        status = false;
        setVisible(true);
        if(status) {
            getAffair(a);
        }
        return status;
    }
}