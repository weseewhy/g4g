/*
https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance.
Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is [4 2 1 3 7]

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is [2 1 3 6]
*/

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> topView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<DistNode> queue = new LinkedList<>();
        queue.add(new DistNode(root, 0));

        while (!queue.isEmpty()) {
            DistNode cur = queue.remove();
            map.putIfAbsent(cur.dist, cur.node.val);
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

    public class DistNode {
        TreeNode node;
        int dist;

        public DistNode(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
