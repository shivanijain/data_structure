package com.shivani;

/**
 * Created by Jainish on 04-03-2017.
 */
public class Reverse extends LinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = ll.getNodeInstance(6);
        ll.head = ll.pushFrontNode(ll.head,5);
        ll.head = ll.pushFrontNode(ll.head,4);
        ll.head = ll.pushFrontNode(ll.head,3);
        ll.head = ll.pushFrontNode(ll.head,2);
        ll.head = ll.pushFrontNode(ll.head,1);
        ll.printLikedlist(ll.head);
        ll.head = new Reverse().reverseLinkedList(ll.head);
        System.out.println("***********************");
        ll.printLikedlist(ll.head);
    }

    public Node reverseLinkedList( Node head) {
        Node current,prev = null,next;
        current = head;
        while( current != null ) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
