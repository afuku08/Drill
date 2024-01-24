public class FiguresArea {
    /* circleAreaメソッドをここに記述 */
    private static double circleArea(double x){
        return (x * x * 3.14);
    }

    /* squareAreaメソッドをここに記述 */
    private static double squareArea(double x){
        return (x * x);
    }

    /* triangleAreaメソッドをここに記述 */
    private static double triangleArea(double x){
        return (x * x * 0.433);
    }

    public static void main(String[] args) {
        if( args.length > 1 ) {
            /* 円の面積 */
            if( args[0].equals("circle") ) {
                /* circleAreaメソッドを利用して面積を求め、表示するコードをここに記述 */
                System.out.println("The area of a circle is : "
                + circleArea(Convert.atod(args[1])));

            /* 正方形の面積 */
            } else if( args[0].equals("square") ) {
                /* squareAreaメソッドを利用して面積を求め、表示するコードをここに記述 */
                System.out.println("The area of a square is : "
                + squareArea(Convert.atod(args[1])));

            /* 正三角形の面積 */
            } else if( args[0].equals("triangle") ) {
                /* triangleAreaメソッドを利用して面積を求め、表示するコードをここに記述 */
                System.out.println("The area of a triangle is : "
                + triangleArea(Convert.atod(args[1])));

            } else {
                System.out.println("Sorry unknown figure type");
            }
        } else {
            System.out.println(
                "usage : java FiguresArea <figure type> <length>");
        }
    }
}