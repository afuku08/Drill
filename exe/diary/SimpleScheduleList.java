/* ScheduleListの単純な実装 */
class SimpleScheduleList implements ScheduleList,Cloneable {
    private final int MAX_AFFAIRS = 12;
    private Affair[] affairs;

    /* SimpleScheduleList コンストラクタコメント */
    public SimpleScheduleList() {
        affairs = new Affair[MAX_AFFAIRS];
    }

    /* その日の重要事項をスケジュール・リストに追加する */
    /* @param a Affair　追加する重要事項 */
    public void addAffair(Affair a) {
        boolean done = false;
        for( int i = 0; !done && i < affairs.length; ++i ) {
            if( affairs[i] == null ) {
                affairs[i] = a;
                done = true;
            }
        }
    }

    /* スケジュール・リスト中の重要事項の反復子を作る */
    /* @return ObjectIteration　重要事項の反復子 */
    public ObjectIteration createIteration() {
        return new SimpleScheduleIteration(affairs);
    }

    /* 時刻で指定された重要事項を取り出す */
    /* @param hh  int 時 */
    /* @param mm  int 分 */
    public Affair getAffair(int hh, int mm) {
        ObjectIteration it = createIteration();
        Affair a;
        int time = hh * 60 + mm;

        while( it.hasNext() ) {
            a = (Affair)it.next();
            if( time == a.getWheninMinute() ) return a;
        }
        return null;
    }

    /* 指定された重要事項をスケジュール・リストから削除する */
    /* @param a Affair　削除対象の重要事項 */
    public void removeAffair(Affair a) {
        boolean done = false;
        for( int i = 0; !done && i < affairs.length; ++i ) {
            if( affairs[i] == a ) {
                affairs[i] = null;
                done = true;
            }
        }
    }

    /* String演算＋用　文字列変換メソッド */
    /* @return java.lang.String */
    public String toString() {
        String s = "";
        String separator = System.getProperty("line.separator");
        ObjectIteration i = createIteration();
        Affair a;

        while( i.hasNext() ) {
            a = (Affair)i.next();
            s += (a + separator);
        }
        return s;
    }

    /* SimpleScheduleListのクローン生成 */
    /* @return java.lang.Object */
    public Object clone() {
        try {
            SimpleScheduleList sl = (SimpleScheduleList)super.clone();
            sl.affairs = (Affair[])affairs.clone();
            for( int i = 0; i < affairs.length; ++i ) {
                if( affairs[i] != null ) {
                    sl.affairs[i] = affairs[i].makeCopy();
                }
            }
            return sl;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    /* SimpleScheduleListのコピーを生成する */
    /* @return java.lang.Object */
    public ScheduleList makeCopy() {
        return (ScheduleList)clone();
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