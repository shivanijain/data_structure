package com.shivani;

/**
 * Created by Jainish on 05-03-2017.
 */
public class ReverseDobleLinkedList extends DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        new ReverseDobleLinkedList().reverseLinkedList(dll);
    }

    public void reverseLinkedList(DoubleLinkedList dll) {
        dll.printLikedlist();

        System.out.println("Head data"+ dll.head.data);
        DoubleNode prev = null,temp = dll.head;
        while( temp != null ) {
            prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            temp = temp.prev;
        }

        if( prev != null ) {
            dll.head = prev.prev;
        }
        System.out.println("*********************************");
        dll.printLikedlist();
    }
}
