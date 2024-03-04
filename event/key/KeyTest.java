import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeyPanel extends JPanel implements KeyListener {
    public KeyPanel() {
        /* KeyListenerを登録する */
        addKeyListener(this);

        /* 背景色は白 */
        setBackground(Color.WHITE);
    }

    /* パネルは通常キー入力を受けつけないようになっている */
    /* そのため次のisFocusable()でtrueを戻すとキー入力を受けつけられる */
    public boolean isFocusable() {
        return true;
    }

    /* KeyListener Key Press 時メソッド */
    /* @param ev java.awt.event.KeyEvent イベント */
    public void keyPressed(KeyEvent ev) {
        reportKey("keyPressed",ev);
    }

    /* KeyListener Key Release時メソッド */
    /* @param ev java.awt.event.KeyEvent イベント */
    public void keyReleased(KeyEvent ev) {
        reportKey("keyReleased",ev);
    }

    /* KeyListener Key Type 時メソッド */
    /* @param ev java.awt.event.KeyEvent イベント */
    public void keyTyped(KeyEvent ev) {
        reportKey("keyTyped",ev);
    }

    /* Key イベント報告用メソッド */
    /* @param proc java.lang.String リスナーの手続き */
    /* @param ev java.awt.event.KeyEvent イベント */
    private void reportKey(String proc, KeyEvent ev) {
        String shift = ( ev.isShiftDown() ?  "ON" : "OFF" );
        int code = ev.getKeyCode();
        char ch = ev.getKeyChar();
        System.out.println(proc + " Key Char : " + ch +
                            " Key Code :" + code + " Shift : " + shift);
    }
}

class KeyFrame extends JFrame {
    KeyFrame() {
        setTitle("Key Input Test.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        getContentPane().add(new KeyPanel());
    }
}

public class KeyTest {
    public static void main(String[] args) {
        JFrame f = new KeyFrame();
        f.setVisible(true);
    }
}
