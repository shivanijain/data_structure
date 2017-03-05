package com.shivani;

/**
 * Created by Jainish on 04-03-2017.
 */
public class CircularLinkedList extends LinkedList {
    public static void main(String[] args) {
        Node lastNode = null;
        CircularLinkedList cll = new CircularLinkedList();
        lastNode = cll.createNode();
        lastNode = cll.insertAtFirst( lastNode, 2);
        lastNode = cll.insertAtEnd( lastNode, 3);
        lastNode = cll.insertAtEnd( lastNode, 4);
        lastNode = cll.insertAtEnd( lastNode, 5);
        lastNode = cll.insertAtEnd( lastNode, 6);
        lastNode = cll.insertAtEnd( lastNode, 7);
        cll.printList(lastNode);
        cll.splitList(lastNode);

    }

    public Node createNode() {
        Node firstNode = new LinkedList().getNodeInstance(1);
        firstNode.next = firstNode;
        return firstNode;
    }

    public Node insertAtFirst( Node lastNode, int data ) {
        Node tempode = new LinkedList().getNodeInstance(data);
        tempode.next = lastNode.next;
        lastNode.next = tempode;
        return lastNode;
    }

    public Node insertAtEnd( Node lastNode, int data) {
        Node tempode = new LinkedList().getNodeInstance(data);
        tempode.next = lastNode.next;
        lastNode.next = tempode;
        lastNode = tempode;
        return lastNode;
    }

    public void splitList(Node lastnode){
        System.out.println("last node data" + lastnode.data);
        System.out.println("firsy node data" + lastnode.next.data);
        Node slow = lastnode.next;
        Node fast = lastnode.next;
        Node mid = null;
        do{
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        } while( !( fast == lastnode || fast == lastnode.next ) );
        lastnode.next = slow;
        if( fast == lastnode ) {
            mid.next = fast.next;
        } else {
            mid.next = fast;
        }
        System.out.println("****************");
        printList( lastnode );
        System.out.println("****************");
        printList( mid );

    }

    public void printList( Node lastnode ) {
        Node node = lastnode.next;
        do{
            System.out.println(node.data);
            node = node.next;
        } while( node != lastnode.next );
    }
}
