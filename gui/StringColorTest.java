import java.awt.*;
import javax.swing.*;

class StringColorPanel extends JPanel {
    private String color;

    /* Q1 Fontをインスタンス化して変数に保存するコードをここに追加 */

    StringColorPanel(String msg) {
        color = msg;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Q1 インスタンス化した Font に設定するコードをここに追加 */
        Font f = new Font("SansSerif",Font.ITALIC + Font.BOLD,24);
        g.setFont(f);
        /* Q2 コマンドラインで指定した色に変更するコードをここに追加 */
        if(color.equals("red")){
            g.setColor(Color.RED);
        }else if(color.equals("green")){
            g.setColor(Color.GREEN);
        }else if(color.equals("blue")){
            g.setColor(Color.BLUE);
        }else{
            color = "Sorry unknown color type";
        }

        g.drawString(color,75,100);
    }
}

class StringColorFrame extends JFrame {
    StringColorFrame(String msg) {
        addWindowListener(new WindowTerminator());
        setTitle("This is a StringColorTest.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width / 2,d.height / 2);
        setLocation(d.width / 4,d.height / 4);
        setIconImage(t.getImage("javaex.jpg"));
        getContentPane().add(new StringColorPanel(msg));
    }
}

public class StringColorTest {
    public static void main(String[] args) {
        if( args.length > 0 ) {
            JFrame f = new StringColorFrame(args[0]);
            f.setVisible(true);
        } else {
            System.out.println("usage : java StringColorTest <color>");
        }
    }
}