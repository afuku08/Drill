import java.awt.*;
import java.util.*;

public class Clock implements ClockMethods{
    private Time t = new Time(0, 0, 0);
    private Tick tk;
    private ClockAction ca;
    private Component comp;
    
    public Clock(){
        adjustTime();
    }

    public void setViewer(Object c){
        comp = (Component)c;
    }

    public void startClock(){
        if(tk == null) {
            ca = new ClockAction("Tick", ClockMethods.TICK_CLOCK, this);
            tk = new Tick(1000);
            tk.addActionListener(ca);
        }
        repaint();
    }

    public void stopClock(){
        if(tk != null){
            tk.interrupt();
            tk = null;
        }
        repaint();
    }

    public void resetClock(){
        setTime(new Time(0, 0, 0));
        repaint();
    }

    public void defaultClock(){
        adjustTime();
        repaint();
    }

    public void tickClock(){
        synchronized(t){
            if(++t.second >= 60){
                t.second = 0;
                if(++t.minute >= 60){
                    t.minute = 0;
                    if(++t.hour >= 24){
                        t.hour = 0;
                    }
                }
            }
        }
        repaint();
    }

    private void adjustTime(){
        Calendar d = Calendar.getInstance();
        synchronized(t){
            t.hour = d.get(Calendar.HOUR_OF_DAY);
            t.minute = d.get(Calendar.MINUTE);
            t.second = d.get(Calendar.SECOND);
        }
    }

    public void getTime(Time gt) {
        t.getTime(gt);
        return;
    }

    public void setTime(Time tm){
        t.setTime(tm);
    }

    private void repaint(){
        comp.repaint();
    }
}
