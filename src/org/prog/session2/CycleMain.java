package org.prog.session2;

public class CycleMain {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//
//        for (int i = 0; i < 10;) {
//            System.out.println(i);
//            i++;
//        }
//        for (int i = 512; i % 511 != 0; i++) {
//            System.out.println(i);
//        }

//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                System.out.println("Number " + i + " is even");
//            } else {
//                System.out.println("Number " + i + " is odd");
//            }
//        }

        int j = 0;
        int k = 0;
//        while (j + k < 500) {
//            j++;
//            k += 2;
//            System.out.println("j : " + j);
//            System.out.println("k : " + k);
//            System.out.println(j + k);
//        }
//        while (true) {
//            j++;
//            k += 2;
//
//            if (j * k > 1000) {
//                System.out.println("j : " + j);
//                System.out.println("k : " + k);
//                System.out.println("j * k : " + j * k);
//                break;
//            }
//        }

        while (j < 10) {
            j++;//5
            if (j < 5) {//5<5 - false
                continue;//execute
            }
            if (j < 8) { //1,2,3,4,5,6,7
                System.out.println(j);
            }
        }
    }
}
