package com.company;

public class BinaryTree {
    Node root;

    public void mirror() { //root remains the same
        root = mirror(root);
    }

    Node mirror(Node node) {

        //base case
        if (node == null)
            return null;

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        // swapping the left and right pointers
        node.left = right;
        node.right = left;

        return node;
    }
}