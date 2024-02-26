import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* ボタンテスト用フレーム */
/* 主要な処理は、ButtonTestPanelにて行われる */
class ButtonTestFrame extends JFrame {
    ButtonTestFrame() {
        setTitle("This is a Button Test.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        getContentPane().add(new ButtonTestPanel());
    }
}
