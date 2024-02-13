public class Stat {
    private int add(int i) {
        if(i <= 0) return 0;
        return i + add(i - 1);
    }

    public static void main(String[] args) {
        System.out.println("RESULT : " + add(10));
    }
}
