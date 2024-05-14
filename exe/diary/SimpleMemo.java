/* Memoインターフェイスの単純な実装 */
class SimpleMemo implements Memo,Cloneable {
    private java.lang.String memo;

    /* SimpleMemo コンストラクタ */
    public SimpleMemo(String str) {
        memo = str;
    }

    /* メモ文字列を取り出す */
    /* @return  java.lang.String　メモ文字列 */
    public String getMemoString() {
        return memo;
    }

    /* メモ文字列の設定をする */
    /* @param str java.lang.String　メモ文字列 */
    public void setMemoString(String str) {
        memo = str;
    }

    /* String演算＋用　文字列変換メソッド */
    /* @return java.lang.String */
    public String toString() {
        return getMemoString();
    }

    /* Memoのクローンを生成する */
    /* @return java.lang.Object */
    public Object clone() {
        try {
            SimpleMemo m = (SimpleMemo)super.clone();
            m.memo = new String(memo);
            return m;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    /* Memo オブジェクトのコピーを作る */
    /* @return Memo */
    public Memo makeCopy() {
        return (Memo)clone();
    }
}