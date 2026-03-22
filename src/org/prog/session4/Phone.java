package org.prog.session4;

public class Phone {

    public String color;
    public String brand;

    public Phone(String color, String brand) {
        this.color = color;
        this.brand = brand;
//        System.out.println("you have phone brand: " + brand + " color " + color);
    }

    public void ring(Phone phone) {

        if (phone == null) {
            System.out.println("Sorry");
        } else {
            System.out.println("Brand " + phone.brand + " Color " + phone.color + " Bring Bring");
        }
    }


}


