public class SumT {
    private static long sumIter(long x,long fact){
        if(x <= 0L){
            return fact;
        }
        return sumIter(x - 1L, x + fact);
    }

    private static long sumT(long x){
        return sumIter(x, 0L);
    }

    public static void main(String[] args){
        if( args.length > 0 ) {
            System.out.print("Factorial of " + (Convert.atol(args[0])) + " :");
            System.out.println( sumT(Convert.atol(args[0])));
        } else {
            System.out.println("usage : java Factorial <number>");
        }
    }
}
