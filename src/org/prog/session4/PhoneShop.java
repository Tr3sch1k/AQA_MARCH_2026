package org.prog.session4;

public class PhoneShop {

    public void buyPhone(String color, String brand) {
        if (SoldPhones.phoneIsSold(color, brand)){
            System.out.println("SOLD OUT!!! Sorry");
        } else {
            Phone phone = new Phone(color, brand);
            System.out.println("You have " + phone.brand + " color " + phone.color);
        }
    }

}
