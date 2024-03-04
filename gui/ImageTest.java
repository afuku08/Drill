import java.awt.*;
import javax.swing.*;


class ImagePanel extends JPanel {
    Image  i;

    public ImagePanel(Image ii) {
        super();
        i = ii;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = getSize();
        int panelWidth = d.width;
        int panelHeight = d.height;
        int imageWidth = i.getWidth(this);
        int imageHeight = i.getHeight(this);

        g.drawImage(i,0,0,this);
        if( imageWidth < panelWidth && imageHeight < panelHeight ) {
            double rate = ((double)(panelHeight) / (double)(imageHeight)) / 2;
            g.drawImage(i,imageWidth,imageHeight,
            (int)(imageWidth * rate),(int)(imageHeight * rate),this);
            g.drawImage(i,0,(int)((1 + rate)*imageHeight),
            panelWidth,(int)(panelHeight - ((1 + rate)*imageHeight)), this);
        }
    }
}

class ImageFrame extends JFrame {
    int imageId = 1;

    ImageFrame() {
        addWindowListener(new WindowTerminator());
        setTitle("This is an Image Frame.");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();

        setSize((int)(d.width * 0.8),(int)(d.height * 0.8));

        MediaTracker track = new MediaTracker(this);
        Image bufImage = t.getImage("./logo.jpg");
        track.addImage(bufImage,imageId);
        try {
            track.waitForID(imageId);
        } catch(InterruptedException e) {
        }

        setIconImage(bufImage);
        getContentPane().add(new ImagePanel(bufImage));
    }
}

public class ImageTest {
    public static void main(String[] args) {
        JFrame f = new ImageFrame();
        f.setVisible(true);
    }
}