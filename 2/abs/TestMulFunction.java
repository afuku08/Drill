public class TestMulFunction {
    public static void main(String[] args) {
        Function u = FunctionLinear.createFunction(5,10);
        Function v = FunctionSquare.createFunction(5,10);
        Function w = FunctionSin.createFunction(-3);
        Function k = MulFunction.mulFunction(10,v,w);
        Function m = MulFunction.mulFunction(u,w);
        Function n = MulFunction.mulFunction(k,m);

        printResult(u);
        printResult(v);
        printResult(w);
        printResult(k);
        printResult(m);
        printResult(n);
    }
    private  static void printResult(Function f) {
        System.out.println("Result of Function y = " + f);
        for( int i = 0 ; i < 10 ; ++i ) {
            System.out.println("( " + i + " , " + f.apply(i) + " )");
        }
    }
}