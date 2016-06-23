import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private static class Counter {
        private long cnt = 0;
        // declare a private long member variable
        // write a no argument constructor, starts at 0
        public Counter() {
        }

        // write a method "current" to get the current value
        public long current() {

        }

        // write a method, "inc" to increment the value
        public void inc() {

        }

        // write an equals and toString with @Override
        @Override
        public String toString() {

        }

        @Override
        public boolean equals(Object o) {

        }
    }

    private final Map<String, Counter> counts;

    public WordCounter() {
        counts = new HashMap<String, Counter>();
    }

    public void count(String s) {
        Counter c = counts.get(s);
        if(c != null)
            c.inc();
        else {
            counts.put(s, new Counter());
            count(s);
        }
    }

    public int countOf(String s) {
        Counter c = counts.get(s);
        if(c != null)
            return c.current();
        return 0;
    }

    // write an equals and toString with @Override
    // hint, don't work too hard, leverage HashMap's equals and toString

    public String highestCount() {
        // code here to return the highest count String
        return null;
    }
}
