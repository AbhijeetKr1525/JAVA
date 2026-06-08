class OuterClass {
    static int outerData = 100;

    static class StaticNested {
        void display() {
            System.out.println("Outer Data: " + outerData);
        }
    }
}

public class StaticNestedDemo {
    public static void main(String[] args) {
        OuterClass.StaticNested obj = new OuterClass.StaticNested();
        obj.display();
    }
}
