abstract class A {
    abstract void display();
}

class B extends A {
    void display() {
        System.out.println("Call me from B");
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        B obj = new B();
        obj.display();
    }
}
