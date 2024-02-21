/* 何もしないEditStudentの実装 */
class InitialEditStudent implements EditStudent {
    /* 成績を参照する(何もせず0を返す） */
    /* @return int 得点 */
    /* @param course int 科目 */
    public int getMark(int course) {
        return 0;
    }

    /* 成績の設定をする（何もしない） */
    /* @param course int 科目 */
    /* @parm mark int 得点 */
    public void setMark(int course, int mark) {
    }

    /* 全学生情報表示（何もしない） */
    public void show() {
    }
}
