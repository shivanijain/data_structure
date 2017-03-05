package com.stack;

/**
 * Created by Jainish on 05-03-2017.
 */
public class Stack {
    static final int MAX = 100; //we cannot change this value
    int a[] = new int[MAX];
    int top;

    Stack() {
        top = -1;
    }

    boolean isEmpty() {
        return (top<0);
    }

    public boolean push(int data){
        if( top >= MAX ) {
            System.out.println("Overflow");
            return false;
        } else {
           a[++top] = data;
           return true;
        }
    }

    public int pop() {
        if( top < 0 ) {
            System.out.println("under flow");
            return 0;
        } else {
            int data = a[top];
            top--;
            return data;
        }
    }
    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
    }
}
