import java.util.NoSuchElementException;

public class Queue {
    private interface Qnode {
        String first();
        Qnode rest();
    }
    private Qnode items;
    private Qnode end;

    public Queue() {
        items = null;
        end = null;
    }

    public synchronized String tryTake() {
        if(items == null)
            throw new NoSuchElementException();
        String ret = items.first();
        items = items.rest();
        return ret;
    }

    public synchronized String take() {
        while(items == null) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        String ret = items.first();
        items = items.rest();
        return ret;
    }

    public synchronized void put(String s) {
        class ModifiableNode implements Qnode {
            String first;
            Qnode rest = null;

            public ModifiableNode(String first) {
                this.first = first;
            }

            public String first() { return first; }
            public Qnode rest() { return rest; }
        }

        Qnode newEnd = new ModifiableNode(s);
        if(items == null) {
            items = newEnd;
            end = newEnd;
        } else {
            ((ModifiableNode) end).rest = newEnd;
            end = newEnd;
        }
    }

    public static void main(String[] args) {
        // exercise class, multiple threads blocked
    }
}
