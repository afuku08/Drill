/* Diary 関連 定数 */
interface DiaryConstants {
    static final String[] monthName = { 
        "1月","2月","3月","4月","5月",
        "6月","7月","8月","9月","10月",
        "11月","12月"};

    String namesOfDay[] = { "日","月","火","水","木","金","土"};

    String ACTION_CODE = "action_code";

    /* 編集アクション、アイコン対応表 */
    /* インデックス */
    static final int ACT_OPEN = 0;
    static final int ACT_OUTPUT = 1;
    static final int ACT_EXIT = 2;
    static final int ACT_NEW = 3;
    static final int ACT_EDIT = 4;
    static final int ACT_CUT = 5;
    static final int ACT_PASTE = 6;
    static final int ACT_COPY = 7;
    static final int ACT_DELETE = 8;
    static final int ACT_NOP = 9;

    /* 機能コード */
    static final int BASE = 1000;

    static final int DELETE = BASE + ACT_DELETE;
    static final int EDIT = BASE + ACT_EDIT;
    static final int EXIT = BASE + ACT_EXIT;
    static final int NEW = BASE + ACT_NEW;
    static final int OPEN = BASE + ACT_OPEN;
    static final int OUTPUT = BASE + ACT_OUTPUT;
    static final int CUT = BASE + ACT_CUT;
    static final int PASTE = BASE + ACT_PASTE;
    static final int COPY = BASE + ACT_COPY;
    static final int NOP = BASE + ACT_NOP;

    /* アイコンファイル表 NOPは、含まれていない */
    final String[] actionImg = {
        "Icon-opn.jpg","Icon-out.jpg","Icon-ext.jpg",
        "Icon-new.jpg","Icon-edt.jpg","Icon-cut.jpg",
        "Icon-pst.jpg","Icon-cpy.jpg","Icon-del.jpg"
    };
    final int[] actionCod = {
        OPEN,OUTPUT,EXIT,
        NEW,EDIT,CUT,
        PASTE,COPY,DELETE
    };
    final String[] actionNam = {
        "OPEN","OUTPUT,","EXIT",
        "NEW","EDIT","CUT",
        "PASTE","COPY","DELETE"
    };
}