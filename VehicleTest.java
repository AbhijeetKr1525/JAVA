class Vehicle {

    String make;
    String model;
    int year;
    String fuelType;

    Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    double calculateFuelEfficiency() {
        return 0;   
    }

    double calculateDistance(double fuelUsed) {
        return fuelUsed * calculateFuelEfficiency();
    }

    double getMaxSpeed() {
        return 0;   
    }

    void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Type: " + fuelType);
    }
}
class Truck extends Vehicle {

    Truck(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    double calculateFuelEfficiency() {
        return 8;  
    }

    @Override
    double getMaxSpeed() {
        return 120;  
    }
}



class Car extends Vehicle {

    Car(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    double calculateFuelEfficiency() {
        return 15;  
    }

    @Override
    double getMaxSpeed() {
        return 180;  
    }
}
class Motorcycle extends Vehicle {

    Motorcycle(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    double calculateFuelEfficiency() {
        return 40;  
    }

    @Override
    double getMaxSpeed() {
        return 200;  
    }
}


// Main Class
public class VehicleTest {
    public static void main(String[] args) {

        Vehicle truck = new Truck("Tata", "Ultra", 2022, "Diesel");
        Vehicle car = new Car("Honda", "City", 2023, "Petrol");
        Vehicle bike = new Motorcycle("Yamaha", "R15", 2024, "Petrol");

        System.out.println("----- Truck -----");
        truck.displayInfo();
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " km/l");
        System.out.println("Distance with 10L fuel: " + truck.calculateDistance(10) + " km");
        System.out.println("Max Speed: " + truck.getMaxSpeed() + " km/h");

        System.out.println("\n----- Car -----");
        car.displayInfo();
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l");
        System.out.println("Distance with 10L fuel: " + car.calculateDistance(10) + " km");
        System.out.println("Max Speed: " + car.getMaxSpeed() + " km/h");

        System.out.println("\n----- Motorcycle -----");
        bike.displayInfo();
        System.out.println("Fuel Efficiency: " + bike.calculateFuelEfficiency() + " km/l");
        System.out.println("Distance with 10L fuel: " + bike.calculateDistance(10) + " km");
        System.out.println("Max Speed: " + bike.getMaxSpeed() + " km/h");
    }
}