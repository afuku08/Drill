/* Memo インターフェイス */
interface Memo extends java.io.Serializable {

    /* メモ文字列を取り出す */
    /* @return java.lang.String メモ文字列 */
    String getMemoString();

    /* メモ文字列の設定をする */
    /* @param str java.lang.String メモ文字列 */
    void setMemoString(String str);

    /*Memoオブジェクトのコピーを作る */
    /*@return Memo */
    Memo makeCopy();
}
