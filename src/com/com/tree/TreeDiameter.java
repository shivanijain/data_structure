package com.com.tree;

/**
 * Created by Jainish on 11-03-2017.
 */
public class TreeDiameter {
    int diameter(Tree root) {
        if( root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));
    }

    public int height(Tree root) {
        if( root == null) return 0;
        return ( 1 + Math.max(height(root.left),height(root.right)));
    }
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        System.out.println("diameter"+new TreeDiameter().diameter(root));
    }
}
