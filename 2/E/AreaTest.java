public class AreaTest {
    public static void main(String[] args) {
        if( args.length > 1 ) {

            /* 円の面積 */
            if( args[0].equals("circle") ) {
                printResult(new CircleArea(Double.parseDouble(args[1])));

            /* 正方形の面積 */
            } else if( args[0].equals("square") ) {
                printResult(new SquareArea(Double.parseDouble(args[1])));

            /* 正三角形の面積 */
            } else if( args[0].equals("triangle") ) {
                printResult(new TriangleArea(Double.parseDouble(args[1])));

            } else {
                System.out.println("Sorry unknown figure type");
            }
        } else {
            System.out.println("usage : java AreaTest <figure type> <length>");
        }
    }
    /* メッセージと面積を表示する printResult メソッドをここに記述 */
    public static void printResult(FiguresArea f){
        System.out.println("The area of a " + f.toString() + " is : " + f.getArea());
    }
}
