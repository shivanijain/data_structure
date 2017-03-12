package com.com.bst;

/**
 * Created by Jainish on 12-03-2017.
 */
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class BinarySearchTree {

    public void inorder(Node root){
        if( root == null ) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public void search( Node root, int key) {
        if( root == null ) { System.out.println("No data found."); return;}
        if( root.data == key ){
            System.out.println("data is found.");
        }else if( key < root.data ){
            search(root.left,key);
        } else if( key > root.data ){
            search( root.right,key);
        } else {
            System.out.println("No data found.");
        }
    }

    public Node insert(Node root,int key){
        if( root == null ) return new Node(key);

        if( root.data < key ) {
            root.right = insert(root.right,key);
        } else if( key < root.data ) {
            root.left = insert(root.left,key);
        }
        return root;
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

        tree.search(root,5);
    }
}
