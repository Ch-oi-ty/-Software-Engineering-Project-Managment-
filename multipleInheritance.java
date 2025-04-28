interface Driveable {
    void drive();
}

interface Chargeable {
    void charge();
}

class ElectricCar implements Driveable, Chargeable {
    public void drive() {
        System.out.println("Electric car is driving...");
    }

    public void charge() {
        System.out.println("Electric car is charging...");
    }
}

public class multipleInheritance {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        car.drive();
        car.charge();
    }
}
