package org.prog.session4;

public class CarService {

    public void paintCar(String color, Car car) {
        if (PoliceStation.checkIfCarHasFines(car.plateNumber)) {
            System.out.println("Notify the police");
        }
        car.color = color;
    }
}
