package org.prog.session4;

import java.util.Objects;

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

    public boolean equals(Object obj) {
        if (obj instanceof Phone) {
            Phone phone = (Phone) obj;
            try {
                phone.brand.equals("a");
                phone.color.equals("a");
                this.color.equals("a");
                this.brand.equals("a");
//                System.out.println(phone.brand.equals("a"));
//                System.out.println(phone.color.equals("a"));
//                System.out.println(this.color.equals("a"));
//                System.out.println(this.brand.equals("a"));
//                System.out.println("______");
            } catch (RuntimeException e) {
                System.out.println("oops, phone has no brand or color!");
            }
            return Objects.equals(phone.color, this.color) &&
                    Objects.equals(phone.brand, this.brand);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(color + brand);
    }

}


