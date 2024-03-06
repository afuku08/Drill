public class Time {
    /*  */
    public int hour;
    /* •ª */
    public int minute;
    /* •b */
    public int second;
    
    Time(int h,int m,int s) {
        hour = h;
        minute = m;
        second = s;
    }

    /* ‚ğİ’è‚·‚é */
    public synchronized void setTime(Time cp) {
        hour = cp.hour;
        minute = cp.minute;
        second = cp.second;
    }

    /* ‚ğæ‚èo‚· */
    public synchronized void getTime(Time cp) {
        cp.hour = hour;
        cp.minute = minute;
        cp.second = second;
    }
}