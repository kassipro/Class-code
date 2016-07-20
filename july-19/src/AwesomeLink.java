public class AwesomeLink {
    private int data;
    private AwesomeLink next;

    public AwesomeLink(int data, AwesomeLink next) {
        this.data = data;
        this.next = next;
    }

    public AwesomeLink(int data) {
        this(data, null);
    }

    public int getData() {
        return data;
    }

    public AwesomeLink getNext() {
        return next;
    }

    public void setData(int newData) {
        data = newData;
    }

    public void setNext(AwesomeLink newNext) {
        next = newNext;
    }

    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        AwesomeLink a = new AwesomeLink(1);
        System.out.println("AwesomeLink a holds: " + a.getData());
        AwesomeLink b = new AwesomeLink(2, a);
        System.out.println("AwesomeLink b holds: " + b.getData());

        AwesomeLink head = null;
        for(int i = 0; i < 10; i++) {
            head = new AwesomeLink(i, head);
        }

        AwesomeLink link = new AwesomeLink(9, new AwesomeLink(7, new AwesomeLink(5)));
    }
}
