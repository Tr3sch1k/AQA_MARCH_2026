package org.prog.session4;

public class Car {

    public static String brand;
    public String color;
    public String plateNumber;

    public Car(String plateNumber) {
        System.out.println("Car with number " + plateNumber + " is being constructed...");
        this.plateNumber = plateNumber;
    }

    public void goTo(String destination) {
        System.out.println("Car brand: " + brand);
        if (color == null) {
            System.out.println("Unpainted car cannot be used!");
        } else {
            System.out.println(color + " car goes to " + destination);
        }
    }
}
