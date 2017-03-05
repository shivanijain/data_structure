package com.shivani;

import com.sun.org.apache.bcel.internal.util.ClassQueue;

/**
 * Created by Jainish on 21-02-2017.
 */
class Node{
    int data;
    Node next;
    private Node(int data) {
        this.data = data;
        next = null;
    }

    public static Node getInstance(int data) {
        return new Node(data);
    }
}
public class Cqueue {
    static Node front;
    static Node rear;

    public void push(Node node) {
        if( front == null && rear == null ) {
            front = node;
            rear = node;
            System.out.println( rear.data + "entered up.");
        } else {
            rear.next = node;
            rear = rear.next;
            System.out.println( rear.data + "entered up.");
        }
    }

    public void pop() {
        if( front == null ){
            System.out.println("queue is finished");
        } else if( front == rear) {
            System.out.println( front.data + "poped up.");
            front = rear = null;
        } else {
            System.out.println( front.data + "poped up.");
            front = front.next;
        }
    }

    public static void main(String[] args) {
        Cqueue queue = new Cqueue();
        queue.front = queue.rear = null;
        Node first = Node.getInstance(1);
        Node second = Node.getInstance(2);
        Node third = Node.getInstance(3);
        queue.push(first);
        queue.push(second);
        queue.pop();
        queue.push(third);
        queue.pop();
        queue.pop();
    }
}
