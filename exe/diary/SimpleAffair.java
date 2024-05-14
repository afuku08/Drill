/* Affairの単純な実装 */
class SimpleAffair implements Affair,Cloneable {
    private int hour,minute;
    private java.lang.String what,where,who;

    /* SimpleAffair コンストラクタコメント */
    public SimpleAffair(int hh, int mm, String what, String where, String who) {
        hour = hh;
        minute = mm;
        this.what = what;
        this.where = where;
        this.who = who;
    }

    /* 重要事項の文字列を与える */
    /* @return java.lang.String　重要事項 */
    public String getAffairString() {
        String s = getWhen() + " ";
        s += (what == null ? "" : what + " ");
        s += (where == null ? "" : where + " ");
        s += (who == null ? "" : who);
        return s;
    }

    /* 「何を」を取り出す */
    /* @return java.lang.String　「何を」重要事項の主要項目 */
    public String getWhat() {
        return what;
    }

    /* 時刻を取り出す（文字列表現　"hh：mm"形式） */
    /* @return java.lang.String */
    public String getWhen() {
        return ("" + hour + ":" + minute);
    }

    /* 時刻を整数型配列にて取り出す */
    /* @return int[] ｛時，分} */
    public int[] getWheninInt() {
        return (new int[] {hour,minute});
    }

    /* 時刻を0時0分を起点とする分で与える */
    /* @return int　分で換算した時刻 */
    public int getWheninMinute() {
        return (60*hour + minute);
    }

    /* 場所を取り出す */
    /* @return java.lang.String　場所 */
    public String getWhere() {
        return where;
    }

    /* 「誰と」を取り出す */
    /* @return java.lang.String　相手 */
    public String getWho() {
        return who;
    }

    /* 「何を」を設定する */
    /* @param item java.lang.String　何 */
    public void setWhat(String item) {
        what = item;
    }

    /* 時刻を設定する */
    /* @param h int */
    /* @param m int */
    public void setWhen(int h, int m) {
        hour = h;
        minute = m;
    }

    /* 場所を設定する */
    /* @param place java.lang.String　場所 */
    public void setWhere(String place) {
        where = place;
    }

    /* 「誰と」を設定する */
    /* @param person java.lang.String　誰 */
    public void setWho(String person) {
        who = person;
    }

    /* String演算＋用　文字列変換メソッド */
    /* @return java.lang.String */
    public String toString() {
        return getAffairString();
    }

    /* Affair オブジェクトのクローン生成 */
    /* @return java.lang.Object */
    public Object clone() {
        try {
            SimpleAffair a = (SimpleAffair)super.clone();
            a.who = new String(who);
            a.where = new String(where);
            a.what = new String(what);
            return a;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    /* Affairオブジェクトのコピーを生成する */
    /* @return Affair */
    public Affair makeCopy() {
        return (Affair)clone();
    }
}