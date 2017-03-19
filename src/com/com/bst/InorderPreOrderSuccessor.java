package com.com.bst;

import java.sql.SQLSyntaxErrorException;

/**
 * Created by Jainish on 15-03-2017.
 */
public class InorderPreOrderSuccessor {

    public int succ = 0;
    public int pre = 0;

    void findinorderpreordersucessor(Node root, int key ){
        if( root == null ) {
            return;
        }
        if( key == root.data ) {
            if( root.left != null ){
                Node temp = root.left;
                while( temp != null ){
                    pre = temp.data;
                    temp = temp.left;
                }
            }

            if( root.right != null ){
                Node temp = root.right;
                while( temp != null ){
                    succ = temp.data;
                    temp = temp.right;
                }
            }
        }

        if( key < root.data ){
            succ = root.data;
            findinorderpreordersucessor( root.left, key );
        } else if( key > root.data ) {
            pre = root.data;
            findinorderpreordersucessor( root.right,key );
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null;
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        root = tree.insert(root,50);
        root = tree.insert(root, 30);
        root = tree.insert(root,20);
        root = tree.insert(root,40);
        root = tree.insert(root,70);
        root = tree.insert(root,60);
        root = tree.insert(root,80);

        // print inorder traversal of the BST
        tree.inorder(root);
        InorderPreOrderSuccessor ipo = new InorderPreOrderSuccessor();
        ipo.findinorderpreordersucessor(root,70);
        System.out.println("successor is " + ipo.succ);
        System.out.println("Predecessor is" + ipo.pre );
    }
}
