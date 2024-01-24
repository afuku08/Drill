public class SquareRootDoLoop {
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

    /* xの平方根を求める */
    private static double squareRoot(double x) {
        double guess = 1;
        double lastguess;
        do{
            lastguess = guess;
            guess = improve(x, guess);
        }while( !nearEnough(guess, lastguess));
        return guess;
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
