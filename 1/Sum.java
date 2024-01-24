public class Sum {

    private  static long sum(long x) {
        if(x <= 0L) {
            return 0L;
        }
        return (x + sum(x - 1L));
    }
    public static void main(String[] args){
        if( args.length > 0 ) {
            System.out.print("Factorial of " + (Convert.atol(args[0])) + " :");
            System.out.println( sum(Convert.atol(args[0])));
        } else {
            System.out.println("usage : java Factorial <number>");
        }
    }
}
