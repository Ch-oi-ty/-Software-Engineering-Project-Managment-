interface Vehicle {
    void start();
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting...");
    }
}

public class InTerface {
    public static void main(String[] args) {
        Bike b = new Bike();
        b.start();
    }
}
