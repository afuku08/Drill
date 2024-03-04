import java.io.*;

public class TestDiary2 {
    public static void main(String[] args) throws IOException {
        ScheduleList s1 = new SimpleScheduleList();
        ScheduleList s2 = new SimpleScheduleList();

        Affair a,b,c;

        Day d1 = new SimpleDay(2010,7,20);
        Day d2 = new SimpleDay(2010,10,10);

        s1.addAffair(new SimpleAffair(9,30,"会議","本社ビル","山田太郎"));
        s1.addAffair(new SimpleAffair(11,30,"見学","代々木","赤塚富士子"));
        s1.addAffair(a = new SimpleAffair(15,30,"商談","新宿","鈴木次郎"));
        s1.addAffair(new SimpleAffair(16,45,null,null,"名前なし"));
        s2.addAffair(new SimpleAffair(10,15,"打合せ","新宿","長島重子"));
        s2.addAffair(new SimpleAffair(13,0,"昼食会","永田町","小泉信美"));
        s2.addAffair(b = new SimpleAffair(17,30,"接待","銀座","JD.ロック三世"));

        Diary dia1 = new SimpleDiary();
        dia1.setDay(d1);
        dia1.setScheduleList(s1);
        dia1.setPrimaryAffair(a);
        dia1.setMemo(new SimpleMemo(
                    "鈴木は、金持ち、ただしタフネゴシエータ。心してかかること。"));

        Diary dia2 = new SimpleDiary();
        dia2.setDay(d2);
        dia2.setScheduleList(s2);
        dia2.setPrimaryAffair(b);
        dia2.setMemo(new SimpleMemo(
                    "R氏は、慈善家としてしられているが、謎めいた側面ももちあわせている。"));

        FileOutputStream f;
        ObjectOutputStream ot = null;
        /*【Q1の解答入る】*/
        try{
            ot.writeObject(dia1);
            ot.writeObject(dia2);
            ot.flush();
        }catch(NotSerializableException e){
            System.out.println(e);
        }catch(InvalidClassException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        finally {
            if(ot != null) {
                ot.close();
            }
        }

        /* dia1の内容を書き換えてしまう */
        c = s1.getAffair(11,30);
        s1.removeAffair(c);
        s1.addAffair(new SimpleAffair(11,30,"見学","代々木","赤塚文雄"));
        s1.addAffair(new SimpleAffair(12,30,"昼食会","赤坂","JFK"));

        FileInputStream f2;
        ObjectInputStream in = null;
        Diary dia1b = null;
        Diary dia2b = null;
        /*【Q2の解答入る】*/
        try{
            dia1b = (Diary)in.readObject();
            dia2b = (Diary)in.readObject();
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(InvalidClassException e){
            System.out.println(e);
        }catch(StreamCorruptedException e){
            System.out.println(e);
        }catch(OptionalDataException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }

        System.out.println("オリジナル");
        System.out.println(dia1);
        System.out.println("from File");
        System.out.println(dia1b);
        System.out.println("オリジナル");
        System.out.println(dia2);
        System.out.println("from File");
        System.out.println(dia2b);
    }
}