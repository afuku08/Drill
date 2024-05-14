/*月選択インターフェイス */
interface MonthSelector extends DiaryConstants{
    /*月を選択する */
    /*@param month int 1:1月 2:2月, ... 12:12月 */
    void selectMonth(int month);
}
