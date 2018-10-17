/*
https://www.geeksforgeeks.org/print-right-view-binary-tree-2/

Given a Binary Tree, print Right view of it.
Right view of a Binary Tree is set of nodes visible when tree is visited from Right side.

Example:
          1
       /     \
     2        3
   /   \     /  \
  4     5   6    7
                  \
                   8

Output: [1, 3, 7, 8]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> rightView(TreeNode node) {
        List<Integer> out = new ArrayList<>();
        if (node == null) {
            return out;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int curLevelCount = 1;
        int nextLevelCount = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            curLevelCount--;

            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelCount++;
            }

            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelCount++;
            }

            if (curLevelCount == 0) {
                out.add(cur.val);
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }

        return out;
    }
}
