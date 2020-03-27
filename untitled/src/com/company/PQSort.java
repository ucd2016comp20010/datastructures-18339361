package com.company;

public class PQSort {
        public static void sort(int[] arr)
        {
            int length = arr.length;

            for (int i = 0; i < length-1; i++)
            {
                int minIndex = i;
                for (int j = i+1; j < length; j++)
                    if (arr[j] < arr[minIndex])
                        minIndex = j;

                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
//            printArray(arr);
        }

        static void printArray(int[] arr)
        {
            int n = arr.length;
            for (int value : arr) System.out.print(value + " ");
            System.out.println();
        }

}
