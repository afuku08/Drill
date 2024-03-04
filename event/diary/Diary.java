/* 日記インターフェイス */
interface Diary extends java.io.Serializable {

    /* 日付を取り出す */
    /* @return Day */
    Day getDay();

    /* メモを取り出す */
    /* @return Memo */
    Memo getMemo();

    /* その日の中心となる重要事項を取り出す */
    /* @return Affair */
    Affair getPrimaryAffair();

    /* スケジュールリストを取り出す */
    /* @return ScheduleList */
    ScheduleList getScheduleList();

    /* 日付を設定する */
    /* @param d Day */
    void setDay(Day d);

    /* メモを設定する */
    /* @param m Memo */
    void setMemo(Memo m);

    /* その日の中心となる重要事項を設定する */
    /* @param a Affair */
    void setPrimaryAffair(Affair a);

    /* スケジュールリストを設定する */
    /* @param sl ScheduleList */
    void setScheduleList(ScheduleList sl);
}