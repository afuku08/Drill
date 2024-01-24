public class SquareRoot {
    /* 平均値を計算する */
    private static double average(double u, double v) {
        return (u + v) / 2;
    }
    /* 次の予測値を求める */
    private static double improve(double x, double guess) {
        return average(guess, x / guess);
    }
    /* 予測値の近似が充分であるかどうかを判定する */
    private static boolean nearEnough(double u, double v) {
        return Math.abs(u - v) < 0.001;
    }
    /* 反復的に充分な近似に達するまで平方根の予測値を求める */
    /* x：平方値 guess：予測値 lastguess：前回の予測値 */
    private static double squareRootIter(double x, double guess, double lastguess) {
        if( nearEnough(guess,lastguess) ) {
            return guess;
        }
        return squareRootIter(x,improve(x,guess),guess);
    }
    /* xの平方根を求める */
    private static double squareRoot(double x) {
        return squareRootIter(x, x / 2, x);
    }

    public static void main(String[] args) {
        if( args.length > 0 ) {
            System.out.print("Square Root of " + (Convert.atod(args[0])) + " :");
            System.out.println( squareRoot(Convert.atod(args[0])));
        } else {
            System.out.println("usage : java SquareRoot <number>");
        }
    }
}
