import java.util.*;

class MonthlyVolume implements Monthly,Cloneable{
    private int year = 0;
    private int month = 0;
    private int maxday = 0;
    private Diary[] diaries = new Diary[31];
    private GregorianCalendar calendar;
    private transient boolean changed = false;
    /*機能強化されたDayの実装 */
    private class EnhancedDay extends SimpleDay implements Cloneable{
        private EnhancedDay(int yy,int mm,int dd){
            super(yy,mm,dd);
        }

        EnhancedDay(int dd){
            this(MonthlyVolume.this.year,MonthlyVolume.this.month,dd);
        }

        /*自分専用のカレンダーを作る */
        private GregorianCalendar getMyCalendar(){
            GregorianCalendar c = getCalendar();
            c.set(calendar.DATE,super.getDay());
            return c;
        }

        /*1月1日を起点0とした日付順に関するインデックスを与える */
        /*@return int */
        public int getIndex(){
            GregorianCalendar c = getMyCalendar();
            return c.get(Calendar.DAY_OF_YEAR)-1;
        }

        /*曜日を取り出す */
        public int getNameofDay(){
            GregorianCalendar c = getMyCalendar();
            return c.get(Calendar.DAY_OF_WEEK)-1;
        }

        public Object clone(){
            return super.clone();
        }

        public Day makeCopy(){
            return (Day)clone();
        }
    }

    /*Diary実装の内部クラス */
    private class InternalDiary extends SimpleDiary implements Cloneable{
        InternalDiary(int day){
            if(day <= 0) day = 1;
            if(day > maxday) day = maxday;

            super.setScheduleList(new SimpleScheduleList());
            super.setPrimaryAffair(new SimpleAffair(0, 0, "", "", ""));
            super.setDay(new EnhancedDay(day));
            super.setMemo(new SimpleMemo(""));
        }

        public Object clone(){
            return super.clone();
        }

        public Diary makeCopy(){
            return (Diary)clone();
        }
    }

    /*内部クラス月間日記帳に関する反復子を生成する */
    private class MonthlyIteration implements ObjectIteration{
        private int current = 1;
        private int end = maxday;
        public MonthlyIteration(){

        }

        public boolean hasNext(){
            return (current <= end);
        }

        public Object next(){
            return getDiary(current++);
        }
    }

    private MonthlyVolume(){}

    public MonthlyVolume(int year, int month){
        this();
        this.year = year;
        this.month = month;
        calendar = new GregorianCalendar(year, month-1, 1);
        maxday = calendar.getMaximum(GregorianCalendar.DAY_OF_MONTH);
    }

    public static Monthly createMonthly(int year, int month){
        return (Monthly)new MonthlyVolume(year, month);
    }

    @Override
    public ObjectIteration createIteration(){
        return new MonthlyIteration();
    }

    @Override
    public Diary getDiary(int day) {
        if(day > 0 && day <= maxday){
            Diary d = diaries[day-1];
            if(d != null) return d.makeCopy();
        }
        return null;
    }

    @Override
    public void setDiary(int day, Diary d) {
        if(day > 0 && day <= maxday){
            diaries[day-1] = d;
            setEditState(true);
        }
    }

    @Override
    public Diary createNewDiary(int day) {
        Diary d = new InternalDiary(day);
        setDiary(day, d);
        return d.makeCopy();
    }

    @Override
    public GregorianCalendar getCalendar() {
        return (GregorianCalendar)calendar.clone();
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getYear() {
        return year;
    }

    public Object clone(){
        try{
            MonthlyVolume m = (MonthlyVolume)super.clone();
            m.diaries = (Diary[])diaries.clone();
            Diary d;
            for(int i=0;i<diaries.length;++i){
                d = m.diaries[i];
                if(d != null) m.diaries[i] = d.makeCopy();
            }
            return m;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public Monthly makeCopy() {
        return (Monthly)clone();
    }

    @Override
    public boolean getEditState() {
        return changed;
    }

    @Override
    public void setEditState(boolean changed) {
        this.changed = changed;
    }
    
}
