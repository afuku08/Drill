import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

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

class MenuFrame extends BaseFrame implements ActionListener{
    JTextArea ta;

    MenuFrame(){
        super("Test of Scroll and Menu",0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());

        JMenuBar menuBar = new JMenuBar();

        JMenu editMenu = new JMenu("編集");
        JMenuItem openItem = creatJMenuItem("開く");
        JMenuItem saveItem = creatJMenuItem("保存");
        JMenuItem exitItem = creatJMenuItem("終了");

        editMenu.add(openItem);
        editMenu.add(saveItem);
        editMenu.add(exitItem);

        menuBar.add(editMenu);

        Container c = getContentPane();
        c.add(menuBar,BorderLayout.NORTH);

        ta = new JTextArea();
        JScrollPane scroll = new JScrollPane(ta);
        c.add(scroll);
    }

    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        try{
            if(action.equals("開く")){
                FileReader fr = new FileReader("./Sample.txt");
                BufferedReader br = new BufferedReader(fr);
                String txt = "";
                String tmp = "";
                while((tmp = br.readLine()) != null){
                    txt += tmp + "\n";
                }
                ta.setText(txt);
                repaint();
            }else if(action.equals("保存")){
                String txt = ta.getText();
                FileWriter fw = new FileWriter("./Sample.txt");
                PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
                pw.write(txt + "\n");
                pw.flush();
    
            }else if(action.equals("終了")){
                System.exit(0);
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
        
    }

    private JMenuItem creatJMenuItem(String s){
        JMenuItem mi = new JMenuItem(s);
        mi.setActionCommand(s);
        mi.addActionListener(this);
        return mi;
    }
}

public class MenuTest{
    public static void main(String[] args){
        JFrame f = new MenuFrame();
        f.setVisible(true);
    }
}
