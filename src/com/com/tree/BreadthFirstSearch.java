package com.com.tree;

/**
 * Created by Jainish on 11-03-2017.
 */
public class BreadthFirstSearch {

    public void printLevelOrder(Tree root) {
        for(int i=1;i<=height(root);i++) {
            printGivenLevel(root,i);
        }
    }

    private void printGivenLevel(Tree root, int level) {
        if( root == null ) return;
        if( level == 1){ System.out.print(root.data + " "); return;}
        else{
            printGivenLevel(root.left,level-1);
            printGivenLevel(root.right,level-1);
        }
    }

    public int height(Tree root){
        if( root == null ) return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if( lheight > rheight)
                return lheight+1;
            else
                return rheight+1;
        }
    }
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.printLevelOrder(root);
    }
}
