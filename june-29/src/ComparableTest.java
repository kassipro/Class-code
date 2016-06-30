import java.util.*;

public class ComparableTest {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        System.out.println(Integer.compare(a,b));
    }
}

class Food implements Comparable<Food> {
    int amt;
    String type;
    public Food(int amt, String type) {
        this.amt = amt;
        this.type = type;
    }

    @Override
    public int compareTo(Food other) {
        int i = Integer.compare(this.amt, other.amt);
        if(i != 0) // not a tie
            return i;
        // we have a tie, break with String compare
        return type.compareTo(other.type);
    }

    public static void main(String[] args) {
        List<Food> list = new ArrayList<>();
        Food a = new Food(1, "Burger");
        Food b = new Food(2, "Anchovies");
        list.add(a); list.add(b);
        //Collections.sort(list);
        System.out.println(list);
        System.out.println(a.compareTo(b));
    }
}
