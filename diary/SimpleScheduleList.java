public class SimpleScheduleList implements ScheduleList{
    private final int MAX_AFFAIRS = 12;
    private Affair[] affairs;

    public SimpleScheduleList(){
        affairs = new Affair[MAX_AFFAIRS];
    }

    public void addAffair(Affair a){
        boolean done = false;
        for(int i=0; !done && i<affairs.length; ++i){
            if(affairs[i] == null){
                affairs[i] = a;
                done = true;
            }
        }
    }

    public ObjectIteration createIteration(){
        return new SimpleScheduleIteration(affairs);
    }

    public Affair getAffair(int hh,int mm){
        ObjectIteration oi = createIteration();
        Affair a;
        int time = hh*60 + mm;
        while(oi.hasNext()){
            a = (Affair)oi.next();
            if(time == a.getWheninMinute()){
                return a;
            }
        }
        return null;
    }

    public void removeAffair(Affair a){
        boolean done = false;
        for(int i=0; !done && i<affairs.length; ++i){
            if(affairs[i] == a){
                affairs[i] = null;
                done = true;
            }
        }
    }

    public String toString(){
        String s = "";
        String separator = System.getProperty("line.separator");
        ObjectIteration oi = createIteration();
        Affair a;

        while(oi.hasNext()){
            a = (Affair)oi.next();
            s += (a + separator);
        }
        return s;
    }
}

class SimpleScheduleIteration implements ObjectIteration {
    private Affair[] affairs;
    private int nxt;
    public SimpleScheduleIteration(Affair[] af) {
        affairs = new Affair[af.length];

        java.util.Arrays.fill(affairs, null);
        int i, j;
        for(i=j=0; i<af.length;++i){
            if(af[i] != null) affairs[j++] = af[i];
        }
        nxt = 0;
    }

    public boolean hasNext(){
        return (nxt < affairs.length && affairs[nxt] != null);
    }

    public Object next(){
        return affairs[nxt++];
    }
}
