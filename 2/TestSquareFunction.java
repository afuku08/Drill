public class TestSquareFunction {
    public static void main(String[] args) {
        SquareFunction u = SquareFunction.createFunction(5,10,10);
        SquareFunction v = SquareFunction.createFunction(1,0,0);
        SquareFunction w = SquareFunction.createFunction(-3,-2,-1);

        printResult(u,5,10,10);
        printResult(v,1,0,0);
        printResult(w,-3,-2,-1);
    }
    private static void printResult(SquareFunction f,double a,double b,double c) {
        System.out.println("Result of y = " + a + "*x*x + " + b +"*x + " + c);
        for( int i = 0 ; i < 10 ; ++i ) {
            System.out.println("( "+ i + " , "+ f.apply(i) + " )");
        }
    }
}
