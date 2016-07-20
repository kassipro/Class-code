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

    public void printAll() {

    }

    public static void main(String[] args) {
        AwesomeList
    }
}
