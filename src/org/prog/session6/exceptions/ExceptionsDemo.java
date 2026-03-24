package org.prog.session6.exceptions;

import org.prog.session6.Car;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    public static void main(String[] args) {
        try {
            smth3();
        } catch (Exception e) {
            System.out.println("Oops!");
        }
    }

    public static void smth1() {
        smth2();
    }

    public static void smth2() {
        Car aliceCar = new Car();
        try {
            System.out.println(aliceCar.color.equals("red"));
            System.out.println("================================");
        } finally {
            System.out.println("This always runs!");
        }
    }

    public static void smth3() {
        smth4();
    }

    public static void smth4() {
        smth5();
    }

    public static void smth5() {
        smth6();
    }

    public static void smth6() {
        try {
            FileReader fr = new FileReader("askjdh.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
