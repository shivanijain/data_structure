package com.shivani;

/**
 * Created by Jainish on 21-02-2017.
 */
class DoubleNode{
    int data;
    DoubleNode next;
    DoubleNode prev;
    private DoubleNode(int data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public static DoubleNode getInstance(int data) {
        return new DoubleNode(data);
    }
}

public class DoubleLinkedList {
    static DoubleNode head;

    public void insertFirst( int data) {
        DoubleNode first = DoubleNode.getInstance(data);
        if(head == null ) {
            head = first;
        } else {
            first.next = head;
            head.prev = first;
            head = first;
        }
    }

    public void printLikedlist() {
        DoubleNode node = head;
        while(node != null ) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.printLikedlist();
    }
}


