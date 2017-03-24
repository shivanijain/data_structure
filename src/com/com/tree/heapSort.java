package com.com.tree;

/**
 * Created by Jainish on 20-03-2017.
 */
public class heapSort {
    int arr[] = {12, 11, 13, 5, 6, 7};
    public static void main(String[] args) {
        heapSort hp = new heapSort();
        int n = hp.arr.length;
        hp.sort();

        System.out.println("Sorted array is");
        printArray(hp.arr);
    }

    private void sort() {
        int n = arr.length;
        for( int i = n/2-1;i>=0;i--){
            heapify(n,i);
        }

        for( int i = n-1;i>=0;i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(i,0);
        }
    }

    public void heapify( int n,int i){
            int largest = i;
            int l = 2 *i + 1;
            int r = 2 * i +2;

            if( l < n && arr[l] > arr[largest]) {
                largest = l;
            }

            if( r < n && arr[r] > arr[largest]) {
                largest = r;
            }

            if( largest != i ){
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                heapify( n ,largest);
            }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
