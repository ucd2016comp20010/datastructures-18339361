package com.company;

public class Main {
    public static void main(String[] args) {
        /* creating the binary tree
                    2
                   / \
                  1   9
                     /
                    3
                     \
                      6
                     / \
                    5   7
                   /     \
                  4       8
        */

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(1);
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(3);
        tree.root.right.left.right = new Node(6);
        tree.root.right.left.right.left = new Node(5);
        tree.root.right.left.right.right = new Node(7);
        tree.root.right.left.right.left.left = new Node(4);
        tree.root.right.left.right.right.right = new Node(8);

        tree.mirror(); //converts the tree to its mirror image
        print2D(tree.root); //prints the mirror tree on its side
    }

    static final int COUNT = 10;//space between each level
    static void print2DUtil(Node root, int space) {
        // Base case for non existent tree
        if (root == null)
            return;

        // Increasing the distance between levels
        space += COUNT;

        // Processing the right child
        print2DUtil(root.right, space);

        // Print current node after space count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Processing the left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root)
    {
        // Passes initial space count as 0
        print2DUtil(root, 0);
    }
}


