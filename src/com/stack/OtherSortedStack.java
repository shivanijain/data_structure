package com.stack;

/**
 * Created by Jainish on 09-03-2017.
 */
public class OtherSortedStack {
    int[] arr = new int[4];
    int top1 = -1;

    public void push1(int i){
        if(top1 >= arr.length){
            System.out.println("Stack full");
            return;
        }

        top1++;
        arr[top1] = i;

    }

    public int pop1(){
        if(top1 < 0){
            System.out.println("Stack Empty");
//System.exit(0);
            return 0;
        }

        int val = arr[top1];
        top1--;
        return val;
    }

    public void printStack(){
        for(int i = 0; i <= top1; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void reverse(){
        if(!isEmpty()){
            int temp = pop1();
            reverse();
            iB(temp);
        }
    }

    void iB(int val){
        if(isEmpty() || val > sTop()){
            push1(val);
        }else{
            int temp = pop1();
            iB(val);
            push1(temp);
        }

    }

    int sTop(){
        return arr[top1];
    }

    boolean isEmpty(){
        return (top1 < 0);
    }

    public static void main(String[] args){
        OtherSortedStack m = new OtherSortedStack();
        m.push1(1);
        m.push1(3);
        m.push1(4);
        m.push1(2);
        m.printStack();
        m.reverse();
        m.printStack();
    }
}
