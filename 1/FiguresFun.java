public class FiguresFun{

    private static double circleLength(double x) {
        return (2.0 * 3.14 * x);
    }

    private static double squareLength(double x) {
        return (4.0 * x);
    }

    private static double triangleLength(double x) {
        return (3.0 * x);
    }

    public static void main(String[] args) {
        if (args.length > 1){
            if( args[0].equals("circle")) {
                System.out.println(circleLength(Convert.atod(args[1])) + " : " + circleLength(Convert.atod(args[1]))/2);
            }else if( args[0].equals("square")) {
                System.out.println(squareLength(Convert.atod(args[1])) + " : " + squareLength(Convert.atod(args[1]))/2);
            }else if( args[0].equals("tiangle")) {
                System.out.println(triangleLength(Convert.atod(args[1])) + " : " + triangleLength(Convert.atod(args[1]))/2);
            }else{
                System.out.println("ERROR");
            }
        }
    }
}