import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

class KeyTypeTestPanel extends JPanel{
    private String random = RandomStringGenerator();
    private String input = "";
    private Font f = new Font("SansSerif", Font.BOLD, 24);
    private FontMetrics fm;
    private boolean isInputCorrect = true;
    private int stringNum = 0;

    public KeyTypeTestPanel() {
        setBackground(Color.WHITE);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if(isInputCorrect && stringNum < 4) {
                    input += event.getKeyChar();
                    if(input.charAt(stringNum) != random.charAt(stringNum)){
                        isInputCorrect = false;
                        input += "　間ちがえました。";
                    }else{
                        if(stringNum == 3){
                            input += "　正解です。";
                        }
                        stringNum++;
                    }
                }
                
                repaint();
            }
        });
    }

    public boolean isFocusable() {
        return true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics g2 = g.create();
        if(fm == null){
            fm = g2.getFontMetrics(f);
        }

        Dimension d = getSize();
        g.setFont(f);

        int height = fm.getHeight();
        int cx;
        int cy = d.height/2;
        String s;

        s = "この文字列を入力してください：" + random;
        cx = (d.width - fm.stringWidth(s))/2;
        g.drawString(s, cx, cy);
        cy += height;

        s = input;
        g.drawString(s, cx, cy);
    }

    String RandomStringGenerator(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int length = 4;

        for(int i=0; i<length; i++){
            char randomChar = (char)('a' + random.nextInt(26));
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}

class KeyTypeTestFrame extends JFrame{
    KeyTypeTestFrame() {
        setTitle("Key Input Test.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        getContentPane().add(new KeyTypeTestPanel());
    }
}

public class KeyTypeTest {
    public static void main(String[] args){
        JFrame f = new KeyTypeTestFrame();
        f.setVisible(true);
    }
}
