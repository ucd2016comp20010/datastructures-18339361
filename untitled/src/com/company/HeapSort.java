package com.company;

public class HeapSort{
        public static void sort(int[] arr)
        {
            int length = arr.length;

            for (int i = length/2 - 1; i >= 0; i--)
                heapify(arr, length, i);

            for (int i=length-1; i>=0; i--)
            {
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = tmp;

                heapify(arr, i, 0);
            }
        }

        static void heapify(int[] arr, int size, int root)
        {
            int max = root;
            int left = 2*root + 1;
            int right = 2*root + 2;

            if (left < size && arr[left] > arr[max])
                max = left;

            if (right < size && arr[right] > arr[max])
                max = right;

            if (max != root)
            {
                int swap = arr[root];
                arr[root] = arr[max];
                arr[max] = swap;

                heapify(arr, size, max);
            }
//            printArray(arr);
        }

        static void printArray(int[] arr) {
            for (int value : arr) System.out.print(value + " ");
            System.out.println();
        }
}
