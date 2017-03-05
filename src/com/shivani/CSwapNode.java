package com.shivani;


/**
 * Created by Jainish on 23-02-2017.
 */

class NewNode {
    int data;
    NewNode next;

    NewNode( int data ) {
        this.data = data;
    }
}

public class CSwapNode {
    NewNode head;

    public void swapNode( int x, int y) {
        // Nothing to do if x and y are same
        if (x == y) return;

        // Search for x (keep track of prevX and CurrX)
        NewNode prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        NewNode prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        NewNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }

    public NewNode pushFrontNode(NewNode head,int data) {
        NewNode newNode = new NewNode( data );
        newNode.next = head;
        head = newNode;
        return head;
    }

    public void printLikedlist( NewNode node ) {
        while(node != null ) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        CSwapNode sw = new CSwapNode();
        sw.head = sw.pushFrontNode(sw.head,1);
        sw.head = sw.pushFrontNode(sw.head,2);
        sw.head = sw.pushFrontNode(sw.head,3);
        sw.head = sw.pushFrontNode(sw.head,4);
        sw.printLikedlist(sw.head);
        sw.swapNode(2,3);
        System.out.println("******************************************************");
        sw.printLikedlist(sw.head);
    }
}
