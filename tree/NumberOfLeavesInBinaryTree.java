/*
https://www.geeksforgeeks.org/iterative-program-count-leaf-nodes-binary-tree/

Given a binary tree, count leaves in the tree without using recursion. 
A node is a leaf node if both left and right children of it are NULL.
*/

import java.util.LinkedList;

class Solution {

    public int countLeaves_Recursive(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeaves_Recursive(root.left) + countLeaves_Recursive(root.right);
        }
    }

    public int countLeaves_NonRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leafCount = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();

            if (cur.left == null && cur.right == null) {
                leafCount++;
            } else {
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        return leafCount;
    }
}
