import java.util.NoSuchElementException;

public class EvenSeq implements IntSeq {
    private IntSeq input;

    public EvenSeq(IntSeq input) {
        this.input = input;
    }

    public int next() throws NoSuchElementException {
        int candidate = input.next();
        if(candidate % 2 == 0)
            return candidate;
        else {
            return next();
        }
    }

    public static void main(String[] args) {
        IntSeq ints = new EvenSeq(new RangeSeq(1, 20, 2));
        while(true)
            System.out.println(ints.next());
    }
}
