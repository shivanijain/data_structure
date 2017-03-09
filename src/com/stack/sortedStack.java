package com.stack;

/**
 * Created by Jainish on 09-03-2017.
 */
public class sortedStack extends Stack {
    Stack stack = new Stack();
    Stack temp = null;
    public static void main(String[] args) {
        sortedStack ss = new sortedStack();
        ss.stack.push(2);
        ss.stack.push(14);
        ss.stack.push(1);
        ss.stack.push(7);
        try{
            ss.temp = (Stack) ss.stack.clone();
        } catch(Exception e) {
            System.out.println(e);
        }

        ss.printStack(ss.stack);
        ss.sortStack();
        ss.printStack(ss.temp);
    }

    public void printStack(Stack temp) {
        while( false == temp.isEmpty() ) {
            System.out.print(temp.pop() + " ");
        }
        System.out.println("****************************");
    }

    public void sortStack() {
        if( false == temp.isEmpty() ) {
            int tempdata = temp.pop();
            sortStack();
            sortInserted(tempdata);
        }
    }

    public void sortInserted( int tempdata ){
        if( true == temp.isEmpty() || tempdata > temp.top() ) {
            temp.push(tempdata);
            return;
        } else {
            int tempData = temp.pop();
            sortInserted(tempdata);
            temp.push(tempData);
        }
    }
}
