public class SimpleMemo implements Memo{
    private String memo;

    public SimpleMemo(String str){
        memo = str;
    }

    public String getMemoString(){
        return memo;
    }

    public void setMemoString(String str){
        memo = str;
    }

    public String toString(){
        return getMemoString();
    }
}
