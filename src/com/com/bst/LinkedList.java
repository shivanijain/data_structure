package com.com.bst;

/**
 * Created by Jainish on 18-03-2017.
 */
class NewNode
{
    int data;
    NewNode next, prev;

    NewNode(int d)
    {
        data = d;
        next = prev = null;
    }
}

class LinkedList
{
    NewNode head;
    NewNode root;
    /* This function counts the number of nodes in Linked List
    and then calls sortedListToBSTRecur() to construct BST */
    NewNode sortedListToBST()
    {
		/*Count the number of nodes in Linked List */
        int n = countNodes(head);

		/* Construct BST */
        return sortedListToBSTRecur(n);
    }

    /* The main function that constructs balanced BST and
    returns root of it.
    n --> No. of nodes in the Doubly Linked List */
    NewNode sortedListToBSTRecur(int n)
    {
		/* Base Case */
        if (n <= 0)
            return null;

		/* Recursively construct the left subtree */
        NewNode left = sortedListToBSTRecur(n / 2);

		/* head_ref now refers to middle node,
		make middle node as root of BST*/
        NewNode root = head;

        // Set pointer to left subtree
        root.prev = left;

		/* Change head pointer of Linked List for parent
		recursive calls */
        head = head.next;

		/* Recursively construct the right subtree and link it
		with root. The number of nodes in right subtree is
		total nodes - nodes in left subtree - 1 (for root) */
        root.next = sortedListToBSTRecur(n - n / 2 - 1);

        return root;
    }

    /* UTILITY FUNCTIONS */
	/* A utility function that returns count of nodes in a
	given Linked List */
    int countNodes(NewNode head)
    {
        int count = 0;
        NewNode temp = head;
        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    NewNode KPositionFromLinkedList( NewNode head, int position ) {
        int index = 0;
        while( head.next != null ) {
            if( index == position ) {
                return head;
            }
            head=head.next;
            index++;
        }
        return head;
    }

    NewNode dllToBstUtil(int size){
        if(size == 0) {
            return null;
        }

        NewNode left= dllToBstUtil(size/2);
        NewNode root = head;
        root.prev= left;
        head = head.next;

        root.next = dllToBstUtil(size-(size/2)-1);

        return root;
    }

    /* Function to insert a node at the beginging of
    the Doubly Linked List */
    void push(int new_data)
    {
		/* allocate node */
        NewNode new_node = new NewNode(new_data);

		/* since we are adding at the begining,
		prev is always NULL */
        new_node.prev = null;

		/* link the old list off the new node */
        new_node.next = head;

		/* change prev of head node to new node */
        if (head != null)
            head.prev = new_node;

		/* move the head to point to the new node */
        head = new_node;
    }

    /* Function to print nodes in a given linked list */
    void printList()
    {
        NewNode node = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(NewNode node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.prev);
        preOrder(node.next);
    }

    /* Drier program to test above functions */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();

		/* Let us create a sorted linked list to test the functions
		Created linked list will be 7->6->5->4->3->2->1 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List ");
        llist.printList();

		/* Convert List to BST */
       // NewNode root = llist.sortedListToBST();
        llist.root = llist.dllToBstUtil(llist.countNodes( llist.head));
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(llist.root);
    }
}
// This code has been contributed by Mayank Jaiswal(mayank_24)

