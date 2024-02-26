import javax.swing.JFrame;

public class TestDiaryFrame {
    public static void main(String[] args)  {

        ScheduleList s1 = new SimpleScheduleList();
        ScheduleList s2 = new SimpleScheduleList();
        ScheduleList s3 = new SimpleScheduleList();

        Affair  a,b,c;

        Day d1 = new SimpleDay(2010,7,20);
        Day d2 = new SimpleDay(2010,10,10);
        Day d3 = new SimpleDay(2010,10,20);

        s1.addAffair(new SimpleAffair(9,30,"会議","本社ビル","山田太郎"));
        s1.addAffair(new SimpleAffair(11,30,"見学","代々木","赤塚富士子"));
        s1.addAffair(a = new SimpleAffair(15,30,"商談","新宿","鈴木次郎"));
        s1.addAffair(new SimpleAffair(16,45,null,null,"名前なし"));

        s2.addAffair(new SimpleAffair(10,15,"打合せ","新宿" ,"長島重子"));
        s2.addAffair(new SimpleAffair(13,0,"昼食会","永田町","小泉信美"));
        s2.addAffair(b =new SimpleAffair(17,30,"接待","銀座","JD.ロック三世"));

        s3.addAffair(new SimpleAffair(10,15,"セミナー","新宿","川端安成"));
        s3.addAffair(c = new SimpleAffair(13,0,"打合せ","秋葉原","山本工事"));
        s3.addAffair(new SimpleAffair(15,30,"会議","本社ビル","山下卓郎"));

        Diary dia1 = new SimpleDiary();
        dia1.setDay(d1);
        dia1.setScheduleList(s1);
        dia1.setPrimaryAffair(a);
        dia1.setMemo(new SimpleMemo(
                    "鈴木は、金もち、ただし、タフネゴシエータ。心してかかること。"));


        Diary dia2 = new SimpleDiary();
        dia2.setDay(d2);
        dia2.setScheduleList(s2);
        dia2.setPrimaryAffair(b);
        dia2.setMemo(new SimpleMemo(
                    "R氏は、慈善家としてしられているが、謎めいた側面ももちあわせている。"));

        Diary dia3 = new SimpleDiary();
        dia3.setDay(d3);
        dia3.setScheduleList(s3);
        dia3.setPrimaryAffair(c);
        dia3.setMemo(new SimpleMemo("今期決算に関わる重要な会議。"));

        JFrame f = new DiaryFrame(new Diary[] {dia1,dia2,dia3});
        f.setVisible(true);
    }
}