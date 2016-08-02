import java.math.BigInteger;

public class LongReverse {
    public static String longToHexString(long x) {
        return Long.toHexString(x);
    }

    public static long hexStringToLong(String hex) {
        return new BigInteger(hex, 16).longValue();
    }

    public static void main(String[] args) {
        long a = hexStringToLong("ff");

        long b = Long.reverseBytes(a);

        System.out.println(longToHexString(a));
        System.out.println(longToHexString(b));

    }
}
