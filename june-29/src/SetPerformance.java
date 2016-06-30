import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class SetPerformance {
    private static Base64.Encoder c = Base64.getEncoder();
    public static String randomString(Random r) {
        byte[] b = new byte[8]; // 64 bits
        r.nextBytes(b);
        return c.encodeToString(b);
    }

    public static void lookupComparison(Collection<String> a, Collection<String> b, int size) {
        String aName = a.getClass().getSimpleName();
        String bName = b.getClass().getSimpleName();

        Random r = new Random(42);
        List<Integer> testPoints = new ArrayList<>();
        final int pts = 7; // how many test points
        for(int i = 1; i <= pts; ++i) // distribute test points
            testPoints.add((i * size) / (pts + 1));
        List<String> testStrings = new ArrayList<>();

        long preloop = System.nanoTime();
        for(int i = 0; i < size; ++i) {
            String s = randomString(r);

            if(testPoints.contains(i))
                testStrings.add(s);
            a.add(s); b.add(s);
        }
        System.out.printf("Loaded %,d random strings in %,d milliseconds\n",
            size, (System.nanoTime() - preloop) / (int) 1e6);

        testStrings.add("Archipelago Arpeggio");
        testStrings.add("cat");

        for(String s : testStrings) {
            System.out.println("==> Lookup of " + s);

            long adiff = lookupStats(aName, a, s);
            long bdiff = lookupStats(bName, b, s);

            System.out.printf("%s/%s: %,d\n\n", bName, aName, bdiff / adiff);
        }
    }

    public static <T> long lookupStats(String name, Collection<T> c, T lookfor) {
        long before = System.nanoTime();
        boolean contains = c.contains(lookfor);
        long diff = System.nanoTime() - before;

        System.out.printf("%-11s%sfound in %,12d ns\n", name,
            contains ? "" : "not ", diff);
        return diff;
    }

    static final int thousand = (int) 1e3;
    static final int million  = (int) 1e6;
    public static void main(String[] args) {
        //System.out.println(randomString(new Random(42))); // => "NZ1BuveK/g0="

        lookupComparison(new HashSet<>(), new ArrayList<>(), 5 * million);
        //lookupComparison(new TreeSet<>(), new ArrayList<>(), million);
        //lookupComparison(new HashSet<>(), new LinkedList<>(), million);
        //lookupComparison(new TreeSet<>(), new LinkedList<>(), million);
    }
}
