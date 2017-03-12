package com.com.tree;

/**
 * Created by Jainish on 11-03-2017.
 */
public class Traversal {

    public void Inorder( Tree root ) {
        if( root == null ) return;
        Inorder( root.left );
        System.out.print( root.data + " " );
        Inorder( root.right );
    }

    public void PostOrder( Tree root) {
        if( root == null ) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void PreOrder( Tree root ) {
        if( root == null ) return;
        System.out.print(root.data+" ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        Traversal t = new Traversal();
        t.Inorder(root);
        System.out.println("********************************PostOrder");
        t.PostOrder(root);
        System.out.println("********************************PreOrder");
        t.PreOrder(root);
    }
}
