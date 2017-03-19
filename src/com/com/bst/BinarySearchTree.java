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

    public Node delete(Node root,int key){
        if( root == null ) return root;

        if( key < root.data ) {
            root.left = delete(root.left,key);
        } else if( key > root.data ) {
            root.right = delete(root.right,key);
        } else {
            if( root.left == null && root.right == null ){
                //means deleted node have no children
                root = null;
                return root;
            }

            if( root.left == null ){
                // means deleted node have one right children.
                return root.right;
            } else if( root.right == null ){
                // means deleted node have one left children.
                return root.left;
            } else {
                //means deleted node have 2 children
                int keyValue = minValue(root.right);
                root.data = keyValue;
                root.right =  delete(root.right,keyValue);
            }
        }

        return root;
    }

    public int minValue(Node rightNode){
        int minValue = rightNode.data;
        while( rightNode.left != null){
            minValue = rightNode.left.data;
            rightNode = rightNode.left;
        }
        return minValue;
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
        root = tree.insert(root,12);
        root = tree.insert(root, 5);
        root = tree.insert(root,15);
        root = tree.insert(root,3);
        root = tree.insert(root,1);
        root = tree.insert(root,7);
        root = tree.insert(root,9);
        root = tree.insert(root,8);
        root = tree.insert(root,11);
        root = tree.insert(root,13);
        root = tree.insert(root,14);
        root = tree.insert(root,17);
        root = tree.insert(root,20);
        root = tree.insert(root,18);
        root = tree.insert(root,16);


        // print inorder traversal of the BST
        tree.inorder(root);

        tree.search(root,5);

        root = tree.delete(root,15);
        System.out.println("after deletion");
        System.out.println("***************************");
        tree.inorder(root);
    }
}
