/*
https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/

An empty tree is height-balanced. 
A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.
*/

class Solution {
    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int diff = Math.abs(height(root.left) - height(root.right));
        return isBalanced(root.left) && isBalanced(root.right) && diff <= 1;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Keep track of height as we traverse
    private class NodeHeight {
        int height;
    }

    public boolean isBalancedTree_Optimized(Node node) {
        return isBalancedTree_Optimized(node, new NodeHeight());
    }

    private boolean isBalancedTree_Optimized(Node node, NodeHeight nh) {
        if (node == null) {
            return true;
        }

        NodeHeight lh = new NodeHeight();
        boolean leftBalanced = isBalancedTree_Optimized(node.left, lh);
        if (!leftBalanced) {
            return false;
        }

        NodeHeight rh = new NodeHeight();
        boolean rightBalanced = isBalancedTree_Optimized(node.right, rh);
        if (!rightBalanced) {
            return false;
        }

        nh.height = 1 + Math.max(lh.height, rh.height);
        return Math.abs(lh.height - rh.height) <= 1;
    }
}
