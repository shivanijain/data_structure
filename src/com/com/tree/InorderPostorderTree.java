package com.com.tree;

/**
 * Created by Jainish on 12-03-2017.
 */
public class InorderPostorderTree {
    Tree root;
    static int preIndex = 0;
    public static void main(String[] args) {
        InorderPostorderTree tree = new InorderPostorderTree();
        Traversal t = new Traversal();
        int[] inorder = {1, 2, 3, 4, 5, 6};
        int[] preorder = {4, 2, 1, 3,6, 5};
        int endlen = inorder.length;
        Tree node = tree.buildTree(inorder, preorder, 0, endlen - 1);
        t.Inorder(node);
    }

    int search(int[] inorder,int data, int startInorderIndex, int endInorderIndex) {
        int j;
        for(j=startInorderIndex;j<=endInorderIndex;j++){
            if(inorder[j] == data) return j;
        }
        return j;
    }

     Tree buildTree(int[] inorder, int[] preorder, int startIndex, int endIndex) {
        Tree tNode = null;
        if( startIndex > endIndex ) return null;

        tNode = new Tree(preorder[preIndex++]);

        if(startIndex == endIndex ) return tNode;

        int inIndex = search(inorder,tNode.data,startIndex,endIndex);

        tNode.left = buildTree(inorder,preorder,startIndex,inIndex-1);
        tNode.right = buildTree(inorder,preorder,inIndex+1,endIndex);
        return tNode;
    }
}
