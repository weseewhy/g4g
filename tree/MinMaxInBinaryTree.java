/*
https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/

Given a Binary Tree, find maximum(or minimum) element in it
*/

class Solution {
    public int[] findMinMax(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = findMinMax(node.left);
        int[] right = findMinMax(node.right);
        int[] out = new int[2];
        out[0] = Math.min(Math.min(left[0], right[0]), node.val);
        out[1] = Math.max(Math.max(left[1], right[1]), node.val);
        return out;
    }
}
