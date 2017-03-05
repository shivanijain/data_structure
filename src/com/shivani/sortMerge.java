package com.shivani;

import com.shivani.LinkedList;
/**
 * Created by Jainish on 02-03-2017.
 */
public class sortMerge extends LinkedList {

    public static void main(String[] args) {
        Node finalHead = null;
        LinkedList ll = new LinkedList();
        LinkedList ll1 = new LinkedList();
        ll.head = ll.getNodeInstance(14);
        Node secondNode = ll.getNodeInstance(15);
        Node thirdNode = ll.getNodeInstance(16);
        ll.head.next = secondNode;
        secondNode.next = thirdNode;
        ll.head = ll.pushFrontNode(ll.head,12);
        ll.pushEndNode(ll.head,20);
        ll.printLikedlist(ll.head);
        System.out.println("********************************************************");
        ll1.head = ll1.getNodeInstance(4);
        ll1.head = ll1.pushFrontNode(ll1.head,3);
        ll1.printLikedlist(ll1.head);
        System.out.println("********************************************************");
        sortMerge sm = new sortMerge();
        finalHead = sm.mergeSort( ll.head, ll1.head );
        ll1.printLikedlist(finalHead);
    }

    public Node mergeSort( Node head1, Node head2 ) {
        Node finalHead = null ;
        if( head1 == null ) {
            return head2;
        } else if( head2 == null ) {
            return head1;
        } else {
            if( head1.data <= head2.data ) {
                finalHead = head1;
                finalHead.next = mergeSort( head1.next, head2 );
            } else {
                finalHead = head2;
                finalHead.next = mergeSort( head1, head2.next );
            }
        }
        return finalHead;
    }
}

