package org.prog.session3;

//TODO: Implement bubble sort

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        //5 -> 3 -> 3 -> 2 -> 1 -> 1
        //3 -> 4 -> 2 -> 1 -> 2 -> 2
        //4 -> 2 -> 1 -> 3 -> 3 -> 3
        //2 -> 1 -> 4 -> 4 -> 4 -> 4
        //1 -> 5 -> 5 -> 5 -> 5 -> 5

        Random rand = new Random();
        int[] ints = new int[5];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(20);
            System.out.println(ints[i]);
        }

        boolean isSorted = false;

        while(!isSorted){
            isSorted = true;

            for (int i = 0; i < ints.length-1; i++) {
                if(ints[i] > ints[i+1]){
                    isSorted = false;

                    int temp = ints[i];
                    ints[i] = ints[i+1];
                    ints[i+1] = temp;
                }
            }

        }

        System.out.println("______________________________");

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }
}
