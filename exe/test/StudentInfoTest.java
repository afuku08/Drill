import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.text.*;

class Student {
    int no;
    String name;
    String address;
    int englishscore;
    int mathscore;
    int japanesescore;

    Student(){}

    Student(int no, String name, String address, int es,int ms,int js){
        this.no = no;
        this.name = name;
        this.address = address;
        this.englishscore = es;
        this.mathscore = ms;
        this.japanesescore = js;
    }

    public void setNo(int no){
        this.no = no;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String ad){
        this.address = ad;
    }
    public void setes(int es){
        this.englishscore = es;
    }
    public void setms(int ms){
        this.mathscore = ms;
    }
    public void setjs(int js){
        this.japanesescore = js;
    }
}

class Convert {
    private static final DecimalFormat df = new DecimalFormat();

    public static double atod(String str) {
        double x;
        try {
            Number n = getNumber(str);
            x = n.doubleValue();
        } catch(ParseException a) {
            x = 0.0;
        }
        return x;
    }
    public static float atof(String str) {
        float x;
        try {
            Number n = getNumber(str);
            x = n.floatValue();
        } catch(ParseException a) {
            x = 0.0F;
        }
        return x;
    }
    public static int atoi(String str) {
        int x;
        try {
            Number n = getNumber(str);
            x = n.intValue();
        } catch(ParseException a) {
            x = 0;
        }
        return x;
    }
    public static long atol(String str) {
        long x;
        try {
            Number n = getNumber(str);
            x = n.longValue();
        } catch(ParseException a) {
            x = 0L;
        }
        return x;
    }
    private static Number getNumber(String str) throws ParseException {
        return df.parse(str.trim());
    }
}

class BaseFrame extends JFrame {
    BaseFrame(String title,double high,double width,double down,double right) {
        setTitle(title);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * high),(int)(d.height * width));
        setLocation((int)(d.width * down), (int)(d.height * right));
        Image jimg = t.getImage("./javaex.jpg");
        setIconImage((jimg));
    }
}

class StudentDialog extends JDialog implements ActionListener {
    private Container mycontentPane = getContentPane();
    private JTextField no = new JTextField(4);
    private JTextField name = new JTextField(4);
    private JTextField addres = new JTextField(4);
    private JTextField englishscore = new JTextField(4);
    private JTextField mathscore = new JTextField(4);
    private JTextField japanesescore = new JTextField(4);
    private JLabel noLabel = new JLabel("番号：");
    private JLabel nameLabel = new JLabel("名前：");
    private JLabel addresLabel = new JLabel("住所：");
    private JLabel esLabel = new JLabel("英吾の得点：");
    private JLabel msLabel = new JLabel("数学の得点");
    private JLabel jsLabel = new JLabel("国語の得点");
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Cancel");
    private boolean status = false;

    StudentDialog(JFrame parent){
        super(parent,"Edit",true);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.25),(int)(d.height * 0.25));

        JPanel itempanel = new JPanel();
        itempanel.setLayout((new GridLayout(6,1)));

        Container nocont = Box.createHorizontalBox();
        nocont.add(noLabel);
        nocont.add(no);
        Container namecont = Box.createHorizontalBox();
        namecont.add(nameLabel);
        namecont.add(name);
        Container addrescont = Box.createHorizontalBox();
        addrescont.add(addresLabel);
        addrescont.add(addres);
        Container escont = Box.createHorizontalBox();
        escont.add(esLabel);
        escont.add(englishscore);
        Container mscont = Box.createHorizontalBox();
        mscont.add(msLabel);
        mscont.add(mathscore);
        Container jscont = Box.createHorizontalBox();
        jscont.add(jsLabel);
        jscont.add(japanesescore);

        itempanel.add(nocont);
        itempanel.add(namecont);
        itempanel.add(addrescont);
        itempanel.add(escont);
        itempanel.add(mscont);
        itempanel.add(jscont);
        JPanel okppanel = new JPanel();
        okppanel.add(okButton);
        okppanel.add(cancelButton);
        itempanel.add(okppanel);

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        mycontentPane.add(itempanel,BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        Object ob = e.getSource();
        if(ob == okButton){
            status = true;
            setVisible(false);
        }else if(ob == cancelButton){
            status = false;
            setVisible(false);
        }
    }

    private void getStudentInfo(Student s){
        s.setNo(Convert.atoi(no.getText()));
        s.setName(name.getText());
        s.setAddress(addres.getText());
        s.setes(Convert.atoi(englishscore.getText()));
        s.setms(Convert.atoi(mathscore.getText()));
        s.setjs(Convert.atoi(japanesescore.getText()));
    }

    public boolean showStudentDialog(Student s){
        status = false;
        setVisible(true);
        if(status){
            getStudentInfo(s);
        }
        return status;
    }
}

class StudentInfoFrame extends BaseFrame implements ActionListener{
    private StudentDialog sd;

    StudentInfoFrame(){
        super("This is Student Infometion Frame",0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());

        sd = new StudentDialog(this);

        JPanel p = new JPanel(new BorderLayout());
        p.add(createButton("INPUT"));

        Container c = getContentPane();
        c.add(p);
    }

    private JButton createButton(String s){
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.addActionListener(this);
        b.setBackground(Color.GREEN);
        return b;
    }

    public void actionPerformed(ActionEvent e){
        Student s = new Student();
        if(sd.showStudentDialog(s)){
            /*何かしらの処理を行う */
        };
        
        repaint();
    }
}


public class StudentInfoTest {
    public static void main(String[] args){
        JFrame f = new StudentInfoFrame();
        f.setVisible(true);
    }
}
