public class SimpleAffair implements Affair{
    private String who, where, what;
    private int hour, minute;

    public SimpleAffair(int hh, int mm, String what, String where, String who) {
        hour = hh;
        minute = mm;
        this.who = who;
        this.where = where;
        this.what = what;
    }

    public String getAffairString() {
        String s = getWhen() + " ";
        s += (what == null ? "" : what + " ");
        s += (where == null ? "" : where + " ");
        s += (who == null ? "" : who + " ");
        return s;
    }

    public void setWhat(String item) {
        what = item;
    }

    public void setWhen(int h, int m) {
        hour = h;
        minute = m;
    }

    public void setWhere(String place) {
        where = place;
    }

    public void setWho(String person) {
        who = person;
    }

    public String getWhat(){
        return what;
    }

    public String getWhen(){
        return (hour + ":" + minute);
    }

    public int[] getWheninInt(){
        return new int[]{hour, minute};
    }

    public int getWheninMinute(){
        return (60*hour + minute);
    }

    public String getWhere(){
        return where;
    }

    public String getWho(){
        return who;
    }

    public String toString() {
        return getAffairString();
    }
}
