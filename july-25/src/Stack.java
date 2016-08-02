import java.util.ArrayList;

public class Stack<E> extends ArrayList<E> {
    public Stack<E> push(E e) {
        add(e);
        return this;
    }

    public E peek() {
        return get(size() - 1);
    }

    public E pop() {
        return remove(size() - 1);
    }

    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        strings.push("a").push("b").push("c");
        System.out.println(strings.peek());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
    }
}

class Stack2<E> {
    private ArrayList<E> data;
    public Stack2() {
        data = new ArrayList<>();
    }
    
    public Stack2<E> push(E e) {
        data.add(e);
        return this;
    }

    public E peek() {
        return data.get(data.size() - 1);
    }

    public E pop() {
        return data.remove(data.size() - 1);
    }

    public static void main(String[] args) {
        Stack2<String> strings = new Stack2<>();
        strings.push("a").push("b").push("c");
        System.out.println(strings.peek());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
    }
}
