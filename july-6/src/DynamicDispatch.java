public class DynamicDispatch {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.callMe());

        System.out.println();

        B b = new B();
        System.out.println(b.callMe());
        System.out.println(b.callMe(3));

        System.out.println();

        // the variable you store an object in
        // doesn't dictate it's behavior.
        // (just what methods you can call)
        A b_instance = new B();
        System.out.println(b_instance.callMe());

        // won't work, compiler says that
        // A objects don't necessarily have this method
        //System.out.println(b_instance.callMe(3));

        System.out.println();

        A c_instance = new C();
        System.out.println(c_instance.callMe());
    }
}

class A {
    public String callMe() {
        return "A's callMe!";
    }
}

class B extends A {
    public String callMe() {
        return "B's callMe!";
    }
    public String callMe(int times) {
        return callMe() + " " + times;
    }
}

class C extends A {
    public String callMe() {
        return super.callMe() + " then C's callMe!";
    }
}
