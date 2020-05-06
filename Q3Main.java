package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /* Creating the binary tree
                      44
                    /    \
                   /      \
                  /        \
                 /          \
                17          88
               /  \       /     \
              8   32     65      97
                  /     /  \    /
                 28    54  82  93
                /  \      /
               21  29    76
                           \
                           80
        */
        Node root = new Node(44);
        root.left = new Node(17);
        root.right = new Node(88);
        root.left.left = new Node(8);
        root.left.right = new Node(32);
        root.left.right.left = new Node(28);
        root.left.right.left.left = new Node(21);
        root.left.right.left.right = new Node(29);

        root.right.left = new Node(65);
        root.right.right = new Node(97);
        root.right.right.left = new Node(93);
        root.right.left.left = new Node(54);
        root.right.left.right = new Node(82);
        root.right.left.right.left = new Node(76);
        root.right.left.right.left.right = new Node(80);

        //Getting user input for which two nodes they want the distance between
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first node value");
        int num1 = scanner.nextInt();
        System.out.println("Enter second node value");
        int num2 = scanner.nextInt();
        System.out.println("The distance is: " + treeDistance(root, num1, num2));
    }

    //finds distance from root to node1 and node2 and adds them to get total distance
    public static int treeDistance(Node root, int node1, int node2) {
        if (root == null) return -1;
        Node lca = lca(root, node1, node2);
        return dist(lca, node1) + dist(lca, node2);
    }

    //gets distance between two points
    private static int dist(Node src, int dest) {
        if (src.data == dest) return 0;
        Node node = src.left;
        if (src.data < dest) {
            node = src.right;
        }
        return 1 + dist(node, dest);
    }

    //finds lowest common ancestor
    public static Node lca(Node root, int node1, int node2) {
        while (true) {
            if (root.data > node1 && root.data > node2) {
                root = root.left;
            } else if (root.data < node1 && root.data < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}

