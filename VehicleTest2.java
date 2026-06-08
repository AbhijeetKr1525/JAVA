abstract class Vehicle {
    abstract void engine();
}

class Car extends Vehicle {
    void engine() {
        System.out.println("Car has a good engine");
    }
}

class Truck extends Vehicle {
    void engine() {
        System.out.println("Truck has a bad engine");
    }
}

public class VehicleTest2 {
    public static void main(String[] args) {
        Car c = new Car();
        Truck t = new Truck();

        c.engine();
        t.engine();
    }
}
