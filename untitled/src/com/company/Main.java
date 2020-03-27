package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        int size = 1000;
        int[] arr;
        arr = new int[size];

        int randomNum=0;

        while(size <= 100000) {
            for (int i = 0; i < arr.length; i++) {
                randomNum = rand.nextInt(1000);
                arr[i] = randomNum;
            }

            long HeapStartTime = System.nanoTime();
            System.out.print(size + ", ");
            HeapSort.sort(arr);
            long HeapEstimatedTime = System.nanoTime() - HeapStartTime;
            System.out.print(HeapEstimatedTime + "\n");


            long PQStartTime = System.nanoTime();
            System.out.print(size + ", ");
            PQSort.sort(arr);
            long PQEstimatedTime = System.nanoTime() - PQStartTime;
            System.out.print(PQEstimatedTime + "\n");

            size*=1.2;
        }
    }
}
