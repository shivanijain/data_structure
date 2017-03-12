package com.com.tree;

/**
 * Created by Jainish on 12-03-2017.
 */
class tree{
    int data;
    tree left;
    tree right;
    tree nextRight;

    tree(int data){
        this.data = data;
        left = right = nextRight = null;
    }
}
public class connectSameLevel {
    void connectSameLevel( tree root ) {
        if( root == null ) return;
        if( root.left != null) {
            root.left.nextRight = root.right;
        }

        if( root.right !=null ){
            root.right.nextRight = ( root.nextRight !=null )?root.nextRight.left:null;
        }
        connectSameLevel(root.left);
        connectSameLevel(root.right);
    }

    public static void main(String args[])
    {
        connectSameLevel csl = new connectSameLevel();
        tree root;
        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        root = new tree(10);
        root.left = new tree(8);
        root.right = new tree(2);
        root.left.left = new tree(3);

        // Populates nextRight pointer in all nodes
        csl.connectSameLevel(root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree" + "(-1 is printed if there is no nextRight)");
        int a = root.nextRight != null ? root.nextRight.data : -1;
        System.out.println("nextRight of " + root.data + " is "
                + a);
        int b = root.left.nextRight != null ?
                root.left.nextRight.data : -1;
        System.out.println("nextRight of " + root.left.data + " is "
                + b);
        int c = root.right.nextRight != null ?
                root.right.nextRight.data : -1;
        System.out.println("nextRight of " + root.right.data + " is "
                + c);
        int d = root.left.left.nextRight != null ?
                root.left.left.nextRight.data : -1;
        System.out.println("nextRight something of " + root.left.left.data + " is "
                + d);

    }
}

