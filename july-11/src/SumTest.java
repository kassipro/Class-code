public class SumTest {
    public static int sumOneToN(int n) {
        if(n == 1)
            return 1;
        return n + sumOneToN(n - 1);
    }

    public static int sumOneToNShortcut(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sumOneToN(72));
        System.out.println(sumOneToNShortcut(72));
    }
}
