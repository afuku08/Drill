public class Area{
    public static void main(String[] args){
        System.out.println((args.length > 1 ?
        Convert.atod(args[0]) * Convert.atod(args[1]):
        "0.0"));
    }
}