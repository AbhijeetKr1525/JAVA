
class Animal {
    String color = "White";

    Animal() {
        System.out.println("Animal Constructor Called");
    }

    void sound() {
        System.out.println("Animal makes sound");
    }
}


class Dog extends Animal {
    String color = "Black";

    Dog() {
        super();  
        System.out.println("Dog Constructor Called");
    }

    void displayColor() {
        System.out.println("Dog color: " + color);           
        System.out.println("Animal color: " + super.color);  
    }

    void sound() {
        super.sound();
        System.out.println("Dog barks");
    }
}


public class SuperExample {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.displayColor();
        d.sound();
    }
}
