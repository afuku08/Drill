public interface Annual extends java.io.Serializable{

    /*その年の日記に関する反復子を生成する */
    /*@return ObjectIteration */
    ObjectIteration createIteration();

    /*月と日を指定して対応する日記を取り出す */
    /*@return Diary */
    /*@param day int */
    Diary getDiary(int month, int day);

    /*月を指定して対応する日記帳を取り出す */
    /*@return Monthly */
    /*@param month int */
    Monthly getMonthly(int month);

    /*月と日を指定して日記を更新する */
    /*@param day int */
    /*@param d Diary */
    void setDiary(int month,int day, Diary d);

    /*月を指定して日記帳を更新する */
    /*@param month int */
    /*@param m Monthly */
    void setMonthly(int month, Monthly m);

    /*その年のカレンダーを得る */
    /*その年のカレンダーとは，その年の1月1日のカレンダーである */
    /*@return java.util.GregorianCalendar */
    java.util.GregorianCalendar getCalendar();

    /*編集による変更状態を問いあわせる */
    /*@return boolean */
    boolean getEditState();

    /*年を読み取る */
    /*@return int */
    int getYear();

    /*Annualオブジェクトのコピーを作る */
    /*@return Annual */
    Annual makeCopy();

    /*編集による変更状態を設定する */
    /*@param changed boolean*/
    void setEditState(boolean changed);
}
