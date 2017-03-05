package com.shivani;

/**
 * Created by Jainish on 21-02-2017.
 */
public class LinkedList {
    Node head;
    static int count = 0;
    class Node {
        int data;
        Node next;

        Node( int d ){
            this.data = d;
            this.next = null;
        }
    }

    Node getNodeInstance(int data) {
        return new Node(data);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = ll.getNodeInstance(1);
        Node secondNode = ll.getNodeInstance(2);
        Node thirdNode = ll.getNodeInstance(3);
        ll.head.next = secondNode;
        secondNode.next = thirdNode;

        ll.printLikedlist(ll.head);
        System.out.println("*********************************");
        ll.head = ll.pushFrontNode(ll.head,12);

        ll.printLikedlist(ll.head);

        System.out.println("*********************************");
        ll.pushEndNode(ll.head,15);

        ll.printLikedlist(ll.head);

        ll.deleteNode(ll.head,15);
        System.out.println("*********************************");
        ll.printLikedlist(ll.head);
        ll.deleteNodeAtPosition(ll.head,3);
        System.out.println("*********************************");
        ll.printLikedlist(ll.head);
        System.out.println("*********************************");
       ll.head = ll.reverse(ll.head);
        ll.printLikedlist(ll.head);
    }

    public void printLikedlist( Node node ) {
        while(node != null ) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public Node pushFrontNode(Node head,int data) {
        Node newNode = new LinkedList().getNodeInstance(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public void pushEndNode(Node head,int data) {
        Node newNode = new LinkedList().getNodeInstance(data);
        Node node = head;
        while( node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }

    public Node deleteNode( Node head, int key) {
        Node temp = head;
        Node prev = null;
        if( head != null && head.data == key ) {
            head = temp.next;
        }

        while( temp!=null && temp.data != key ) {
            prev = temp;
            temp = temp.next;
        }

        if( temp == null ) return head;

        prev.next = temp.next;
        return head;
    }

    public Node deleteNodeAtPosition( Node head, int position) {

        Node temp = head;
        Node prev = null;
        int pos = 0;
        if( position == 0 ) {
           head = head.next;
           return head;
        }

        while( temp != null && pos != position ) {
            pos++;
            prev= temp;
            temp = temp.next;
        }

        if( temp == null ) return head;
        prev.next = temp.next;
        return head;
    }

    public int getCount(Node head) {
        if( head == null )  return LinkedList.count = 0;
         return LinkedList.count + getCount( head.next );
    }

    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
