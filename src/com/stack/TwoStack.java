package com.stack;

/**
 * Created by Jainish on 07-03-2017.
 */
public class TwoStack {
    public static final int MAX_INT = 100;
    int a[] = new int[MAX_INT];
    int top1 = -1;
    int top2 = MAX_INT;
    public void pushFirst( int data ){
        if( top1 >= top2 ) {
            System.out.println("Stack-1 Overflow");
            return;
        }
        a[++top1] = data;
    }

    public void pushSecond( int data ){
        if( top2 <= top1 ) {
            System.out.println("Stack-2 Overflow");
            return;
        }
        a[--top2] = data;
    }

    public int popFirst() {
        if( top1 <= -1 ) {
            System.out.println("Stack1-underflow");
            return 0;
        }
        return a[top1--];
    }

    public int popSecond() {
        if( top2 > MAX_INT) {
            System.out.println("Stack1-underflow");
            return 0;
        }
        return a[top2++];
    }

    public static void main(String[] args) {
        TwoStack ts = new TwoStack();
        ts.pushFirst(1);
        ts.pushFirst(2);
        ts.pushSecond(3);
        ts.pushSecond(5);
        System.out.println("pop first"+ts.popFirst());
        System.out.println("pop second"+ts.popSecond());
    }
}
