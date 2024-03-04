/* 学生情報編集インターフェイス */
interface EditStudent {
    int ENGLISH = 0;
    int MATH = 1;
    int JAPANESE = 2;

    /* 成績を参照する */
    /* @return int 得点 */
    /* @param course int 科目 */
    int getMark(int course);

    /* 成績の設定をする */
    /* @param course int 科目 */
    /* @parm mark int 得点 */
    void setMark(int course, int mark);

    /* 全学生情報表示 */
    void show();
}
