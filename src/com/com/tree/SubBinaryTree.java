package com.com.tree;

/**
 * Created by Jainish on 12-03-2017.
 */
public class SubBinaryTree {
    Tree root1,root2;
    boolean areIdentical( Tree root1, Tree root2 ) {
        if( root1 == null && root2 == null ) return true;
        if( root1 == null || root2 == null ) return false;

        return ( root1.data == root2.data && areIdentical(root1.left,root2.left) && areIdentical( root1.right,root2.right ));
    }

    boolean isSubtree( Tree T, Tree S) {
        if( S == null ) return true;
        if( T == null ) return false;
        if( areIdentical(T,S)) return true;

        return ( isSubtree(T.left,S) || isSubtree(T.right,S) );
    }

    public static void main(String[] args) {
        SubBinaryTree tree = new SubBinaryTree();
        tree.root1 = new Tree(26);
        tree.root1.right = new Tree(3);
        tree.root1.right.right = new Tree(3);
        tree.root1.left = new Tree(10);
        tree.root1.left.left = new Tree(4);
        tree.root1.left.left.right = new Tree(30);
        tree.root1.left.right = new Tree(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.root2 = new Tree(10);
        tree.root2.right = new Tree(6);
        tree.root2.left = new Tree(4);
        tree.root2.left.right = new Tree(30);

        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");

    }
}
