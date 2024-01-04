package com.marinagaisina;

import java.io.BufferedWriter;
import java.io.IOException;

public class MaxDepthInBinaryTree {
    /*
        Given the root of a binary tree, return its maximum depth.
        A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
        farthest leaf node.
        Input Format
        Example 1 Input: root = [3,9,20,15,27] Output: 3
        Example 2 Input: root = [1,2] Output: 2
        Example 3 Input: root = [] Output: 0
        Example 4 Input: root = [0] Output: 1
        Constraints
        The number of nodes in the tree is in the range [0, 10^4].
        -100 <= Node.val <= 100
        Sample Input 0
        2
        1
        2
        Sample Output 0
        2
----------------------------------------------------------------------------------------------------------
     * Complete the 'maxDepth' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_BINARY_SEARCH_TREE root as parameter.
     */
//    public static int maxDepth(BinarySearchTreeNode root) {
//        /*
//         * Write your code here
//         * Function should return only one number - answer
//         */
//

    static class BinarySearchTreeNode {
        public int data;
        public BinarySearchTreeNode left;
        public BinarySearchTreeNode right;

        BinarySearchTreeNode (int nodeData) {
            this.data = nodeData;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        public BinarySearchTreeNode root;

        public BinarySearchTree() {
            this.root = null;
        }

        public void insertNode(int nodeData) {
            this.root = this.insertNode(this.root, nodeData);
        }

        private BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int nodeData) {
            if (root == null) {
                root = new BinarySearchTreeNode(nodeData);
            } else {
                if (nodeData <= root.data) {
                    root.left = this.insertNode(root.left, nodeData);
                } else {
                    root.right = this.insertNode(root.right, nodeData);
                }
            }

            return root;
        }
    }

    class BinarySearchTreePrintHelper {
        public void printInorder(BinarySearchTreeNode root, String sep, BufferedWriter bufferedWriter) throws IOException {
            if (root == null) {
                return;
            }

            this.printInorder(root.left, sep, bufferedWriter);

            if (root.left != null) {
                bufferedWriter.write(sep);
            }

            bufferedWriter.write(String.valueOf(root.data));

            if (root.right != null) {
                bufferedWriter.write(sep);
            }

            this.printInorder(root.right, sep, bufferedWriter);
        }
    }


}