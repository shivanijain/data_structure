package com.com.queue;

/**
 * Created by Jainish on 10-03-2017.
 */
 class Queue{
    public final static int MAX_INT = 100;
    int arr[] = new int[MAX_INT];
    int rear = -1;
    int front = 0;
    int size = 0;

    public void enQueue( int data) {
        if( rear >= MAX_INT ) {
            System.out.print("Underflow");
            return;
        }
        rear  = rear+1;
        arr[rear] = data;
        size++;
       // System.out.println(data+" is enqueued.");
    }

    public int deQueue(){
        if( front == MAX_INT ) {
            System.out.print("overflow");
            return -1;
        }
        int data = arr[front];
        front = front+1;
        size--;
        return data;
    }

    public int rear() {
        return arr[rear];
    }

    public int front() {
        return arr[front];
    }

}
public class CQueue {
    public static void main(String[] args) {
        Queue qu = new Queue();
        qu.enQueue(1);
        qu.enQueue(4);
        qu.enQueue(5);
        qu.enQueue(7);
        System.out.println(qu.deQueue() + " is dequeued");
        System.out.println(qu.deQueue() + " is dequeued");

        System.out.print("++++++++++++++++++++++++++++++++");
        new CQueue().fibonaci();
    }

    public void fibonaci(){
        Queue q = new Queue();
        q.enQueue(0);
        q.enQueue(1);
        for (int i = 0; i < 10; i++) {
            int a = q.deQueue();
            int b = q.deQueue();
            q.enQueue(b);
            q.enQueue(a + b);
            System.out.println(a);
        }
    }
}
