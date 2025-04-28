class Bicycle {
    String model;
    int gearCount;

    // Constructor
    Bicycle(String model, int gearCount) {
        this.model = model;
        this.gearCount = gearCount;
    }

    void ride() {
        System.out.println(model + " is riding with " + gearCount + " gears.");
    }

    void displayInfo() {
        System.out.println("Bicycle Model: " + model);
        System.out.println("Number of Gears: " + gearCount);
    }
}

public class choity {
    public static void main(String[] args) {
        Bicycle myBike = new Bicycle("Mountain Bike", 21); // object creation using constructor
        myBike.ride();
        myBike.displayInfo();
    }
}
