package com.com;

/**
 * Created by Jainish on 19-03-2017.
 */
public class minHeap {
    int size;
    int position;
    int[] arrminHeap;

    public minHeap( int size ){
        this.size = size;
        arrminHeap = new int[size+1];
        position = 0;
    }

    public void display(){
        for( int i=1;i<arrminHeap.length;i++){
            System.out.println(" " + arrminHeap[i]);
        }
    }

    public void createHeap( int[] tempArr ) {
        if( tempArr.length > 0 ) {
            for( int i=0;i<tempArr.length;i++) {
                insert(tempArr[i]);
            }
        }
    }

    public void insert( int element) {
        if( position == 0 ) {
            arrminHeap[position + 1] = element;
            position = 2;
        } else {
            arrminHeap[position++] = element;
            heapify();
        }
    }

    public void heapify() {
        int pos = position - 1;
        while( pos > 0 && arrminHeap[pos/2] > arrminHeap[pos]) {
            //swap parent and pos and give position to
            int y  = arrminHeap[pos];
            arrminHeap[pos] = arrminHeap[pos/2];
            arrminHeap[pos/2] = y;
            pos = pos/2;
        }
    }

    public static void main(String args[]){
        int arrA [] = {3,2,1,7,8,4,10,16,12};
        System.out.print("Original Array : ");
        for(int i=0;i<arrA.length;i++){
            System.out.print("  " + arrA[i]);
        }
        minHeap m = new minHeap(arrA.length);
        System.out.print("\nMin-Heap : ");
        m.createHeap(arrA);
        m.display();
        System.out.print("Extract Min :");
        for(int i=0;i<arrA.length;i++){
            System.out.print("  " + m.extractMin());
        }
    }

    public int extractMin() {
        int min = arrminHeap[1];
        arrminHeap[1] = arrminHeap[position-1];
        arrminHeap[position-1] = 0;
        position--;
        sinkDown(1);
        return min;
    }
    public void sinkDown( int k){
        int smallest = k;
        if( 2*k < position && arrminHeap[smallest] > arrminHeap[2*k]) {
            smallest = 2*k;
        }
        if( 2*k + 1 < position && arrminHeap[smallest] > arrminHeap[2*k +1]) {
            smallest = 2*k+1;
        }

        if( smallest != k ){
            swap(k,smallest);
            sinkDown(smallest);
        }
    }

    public void swap( int a, int b) {
        int temp = arrminHeap[a];
        arrminHeap[a] = arrminHeap[b];
        arrminHeap[b] = temp;
    }
}
