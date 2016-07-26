import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class StringSeq {
    private final String data;
    protected StringSeq rest;
    protected int size;

    public StringSeq(String data, StringSeq rest) {
        this.data = data;
        this.rest = rest;
        this.size = 1 + ((rest == null) ? 0 : rest.size);
    }

    public StringSeq(String data) {
        this(data, null);
    }

    public String    data() { return data; }
    public StringSeq rest() { return rest; }
    public int       size() { return size; }

    public StringSeq add(String s) {
        return new StringSeq(s, this);
    }

    public String get(int pos) {
        if(pos < 0)
            return null;
        if(pos == 0)
            return data;
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
            return new StringSeq(data);
        return new StringSeq(data, rest.take(howMany - 1));
    }

    public StringSeq filter(Predicate<String> keep) {
        StringSeq result_rest = (rest == null) ? null : rest.filter(keep);
        if(keep.test(data))
            return new StringSeq(data, result_rest);
        return result_rest;
    }

    public StringSeq map(UnaryOperator<String> op) {
        return new StringSeq(op.apply(data),
                             (rest == null) ? null : rest.map(op));
    }
}
