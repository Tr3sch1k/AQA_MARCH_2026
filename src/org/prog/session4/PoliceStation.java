package org.prog.session4;

public class PoliceStation {

    public static String[] carsWithFines = new String[]{
            "AA0110AA",
            "BB0110BB",
            "CC0110CC",
            "DD0110DD"
    };

    public static boolean checkIfCarHasFines(String plateNumber) {
        boolean found = false;
        for (int i = 0; i < carsWithFines.length; i++) {
            if (plateNumber.equals(carsWithFines[i])) {
                found = true;
            }
        }
        return found;
    }
}
