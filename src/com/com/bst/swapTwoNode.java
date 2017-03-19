package com.com.bst;

/**
 * Created by Jainish on 17-03-2017.
 */
public class swapTwoNode {
    Node first = null, middle = null , last = null, prev = null;

    public void swap( Node root1, Node root2 ) {
        int temp = root2.data;
        root2.data = root1.data;
        root1.data = temp;
    }

    void correctBST( Node root )
    {
        // Initialize pointers needed for correctBSTUtil(

        // Set the poiters to find out two nodes
        correctBSTUtil( root);

        // Fix (or correct) the tree
        if( first != null && last != null )
            swap( first, last );
    else if( first != null && middle !=null ) // Adjacent nodes swapped
        swap( first, middle );

        // else nodes have not been swapped, passed tree is really BST.
    }

    public void correctBSTUtil(Node root) {
        if( root == null ) return;
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left );

            // If this node is smaller than the previous node, it's violating
            // the BST rule.
            if ( prev != null && root.data < prev.data)
            {
                // If this is first violation, mark these two nodes as
                // 'first' and 'middle'
                if ( first == null )
                {
                first = prev;
                middle = root;
                }

                // If this is second violation, mark this node as last
                else
                last = root;
            }

            // Mark this node as previous
        prev = root;

            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }

    int Ceil( Node root, int key) {
        if( root == null ) return -1;

        if(root.data == key ) {
            return root.data;
        }

        if( root.data < key ){
            Ceil( root.right, key);
        }
        int c =  Ceil( root.left , key);
        return ( c >= key ) ? c : root.data;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = new Node(6);
        root.left        = new Node(10);
        root.right       = new Node(2);
        root.left.left  = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        System.out.println("Inorder Traversal of the original tree \n");
        bst.inorder(root);

        new swapTwoNode().correctBST(root);

        System.out.println("\nInorder Traversal of the fixed tree \n");
        bst.inorder(root);

        for (int i = 0; i < 16; i++) {
            System.out.println(i + " " + new swapTwoNode().Ceil(root, i));
        }

    }
}
