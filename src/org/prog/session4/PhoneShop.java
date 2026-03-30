package org.prog.session4;

public class PhoneShop {

    public Phone buyPhone(String color, String brand) {
        Phone myPhone = new Phone(color, brand);

        if (SoldPhones.phoneIsSold(color, brand)){
            System.out.println("SOLD OUT!!! Sorry");
        } else {
            Phone phone = new Phone(color, brand);
            System.out.println("You have " + phone.brand + " color " + phone.color);
        }
        return myPhone;  ///
    }

}
