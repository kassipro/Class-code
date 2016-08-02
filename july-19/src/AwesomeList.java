public class AwesomeList {
    private AwesomeLink first;
    private int size;

    public AwesomeList() {
        size = 0;
        first = null;
    }

    public void add(int data) {
        first = new AwesomeLink(data, first);
        size++;
    }

    public void addAt(int pos, int data) {
        if(!(0 <= pos && pos <= size))
            throw new IndexOutOfBoundsException();
        if(pos == 0) {
            add(data);
            return;
        }

        AwesomeLink before = first;
        for(int i = 0; i < pos - 1; ++i)
            before = before.getNext();

        before.setNext(new AwesomeLink(data, before.getNext()));
        size++;
    }

    public void addLast(int data) {
        addAt(size, data);
    }

    public void addLastFun(int data) {
        AwesomeLink i = first;
        while(i.getNext() != null)
            i = i.getNext();
        i.setNext(new AwesomeLink(data));
    }

    public int getAt(int pos) {
        if(!(0 <= pos && pos < size))
            throw new IndexOutOfBoundsException();
        AwesomeLink before = first;
        for(int i = 0; i < pos; ++i)
            before = before.getNext();
        return before.getData();
    }

    public int indexOf(int data) {
        AwesomeLink i = first;
        for(int pos = 0; i != null; i = i.getNext(), pos++) {
            if(i.getData() == data)
                return pos;
        }
        return -1;
    }

    public void removeAt(int pos) {
        if(!(0 <= pos && pos < size))
            throw new IndexOutOfBoundsException();
        if(pos == 0) {
            first = first.getNext();
            size--;
            return;
        }

        AwesomeLink before = first;
        for(int i = 0; i < pos - 1; ++i)
            before = before.getNext();

        before.setNext(before.getNext().getNext());
        size--;
    }

    public void removeData(int data) {
        removeAt(indexOf(data));
    }

    public void removeAll() {
        first = null;
        size = 0;
    }

    public void printAll() {
        for(AwesomeLink i = first; i != null; i = i.getNext()) {
            System.out.println(i.getData() + ", ");
        }
    }

    public static void printRecursive(AwesomeLink head) {
        if(head == null) return;
        System.out.println(head.getData() + ", ");
        printRecursive(head.getNext());
    }

    public static void printRecursiveBackwards(AwesomeLink head) {
        if(head == null) return;
        printRecursive(head.getNext());
        System.out.println(head.getData() + ", ");
    }

    public void printAllRecursive() {
        printRecursive(first);
    }

    public static AwesomeLink recursiveAddLast(AwesomeLink head, int data) {
        if(head == null)
            return new AwesomeLink(data);
        head.setNext(recursiveAddLast(head.getNext(), data));
        return head;
    }

    public void recursiveAddLast(int data) {
        first = recursiveAddLast(first, data);
        size++;
    }

    public static void main(String[] args) {

    }
}
