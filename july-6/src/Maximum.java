import java.util.Arrays;

public class Maximum {
    public static int max(int... ints) {
        if(ints.length == 1)
            return ints[0];
        return Math.max(max(Arrays.copyOf(ints, ints.length - 1)),
                        ints[ints.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(max(1, 4, 3, 2));
        System.out.println(max(1));
        System.out.println(max(1, 4, 3));
    }
}
