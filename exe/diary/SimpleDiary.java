public class SimpleDiary implements Diary{
    private Affair primaryAffair;
    private ScheduleList schedule;
    private Memo memo;
    private Day day;

    public SimpleDiary(){
    }

    public SimpleDiary(Day d,Affair a, ScheduleList sl, Memo m){
        day = d;
        schedule = sl;
        memo = m;
        primaryAffair = a;
    }

    public Day getDay(){
        return day;
    }

    public Memo getMemo(){
        return memo;
    }

    public Affair getPrimaryAffair(){
        return primaryAffair;
    }

    public ScheduleList getScheduleList(){
        return schedule;
    }

    public void setDay(Day d){
        day = d;
    }

    public void setMemo(Memo m){
        memo = m;
    }

    public void setPrimaryAffair(Affair a){
        primaryAffair = a;
    }

    public void setScheduleList(ScheduleList sl){
        schedule = sl;
    }

    public String toString(){
        String s = "";
        String separator = System.getProperty("line.separator");
        if(day != null) s += ("年月日：" + day + separator);
        if(primaryAffair != null) s += ("重要事項：" + primaryAffair + separator);
        if(memo != null) s += ("メモ：" + memo + separator);
        if(schedule != null) s += ("その日のスケジュール" + separator + schedule);

        return s;
    }

    public Object clone(){
        try{
            SimpleDiary sd = (SimpleDiary)super.clone();
            if(day != null) sd.day = day.makeCopy();
            if(memo != null) sd.memo = memo.makeCopy();
            if(primaryAffair != null) sd.primaryAffair = primaryAffair.makeCopy();
            if(schedule != null) sd.schedule = schedule.makeCopy();
            return sd;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

    public Diary makeCopy(){
        return (Diary)clone();
    }

    public Affair createNewAffair(){
        return new SimpleAffair(0, 0, "", "", "");
    }
}
