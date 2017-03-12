package com.com.tree;

/**
 * Created by Jainish on 12-03-2017.
 */
public class printAncestor {
    boolean printAncersotr( Tree root, int target) {
        if( root == null ) return false;
        if( target == root.data) return true;
        if( printAncersotr( root.left,target) || printAncersotr(root.right,target)) {
            System.out.println( root.data+" ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.left.left.left = new Tree(7);
        new printAncestor().printAncersotr(root,7);
    }
}
