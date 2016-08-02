import java.util.NoSuchElementException;
import java.util.Scanner;

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

        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        final int c = 10;
        Queue q = new Queue();

        Thread[] consumers = new Thread[c];
        Runnable task = () -> { System.out.println(Thread.currentThread().getName() + q.take()); };
        Runnable task2 = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + q.take());
            }
        };

        for(int i = 0; i < c; ++i)
            consumers[i] = new Thread(task, String.format("Thread %d: ", i));

        Thread producer = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < c; ++i) {
                    try {
                        Thread.sleep(100);//(int) (Math.random() * 3000));
                    } catch (InterruptedException e) {}
                    q.put(Integer.toHexString(i));
                }
            }
        });

        for(int i = c - 1; i >= 0; --i)
            consumers[i].start();

        Scanner kb = new Scanner(System.in);
        System.out.println("Waiting to start producer.... type something and hit enter!");
        kb.next();
        producer.start();

        for(int i = 0; i < c; ++i)
            consumers[i].join();

        System.out.println("All consumer threads are done!");
    }
}
