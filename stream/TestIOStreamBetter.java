import java.io.*;

/* InputStreamをReaderにおき換え、OutputStreamをWriterにおき換える */
public class TestIOStreamBetter {
    public static void main(String[] args) throws IOException {
        int c;
        Reader ir;
        Writer ow;

        if( args.length > 0 ) ir = new FileReader(args[0]);
        else ir = new InputStreamReader(System.in);

        if( args.length > 1 ) ow = new FileWriter(args[1]);
        else ow = new PrintWriter(System.out);
        while( (c = ir.read()) != -1) {
            ow.write(c);
            /* 復帰・改行以外なら空白を挿入 */
            if (c != '\r' && c != '\n') {
                ow.write(' ');
            }
        }
        /* これを省略すると画面表示されない場合がある */
        ow.flush();
    }
}