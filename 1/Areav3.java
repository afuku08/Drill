public class Areav3{
    public static void main(String[] args){
        if (args.length > 1){
            System.out.println(Convert.atod(args[0]) * Convert.atod(args[1]));
        } else {
            System.out.println("usage : java Areav3 <lenght> <height>");
        }
        
    }
}