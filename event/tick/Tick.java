import java.awt.*;
import java.awt.event.*;

class Tick extends Component implements Runnable {
    private static final EventQueue eq 
        = Toolkit.getDefaultToolkit().getSystemEventQueue();
    private Thread mythread;
    private int interval;
    private ActionListener listener;

    Tick(int i) {
        interval = i;
        enableEvents(AWTEvent.ACTION_EVENT_MASK);
        mythread = new Thread(this);
        mythread.start();
    }

    void addActionListener(ActionListener l) {
        listener = l;
    }

    public void processEvent(AWTEvent evt) {
        if(evt instanceof TickEvent ) {
            if(listener != null) listener.actionPerformed((TickEvent)evt);
        } else {
            super.processEvent(evt);
        }
        }
    void interrupt() {
        if( mythread != null ) mythread.interrupt();
    }
    public void run() {
        for( ;; ) {
            try {
                Thread.sleep(interval);
            } catch(InterruptedException e) {
                mythread = null;
                return;
            }
            eq.postEvent(new TickEvent(this));
        }
    }
}