/* スケジュールリストインターフェイス */
/* @author: */
interface ScheduleList extends java.io.Serializable {

    /* その日の重要事項をスケジュールリストに追加する */
    /* @param a Affair 追加する重要事項 */
    void addAffair(Affair a);

    /* スケジュールリスト中の重要事項の反復子を作る */
    /* @return ObjectIteration 重要事項の反復子 */
    ObjectIteration createIteration();

    /* 時刻で指定された重要事項を取り出す */
    /* @param hh int 時 */
    /* @param mm int 分 */
    Affair getAffair(int hh,int mm);

    /* 指定された重要事項をスケジュールリストから削除する */
    /* @param a Affair 削除対象の重要事項 */
    void removeAffair(Affair a);

    /*ScheduleListオブジェクトのコピーを生成する */
    /*@return ScheduleList */
    ScheduleList makeCopy();
}