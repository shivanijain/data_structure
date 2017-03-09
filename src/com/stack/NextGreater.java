package com.stack;

/**
 * Created by Jainish on 09-03-2017.
 */
public class NextGreater extends Stack {

    public static void main(String[] args) {
        int arr[] = {1,5,2,3};
        Stack s = new Stack();
        s.push( arr[0] );
        for (int i = 1; i < arr.length; i++ ) {
            int next = arr[i];
            if( false == s.isEmpty() ) {
                int popData = s.pop();
                while( next >= popData ) {
                    System.out.println(popData+"-->"+next);
                    if( true == s.isEmpty() ) break;
                    popData = s.pop();
                }
                if( next < popData ) {
                    s.push(popData);
                }
            }
            s.push(next);
        }
        while( false == s.isEmpty() ) {
            System.out.println(s.pop()+"--> -1");
        }
    }
}
