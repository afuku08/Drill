/* SecureAccount */
/* パスワードチェックつきのAccount */
class SecureAccount {
    private String password;
    private String name;
    private Account account;
    private int check = 0;
    private boolean freezed = false;

    /* 預金口座オブジェクトを生成 */
    /* @param amount int 口座開設金 */
    protected SecureAccount(int amount,String name,String password) {
        this.password = password;
        this.name = name;
        account = Account.makeAccount(amount);
    }

    /* 預金口座を新規に開設する スタティックファクトリ */
    /* @return SecureAccount */
    /* @param amount int */
    /* @param passwd String パスワード */
    /* @param name String 名前 */
    public static SecureAccount makeAccount(int amount,String name,String passwd) {
        return new SecureAccount(amount,name,passwd);
    }

    /* 残高照会をする */
    /* @return int 残高 */
    /* @param passwd String パスワード */
    public int ask(String passwd) {
        return (check_password(passwd) ? account.ask() : 0);
    }

    /* 預金する */
    /* @param amount int 預金額 */
    /* @param passwd String パスワード */
    public void deposit(int amount, String passwd) {
        (check_password(passwd) ? account.deposit(amount) : 0);
    }

    /* 預金を引き出す */
    /* @return int 引き出された金額 */
    /* @param amount int 引出額 */
    /* @param passwd String パスワード */
    public int withdraw(int amount,String passwd) {
        return (check_password(passwd) ? account.withdraw(amount) : 0);
    }

    /* パスワードをチェックする */
    /* @return boolean true:パスワード一致、false:パスワード不一致 */
    /* @param passwd String パスワード */
    public boolean check_password(String passwd){
        if(freezed){
            System.out.println("Alarm!");
            return false;
        }
        if(password.equals(passwd)){
            return true;
        }else{
            System.out.println("### Sorry, Try again. ###");
            return false;
        }
    }
}

public class SecureAccountTest {
    public static void main(String[] args) {
        SecureAccount a = SecureAccount.makeAccount(1000,"Mr. X.","1234");
        SecureAccount b = SecureAccount.makeAccount(2000,"General Y.","9999");

        a.deposit(500,"1234");
        System.out.println("X : " + a.ask("1234"));
        a.deposit(500,"1234");
        System.out.println("X : " + a.ask("1234"));

        b.withdraw(550,"9999");
        System.out.println("Y : " + b.ask("9999"));
        b.withdraw(600,"9999");
        System.out.println("Y : " + b.ask("9999"));

        a.withdraw(500,"1245");
        System.out.println("X : " + a.ask("1245"));
        a.withdraw(500,"1245");
        System.out.println("X : " + a.ask("1245"));
        a.withdraw(500,"1234");
        System.out.println("X : " + a.ask("1234"));
    }
}