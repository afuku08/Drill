public  interface ClockMethods {
    static final int START_CLOCK   = 1;
    static final int STOP_CLOCK    = 2;
    static final int TICK_CLOCK    = 3;
    static final int RESET_CLOCK   = 4;
    static final int DEFAULT_CLOCK = 5;

    /* 時計の動きを開始させる */
    public void startClock();

    /* 時計の動きを停止させる */
    public void stopClock();

    /* イベントを受けて現在時刻を進める */
    public void tickClock();

    /* 時計をリセットする（0時0分0秒にあわせる） */
    public void resetClock();

    /* 時計をシステム時刻にあわせる */
    public void defaultClock();

    /* 時計の時刻を与えられた時分秒にあわせる */
    public void setTime(Time t);

    /* 現在時刻を取り出す */
    public void getTime(Time t);

    /* 時計の表示用オブジェクトを設定する */
    public void setViewer(Object viewer);
}