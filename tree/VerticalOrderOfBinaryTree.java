/*
https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

Given a binary tree, print it vertically. 
The following example illustrates vertical order traversal.
           1
        /    \
       2      3
      / \   /   \
     4   5  6   7
               /  \
              8   9

The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
*/

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> topView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<DistNode> queue = new LinkedList<>();
        queue.add(new DistNode(root, 0));

        while (!queue.isEmpty()) {
            DistNode cur = queue.remove();
            map.putIfAbsent(cur.dist, new ArrayList<>());
            map.get(cur.dist).add(cur.node.val);
            if (cur.node.left != null) {
                queue.add(new DistNode(cur.node.left, cur.dist - 1));
            }
            if (cur.node.right != null) {
                queue.add(new DistNode(cur.node.right, cur.dist + 1));
            }
        }

        return map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private class DistNode {
        TreeNode node;
        int dist;

        DistNode(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
