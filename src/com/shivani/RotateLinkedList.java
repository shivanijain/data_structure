package com.shivani;

/**
 * Created by Jainish on 04-03-2017.
 */
public class RotateLinkedList extends LinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = ll.getNodeInstance(6);
        ll.head = ll.pushFrontNode(ll.head,5);
        ll.head = ll.pushFrontNode(ll.head,4);
        ll.head = ll.pushFrontNode(ll.head,3);
        ll.head = ll.pushFrontNode(ll.head,2);
        ll.head = ll.pushFrontNode(ll.head,1);
        ll.printLikedlist(ll.head);
        ll.head = new RotateLinkedList().rotateLinkedList(ll.head,0);
        System.out.println("**************************");
        ll.printLikedlist(ll.head);
    }

    public Node rotateLinkedList( Node head, int k) {
        Node finalHead = null ;
        int index = 0;
        Node temp,searchNode = null;
        temp = head;
        while( temp.next != null) {
            if( index == k ) {
                searchNode = temp;
            }
            temp = temp.next;
            index++;
        }
        finalHead = searchNode.next;
        temp.next = head;
        searchNode.next = null;
        return finalHead;
    }
}
