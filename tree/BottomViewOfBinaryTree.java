/*
Given a Binary Tree, we need to print the bottom view from left to right. 
A node x is there in output if x is the bottommost node at its horizontal distance. 
Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, 
and that of right child is horizontal distance of x plus 1.

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \      
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.
If there are multiple bottom-most nodes for a horizontal distance from root, 
then print the later one in level traversal.  
For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.
                   
                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \      
                  10    14

For the above tree the output should be 5, 10, 4, 14, 25.
*/

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> bottomView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<DistNode> queue = new LinkedList<>();
        queue.add(new DistNode(root, 0));

        while (!queue.isEmpty()) {
            DistNode cur = queue.remove();
            map.put(cur.dist, cur.node.val);
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
