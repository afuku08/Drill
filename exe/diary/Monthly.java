public interface Monthly extends java.io.Serializable{
    
    /*月に含まれる日記に関する反復子を生成する */
    /*@return ObjectIteration */
    ObjectIteration createIteration();

    /*月の中の日を指定して対応する日記を取り出す */
    /*@return Diary */
    /*@param day int */
    Diary getDiary(int day);

    /*月の中の日を指定して日記を更新する */
    /*@param day int */
    /*@param d Diary */
    void setDiary(int day, Diary d);

    /*所定の日付を持つ新しいDiaryを作る */
    /*@param day int */
    /*return Diary */
    Diary createNewDiary(int day);

    /*その月のカレンダーを得る */
    /*@return java.util.GregorianCalendar */
    java.util.GregorianCalendar getCalendar();

    /*月を得る */
    /*@return int */
    int getMonth();

    /*年を得る */
    int getYear();

    /*Monthlyオブジェクトのコピーを作る */
    /*@return Monthly */
    Monthly makeCopy();

    /*編集による変更の有無をといあわせる */
    boolean getEditState();

    /*編集による変更有無状態の設定をする */
    void setEditState(boolean changed);
}
