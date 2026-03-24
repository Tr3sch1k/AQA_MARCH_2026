package org.prog.session6;

//TODO: Add hascode and equals to Phone class to take brand and color into account
//TODO: If brand or color are null -> throw new RuntimeException in both hascode and equals
//TODO: intercept that exception and print "oops, phone has no brand or color!:

public class Main {

    public static void main(String[] args) {
        Car aliceCar = new Car();
        Car bobCar = new Car();
        aliceCar.color = "red";
        bobCar.color = "red";
        System.out.println(aliceCar.equals(bobCar));
        System.out.println(aliceCar.hashCode());
        System.out.println(bobCar.hashCode());
        System.out.println(aliceCar);
        System.out.println(bobCar);
        Object o = new Object();
        //0  - 0     - 0
        //1  - 1     - 1
        //2  - 10    - 2
        //3  - 11    - 3
        //4  - 100   - 4
        //5  - 101   - 5
        //6  - 110   - 6
        //7  - 111   - 7
        //8  - 1000  - 8
        //9  - 1001  - 9
        //10 - 1010  - A
        //11 - 1011  - B
        //12 - 1100  - C
        //13 - 1101  - D
        //14 - 1110  - E
        //15 - 1111  - F
        //16 - 10000 - 10
    }
}