package com.com.bst;

/**
 * Created by Jainish on 18-03-2017.
 */
public class tempSwapTwoNodes {
    static void swap( Node root1, Node root2 ) {
        int temp = root2.data;
        root2.data = root1.data;
        root1.data = temp;
    }

    static Node correctBST(Node root){
        if(root!=null){
            Node left = correctBST(root.left);
            if(left!=null && left.data > root.data){
                Node rightMin = getReplaceOfLeft(root.right, root, left);
                if(rightMin==null) rightMin=root;
                swap(left, rightMin);
            }
            Node right = correctBST(root.right);
            if(right!=null) return right;
            else return root;
        }
        return null;
    }

    private static Node getReplaceOfLeft(Node root, Node parent, Node left) {
        if(root!=null){
            boolean found = false;
            while(!found){
                if(root.data < parent.data) found = true;
                else if(root.data < left.data && root.right!=null) root = root.right;
                else if(root.left!=null) root = root.left;
                else if(root.right == null && root.left == null) found = true;
            }
            return root;
        }
        return null;
    }
}
