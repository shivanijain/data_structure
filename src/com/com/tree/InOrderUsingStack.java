package com.com.tree;

import java.util.Stack;

/**
 * Created by Jainish on 11-03-2017.
 */
public class InOrderUsingStack {
    Stack<Tree> stack = new Stack<>();
    void inorder(Tree root) {
        if (root == null) {
            return;
        }

        //keep the nodes in the path that are waiting to be visited
        Tree node = root;

        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        // traverse the tree
        while (stack.size() > 0) {

            // visit the top node
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        new InOrderUsingStack().inorder(root);
    }
}
