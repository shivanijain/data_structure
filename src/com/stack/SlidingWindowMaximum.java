package com.stack;

/**
 * Created by Jainish on 10-03-2017.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k =3;
        Stack s = new Stack();
        Stack aux = new Stack();
        for(int i=0;i<arr.length;i++){
            s.push(arr[i]);
        }

        while((s.top - (k-2)) > 0) {
            int index = 0;
            int max = s.pop();
            while( index < (k-1)) {
                int second = s.pop();
                if(max<second) {
                    max = second;
                }
                aux.push(second);
                index++;
            }
            while(!aux.isEmpty() ){
                s.push(aux.pop());
            }
            System.out.println(max);
        }
    }
}
