import java.awt.*;
import javax.swing.*;

class ImagePanel2 extends JPanel {
    Image i;

    public ImagePanel2(Image ii) {
        i = ii;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = getSize();
        int panelWidth = d.width;               // ウィンドウの幅
        int panelHeight = d.height;             // ウィンドウの高さ
        int imageWidth = i.getWidth(this);      // 画像の幅
        int imageHeight = i.getHeight(this);    // 画像の高さ

        /*【解答が入る】*/
        g.drawImage(i, 0, 0, this);
        for(int w=0;w<panelWidth;w+=imageWidth){
            for(int h=0;h<panelHeight;h+=imageHeight){
                g.copyArea(0, 0, imageWidth, imageHeight, w, h);
            }
        }
    }
}

class ImageFrame2 extends JFrame {
    int imageId = 1;
    Image bufImage;

    ImageFrame2() {
        addWindowListener(new WindowTerminator());
        setTitle("This is an Image Frame 2.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.8),(int)(d.height * 0.8));
        MediaTracker track = new MediaTracker(this);
        Image bufImage = t.getImage("javaex.jpg");
        track.addImage(bufImage,imageId);
        try {
            track.waitForID(imageId);
        } catch(InterruptedException e) {
        }
        setIconImage(bufImage);
        getContentPane().add(new ImagePanel2(bufImage));
    }
}

public class ImageTest2 {
    public static void main(String [] args) {
        JFrame f = new ImageFrame2();
        f.setVisible(true);
    }
}