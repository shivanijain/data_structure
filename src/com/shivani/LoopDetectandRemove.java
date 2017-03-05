package com.shivani;

/**
 * Created by Jainish on 04-03-2017.
 */
public class LoopDetectandRemove extends LinkedList {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = ll.getNodeInstance(14);
        Node secondNode = ll.getNodeInstance(15);
        Node thirdNode = ll.getNodeInstance(16);
        ll.head.next = secondNode;
        secondNode.next = thirdNode;
        ll.head = ll.pushFrontNode(ll.head,12);
        ll.pushEndNode(ll.head,20);
        ll.printLikedlist(ll.head);
        ll.head.next.next.next.next.next = ll.head.next.next;
        new LoopDetectandRemove().detectAndRemoveLoop( ll.head );
        ll.printLikedlist(ll.head);
    }

    public Node detectAndRemoveLoop( Node head ) {
        Node slow = head;
        Node fast = head.next;

        while( slow != null && fast != null && slow != fast ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if( slow == fast ) {
            System.out.println("Loop detect!!!!!");
            slow = head;
            while( slow != fast.next ) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        return head;
    }
}
