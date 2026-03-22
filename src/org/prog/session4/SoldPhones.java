package org.prog.session4;

public class SoldPhones {

        public static Phone[] sold = new Phone[]{
                new Phone("BLACK", "IPHONE")
        };

        public static boolean phoneIsSold(String color, String brand) {
            boolean found = false;
            for (int i = 0; i < sold.length; i++) {
                String upColor = color.toUpperCase();
                String upBrand = brand.toUpperCase();
                if (upColor.equals(sold[i].color) && upBrand.equals(sold[i].brand)) {
                    found = true;
                }
            }
            return found;
        }
}
