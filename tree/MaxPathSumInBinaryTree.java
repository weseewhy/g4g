/*
https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/

Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
Example:
         10
       /    \
     2       10
   /  \        \
 20   1        -25
                /  \
               3    4
Output: 42 for [20, 2, 10, 10]

Hint:
For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child
*/

class Solution {
    public int maxPathSum(TreeNode root) {
        Result res = new Result();
        maxPathSum(root, res);
        return res.val;
    }

    private int maxPathSum(TreeNode node, Result res) {
        if (node == null) {
            return 0;
        }

        // Max in sub-tree
        int leftSum = maxPathSum(node.left, res);
        int rightSum = maxPathSum(node.right, res);

        // Max in node and one sub-tree
        // We pass this value up the tree so that it can use it in sum-tree sum
        int sumFromRoot = Math.max(node.val, Math.max(leftSum, rightSum) + node.val);

        // Max in node and both sub-trees
        int maxSum = Math.max(sumFromRoot, leftSum + rightSum + node.val);
        if (maxSum > res.val) {
            res.val = maxSum;
        }

        return sumFromRoot;
    }

    private class Result {
        int val;
    }
}
