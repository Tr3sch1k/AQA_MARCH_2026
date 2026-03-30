package org.prog.session4;

//TODO: Write class Phone with fields brand and color. And method ring (print color and model)
//TODO: Write class PhoneShop where you can buy phone that is not black and iphone
//TODO: PhoneShop must return phone with requested brand and color

import java.util.*;

public class Main {

    /**
     * #Car.brand#######################
     * #################################
     * #################################
     * ########(Car.color)############## <---- car1
     * ########(Car.color)############## <---- car2
     * #################################
     * #################################
     * #################################
     * =================================
     * #########10######################
     */

    public static void main(String[] args) {
        PoliceStation.checkIfCarHasFines("asdasd");


        String s1 = "s1";
        String s2 = "s1";

        System.out.println(s1.equals(s2));
//        String s3;

//        Car aliceCar = null;
//        System.out.println(aliceCar.color);

        CarService service = new CarService();

        Car.brand = "Volvo";

        Car car = new Car("AA0110AA");
        service.paintCar("Red", car);
        car.goTo("Lviv");

        Car car2 = new Car("AA0120AA");
        service.paintCar("Blue", car2);
        car2.goTo("Odessa");
/// /////////////////////////////////////////////////////////////////////////////////////

        PhoneShop orange = new PhoneShop();
        Phone myPhone = new Phone("red", "Sumsong");
        myPhone.ring(myPhone);
//        orange.buyPhone("black", "iphone");
//        orange.buyPhone("yellow", "Samsung");

        Phone mySecondPhone = orange.buyPhone("Green", "Nokia"); ///
        System.out.println(mySecondPhone.color + mySecondPhone.brand + "+");

        Phone myPhone1 = new Phone("red", "Sumsong");
        Phone myPhone2 = new Phone("red", "Sumsong");
        Phone myPhone3 = new Phone(null, null);
        Phone myPhone4 = new Phone("red", "IDomophone");
        System.out.println(myPhone1.hashCode());
        System.out.println(myPhone2.hashCode());

        System.out.println(myPhone1.equals(myPhone2));

        System.out.println(myPhone4.equals(myPhone3));
        System.out.println(myPhone3.equals(myPhone4));

        /// //////////////// HOMEWORK 7 ////////////

        List<String> phone1List = new LinkedList<>();
        List<String> phone2List = new LinkedList<>();
        List<String> phone3List = new LinkedList<>();
        List<String> phone4List = new LinkedList<>();

        Map<Phone, List> mapPhone = new HashMap<>();
        mapPhone.put(myPhone1, phone1List);
        mapPhone.put(myPhone2, phone2List);
        mapPhone.put(myPhone3, phone3List);
        mapPhone.put(myPhone4, phone4List);

        String[] numberPhone = new String[]{
                "1111111111",
                "2222222222",
                "3333333333",
                "4444444444",
                "5555555555"
        };

        addPhoneNumber(phone1List, numberPhone);
        addPhoneNumber(phone2List, numberPhone);
        addPhoneNumber(phone3List, numberPhone);
        addPhoneNumber(phone4List, numberPhone);

        System.out.println(mapPhone.get(myPhone1).get(0));



        /// //////////////////////////////////////////////

    }

    public static void addPhoneNumber(List list, String[] number) {
        for (int i = 0; i < number.length; i++) {
            list.add(number[i]);
        }
    }

    public static void paintCar(Car car, String color) {
        car.color = color;
    }
}
