/*
https://www.geeksforgeeks.org/print-left-view-binary-tree/

Given a Binary Tree, print left view of it.
Left view of a Binary Tree is set of nodes visible when tree is visited from left side.

Example:
             4
           /  \
          5    2
              / \
             3   1
            / \
           6   7

Output: [4, 5, 3, 6]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> leftView(TreeNode node) {
        List<Integer> out = new ArrayList<>();
        if (node == null) {
            return out;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        boolean firstInLevel = true;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                firstInLevel = true;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }

            if (firstInLevel) {
                out.add(cur.val);
                firstInLevel = false;
            }

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

        return out;
    }
}
