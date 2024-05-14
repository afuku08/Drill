/* 重要事項を表現するインターフェイス */
interface Affair extends java.io.Serializable {

    /* 重要事項の文字列を与える */
    /* @return java.lang.String 重要事項 */
    String getAffairString();

    /* 「何を」を取り出す */
    /* @return java.lang.String 「何を」重要事項の主要項目 */
    String getWhat();

    /* 「時刻」を取り出す （文字列表現 "hh ：mm"形式） */
    /* @return java.lang.String */
    String getWhen();

    /* 「時刻」を整数型配列で取り出す */
    /* @return int[ ] ｛時，分｝ */
    int[ ] getWheninInt();

    /* 「時刻」を0時0分を起点とする分単位とする */
    /* @return int 分で換算した時刻 */
    int getWheninMinute();

    /*  「場所」を取り出す */
    /* @return java.lang.String 場所 */
    String getWhere();

    /* 「誰と」を取り出す */
    /* @return java.lang.String 相手 */
    String getWho();

    /* 「何を」を設定する */
    /* @param item java.lang.String 何 */
    void setWhat(String item);

    /* 「時刻」を設定する */
    /* @param h int */
    /* @param m int */
    void setWhen(int h,int m);

    /* 「場所」を設定する */
    /* @param place java.lang.String 場所 */
    void setWhere(String place);

    /* 「誰と」を設定する */
    /* @param person java.lang.String 誰 */
    void setWho(String person);

    /*Affairオブジェクトのコピーを生成する */
    /*@return Affair */
    Affair makeCopy();
}