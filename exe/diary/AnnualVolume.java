import java.util.GregorianCalendar;

public class AnnualVolume implements Annual, Cloneable{
    private int year = 0;
    private int maxmonth = 12;

    private Monthly[] monthly = new Monthly[12];
    private GregorianCalendar calendar = null;
    private transient boolean changed = false;

    private class AnnualIteration implements ObjectIteration{
        private int current = 1;
        private int end = maxmonth;
        public AnnualIteration(){}
        public boolean hasNext(){
            return (current <= end);
        }
        public Object next(){
            return getMonthly(current++);
        }
    }

    private AnnualVolume(){}

    public AnnualVolume(int year){
        this();
        this.year = year;
        calendar = new GregorianCalendar(year, 0, 1);
        for(int i=1;i<=maxmonth;++i){
            monthly[i-1] = MonthlyVolume.createMonthly(year, i);
        }
    }

    public static Annual createAnnual(int year){
        return new AnnualVolume(year);
    }

    @Override
    public ObjectIteration createIteration() {
        return new AnnualIteration();
    }

    @Override
    public Diary getDiary(int month, int day) {
        if(month > 0 && month <= maxmonth){
            monthly[month-1].getDiary(day);
        }
        return null;
    }

    @Override
    public Monthly getMonthly(int month) {
        if(month > 0 && month <= maxmonth){
            return monthly[month-1];
        }else{
            return null;
        }
    }

    @Override
    public void setDiary(int month, int day, Diary d) {
        if(month > 0 && month <= maxmonth){
            Monthly m = monthly[month-1];
            m.setDiary(day, d);
            if(m.getEditState()) setEditState(true);
        }
    }

    @Override
    public void setMonthly(int month, Monthly m) {
        if(month > 0 && month <= maxmonth){
            monthly[month-1] = m;
            setEditState(true);
        }
    }

    @Override
    public GregorianCalendar getCalendar() {
        return (GregorianCalendar)calendar.clone();
    }

    @Override
    public boolean getEditState() {
        return changed;
    }

    @Override
    public int getYear() {
        return year;
    }

    public Object clone(){
        try{
            AnnualVolume a = (AnnualVolume)super.clone();
            a.monthly = (Monthly[])monthly.clone();
            for(int i=0;i<monthly.length;++i){
                if(monthly[i] != null){
                    a.monthly[i] = monthly[i].makeCopy();
                }else{
                    a.monthly[i] = null;
                }
            }
            return a;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public Annual makeCopy() {
        return (Annual)clone();
    }

    @Override
    public void setEditState(boolean changed) {
        this.changed = changed;
    }
    
}
