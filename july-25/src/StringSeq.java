import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class StringSeq {
    private final String first;
    private final StringSeq rest;
    private final int size;

    public StringSeq(String first, StringSeq rest) {
        this.first = first;
        this.rest = rest;
        this.size = 1 + ((rest == null) ? 0 : rest.size);
    }

    public StringSeq(String first) {
        this(first, null);
    }

    public String    first() { return first; }
    public StringSeq rest() { return rest; }
    public int       size() { return size; }

    public StringSeq add(String s) {
        return new StringSeq(s, this);
    }

    public String get(int pos) {
        if(pos < 0)
            return null;
        if(pos == 0)
            return first;
        if(rest == null)
            return null;
        return rest.get(pos - 1);
    }

    public StringSeq drop(int howMany) {
        if(howMany <= 0)
            return this;
        if(rest == null)
            return null;
        return rest.drop(howMany - 1);
    }

    public StringSeq take(int howMany) {
        if(howMany <= 0)
            return null;
        if(rest == null)
            return new StringSeq(first);
        return new StringSeq(first, rest.take(howMany - 1));
    }

    public StringSeq filter(Predicate<String> keep) {
        StringSeq result_rest = (rest == null) ? null : rest.filter(keep);
        if(keep.test(first))
            return new StringSeq(first, result_rest);
        return result_rest;
    }

    public StringSeq map(UnaryOperator<String> op) {
        return new StringSeq(op.apply(first),
                             (rest == null) ? null : rest.map(op));
    }
}
