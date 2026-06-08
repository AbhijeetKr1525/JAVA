class Counter {

    static int count = 0;

    Counter() {
        count++;
    }

    static void display() {
        System.out.println("Count = " + count);
    }
}

public class StaticExample {

    public static void main(String[] args) {

        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        Counter.display();

    }
}