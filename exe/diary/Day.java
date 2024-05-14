/*日記クラスの構成要素 日付を表す */
interface Day extends java.io.Serializable {

    /* 月の中の日を取り出す */
    /* @return int 日　1 日を1とする */
    int getDay();

    /* 月を取り出す */
    /* @return int 月　1月を１とする */
    int getMonth();

    /* 年を取り出す */
    /* @return int 西暦の年 */
    int getYear();

    /* 1月1日を起点0とした日付順に関するインデックスを与える */
    /* @return int */
    int getIndex();

    /* 曜日を取り出す */
    /* @return int 0:日 1:月 2:火 3:水 4:木 5:金 6:土 */
    int getNameofDay();

    /* 日付の文字列表現を得る */
    /* @return java.lang.String "yyyy/mm/dd"形式の日付 */
    String getDayString();

    /*自分自身のコピーを生成する */
    /*@return Day */
    Day makeCopy();
}