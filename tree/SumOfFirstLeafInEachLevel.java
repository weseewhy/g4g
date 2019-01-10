/*
Find the sum of first leaves in each level
First leaf is the first leaf node encountered when traversing from left to right in each level
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        curLevel.add(root);
        boolean leftLeafFound = false;

        while (!curLevel.isEmpty()) {
            TreeNode cur = curLevel.poll();

            if (cur.left == null && cur.right == null) {
                if (!leftLeafFound) {
                    leftLeafFound = true;
                    sum += cur.val;
                }
            } else {
                if (cur.left != null) {
                    nextLevel.add(cur.left);
                }

                if (cur.right != null) {
                    nextLevel.add(cur.right);
                }
            }

            if (curLevel.isEmpty() & !nextLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<>();
                leftLeafFound = false;
            }
        }

        return sum;
    }
}
