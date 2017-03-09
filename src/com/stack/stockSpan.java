package com.stack;

/**
 * Created by Jainish on 09-03-2017.
 */
public class stockSpan extends Stack {

    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int span[] = new int[price.length];
        stockSpan sp = new stockSpan();
        sp.calculateSpan(price,price.length,span);
        sp.printStack(span);
    }

    public void printStack(int span[]) {
       for(int i=0;i<span.length;i++){
           System.out.println(span[i]+" ");
       }
    }

    public void calculateSpan( int price[],int n, int span[]) {
        Stack s = new Stack();
        s.push(0);
        span[0] = 1;
        for(int i=1; i<n ; i++){
            while( false == s.isEmpty() && price[s.top()] < price[i]) {
                s.pop();
            }

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
            // is greater than elements after top of stack
            span[i] = (s.isEmpty())? (i + 1) : (i - s.top());

            // Push this element to stack
            s.push(i);
        }
    }
}
