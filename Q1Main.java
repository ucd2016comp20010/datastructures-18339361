package com.company;

public class Main {
    public static void main(String[] args) {
	    /* Constructing the tree below
	             1
                / \
               /   \
              /     \
             3       5
            / \     / \
           7   9   11  13
              /      \
            15        17

        */

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(9);
        root.left.right.left= new Node(15);
        root.right.right= new Node(13);
        root.right.left=new Node(11);
        root.right.left.right=new Node(17);


        if (isSymmetric(root)) {
            System.out.print("Tree is symmetrical");
        } else {
            System.out.print("Tree is not symmetrical");
        }
    }

    public static boolean isSymmetric(Node X, Node Y) {
        // base case: if both tree are empty
        if (X == null && Y == null) {
            return true;
        }

        // returns true if
        // both trees are non-empty and
        // left subtree is mirror image of right subtree and
        // right subtree is mirror image of left subtree
        return (X != null && Y != null) && isSymmetric(X.left, Y.right) && isSymmetric(X.right, Y.left);
    }

    // Checks if given Binary Tree has a symmetric structure or not
    public static boolean isSymmetric(Node root) {
        // returns true if left subtree and right subtree are
        // mirror images of each other in terms of structure
        // does not consider node values
        return isSymmetric(root.left, root.right);
    }
}

