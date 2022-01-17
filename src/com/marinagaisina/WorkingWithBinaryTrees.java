package com.marinagaisina;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        if (root.left!=null) {
            preOrder(root.left);
        }
        if (root.right!=null) {
            preOrder(root.right);
        }
    }
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        if (root.left!=null) {
            postOrder(root.left);
        }
        if (root.right!=null) {
            postOrder(root.right);
        }
        System.out.print(root.data+" ");
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int countLeft = 0;
        int countRight =0;
        if (root.left != null) {
            countLeft = 1 + height(root.left);
        }
        if (root.right != null) {
            countRight = 1+ height(root.right);
        }
        return Math.max(countLeft, countRight);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println(height(root));
    }
}