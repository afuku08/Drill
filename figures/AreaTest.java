public class AreaTest {
    public static void main(String[] args) {
        if( args.length > 1 ) {

            /* 円の面積 */
            if( args[0].equals("circle") ) {
                printResult(
                    new FiguresArea("circle", Convert.atod(args[1])) {
                        public double getArea() {
                            return getLength() * getLength() * 3.14;
                        }
                    }
                );

            /* 正方形の面積 */
            } else if( args[0].equals("square") ) {
                printResult(
                    /* FiguresAreaクラスをスーパータイプとする無名内部クラスをここに記述 */
                    new FiguresArea("square", Convert.atod(args[1])) {
                        public double getArea() {
                            return getLength() * getLength();
                        }
                    }
                );

            /* 正三角形の面積 */
            } else if( args[0].equals("triangle") ) {
                printResult(
                    /* FiguresAreaクラスをスーパータイプとする無名内部クラスをここに記述 */
                    new FiguresArea("triangle", Convert.atod(args[1])) {
                        public double getArea() {
                            return getLength() * getLength() * 0.433;
                        }
                    }
                );

            } else {
                System.out.println("Sorry unknown figure type");
            }
        } else {
            System.out.println("usage : java AreaTest <figure type> <length>");
        }
    }
    private static void printResult(FiguresArea f) {
        System.out.print("The area of a " + f + "is : ");
        System.out.println(f.getArea());
    }
}
