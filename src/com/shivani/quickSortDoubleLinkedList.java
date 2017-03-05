package com.shivani;

/**
 * Created by Jainish on 05-03-2017.
 */
public class quickSortDoubleLinkedList {
    Node head;

    /* a node of the doubly linked list */
    static class Node{
        private int data;
        private Node next;
        private Node prev;

        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    // A utility function to find last node of linked list
    Node lastNode(Node node){
        while(node.next!=null)
            node = node.next;
        return node;
    }

    public void printList(Node node)
    {
        Node temp = node;
        System.out.println("Forward Traversal using next pointer");
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    /* Function to insert a node at the beginging of the Doubly Linked List */
    void push(int new_Data)
    {
        Node new_Node = new Node(new_Data);     /* allocate node */

        // if head is null, head = new_Node
        if(head==null){
            head = new_Node;
            return;
        }

        /* link the old list off the new node */
        new_Node.next = head;

        /* change prev of head node to new node */
        head.prev = new_Node;

        /* since we are adding at the begining, prev is always NULL */
        new_Node.prev = null;

        /* move the head to point to the new node */
        head = new_Node;
    }

    /* Driver program to test above function */
    public static void main(String[] args){
        quickSortDoubleLinkedList list = new quickSortDoubleLinkedList();


        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);


        System.out.println("Linked List before sorting ");
        list.printList(list.head);
        System.out.println("\nLinked List after quick sort sorting");
        list.quickSort(list.head);
        list.printList(list.head);
        System.out.println("\nLinked List after merge sort sorting");
        list.head = list.mergeSort(list.head);
        list.printList(list.head);
    }

    public void quickSort( Node startnode) {
        // Find last node
        Node lastNode = lastNode(startnode);

        // Call the recursive QuickSort
        _quickSort(startnode,lastNode);
    }

    public void _quickSort(Node startNode, Node lastNode){
        if( startNode!=lastNode.next && lastNode!=null && startNode!=lastNode ) {
            Node partitionNode = partition(startNode,lastNode);
            _quickSort(startNode,partitionNode.prev);
            _quickSort(partitionNode.next,lastNode);
        }
    }

    public Node partition(Node startNode, Node endNode) {
        Node partitionNode = startNode.prev;
        int data = endNode.data;
        for(Node j=startNode;j!=endNode;j=j.next) {
            if(j.data<=data){
                partitionNode = (partitionNode == null)? startNode: partitionNode.next;
                int temp = partitionNode.data;
                partitionNode.data = j.data;
                j.data = temp;
            }
        }
        partitionNode = (partitionNode==null) ? startNode : partitionNode.next;  // Similar to i++
        int temp = partitionNode.data;
        partitionNode.data = endNode.data;
        endNode.data = temp;

        return partitionNode;
    }

    //split List into half for merge sort
    public Node splitList(Node head) {
        Node slow = head, fast = head;
        while( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        return mid;
    }

    Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node mid = splitList(node);
        // Recur for left and right halves
        node = mergeSort(node);
        mid = mergeSort(mid);

        // Merge the two sorted halves
        return merge(node, mid);
    }

    Node merge(Node first,Node second) {
        if(first == null ) {
            return second;
        }
        if(second == null ) {
            return first;
        }
        if( first.data < second.data ){
            first.next = merge( first.next,second );
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first,second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}
