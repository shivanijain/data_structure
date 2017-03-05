package com.shivani;
import com.shivani.Cqueue;
/**
 * Created by Jainish on 23-02-2017.
 */

public class CStack {
    static Node head;

    public void push( Node head, int data ) {

        Node newNode = Node.getInstance( data );
        if( CStack.head == null )
        {
            CStack.head = newNode;
            return;
        }

        Node temp = CStack.head;
        while( temp.next !=null ) {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public Node pop(Node head){
        System.out.println(head.data + "data is pop.");
        head = head.next;
        return head;
    }

    public void printLikedlist( Node node ) {
        while(node != null ) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public int getCount( Node node) {
        if( node == null )  return 0;
        return 1 + getCount( node.next );
    }

    public void MiddleElement(int index) {
        Node temp  = CStack.head;
        int count = 0;
        while( temp != null ){
            if( index == count ) {
                System.out.println( temp.data);
            }
            temp = temp.next;
            count++;
        }
        System.out.print(index);
    }

    public static void main(String[] args) {
        CStack cs = new CStack();
        cs.push(CStack.head,1);
        cs.push(CStack.head,2);
        cs.push(CStack.head,3);
        cs.push(CStack.head,4);
        cs.push(CStack.head,5);
        cs.printLikedlist(CStack.head);
        CStack.head = cs.pop(CStack.head);
        cs.printLikedlist(CStack.head);
        int toalCount = cs.getCount(CStack.head);
        System.out.println("total size"+cs.getCount(CStack.head));
        cs.MiddleElement( toalCount/2 );
    }
}
