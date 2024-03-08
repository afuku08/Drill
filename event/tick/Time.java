public class Time {
    /* 時 */
    public int hour;
    /* 分 */
    public int minute;
    /* 秒 */
    public int second;
    
    Time(int h,int m,int s) {
        hour = h;
        minute = m;
        second = s;
    }

    /* 時刻を設定する */
    public synchronized void setTime(Time cp) {
        hour = cp.hour;
        minute = cp.minute;
        second = cp.second;
    }

    /* 時刻を取り出す */
    public synchronized void getTime(Time cp) {
        cp.hour = hour;
        cp.minute = minute;
        cp.second = second;
    }
}