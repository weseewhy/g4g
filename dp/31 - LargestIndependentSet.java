/*
https://www.geeksforgeeks.org/largest-independent-set-problem-dp-26/

Given a Binary Tree, find size of the Largest Independent Set(LIS) in it. 
A subset of all tree nodes is an independent set if there is no edge between any two nodes of the subset.
For example, consider the following binary tree. 
              10
             /  \
           20    30
          /  \    \
        40   50    60
            /  \
           70   80  
The largest independent set(LIS) is {10, 40, 60, 70, 80} and size of the LIS is 5.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getLISS(TreeNode node) {
        return getLISS(node, new HashMap<>());
    }

    private int getLISS(TreeNode node, Map<TreeNode, Integer> cache) {
        if (node == null) {
            return 0;
        } else if (cache.containsKey(node)) {
            return cache.get(node);
        } else if (node.left == null && node.right == null) {
            cache.put(node, 1);
            return 1;
        }

        int lissCurNodeExcluded = getLISS(node.left) + getLISS(node.right);

        int lissCurNodeIncluded = 1; // when only cur node
        if (node.left != null) {
            lissCurNodeIncluded += (getLISS(node.left.left) + getLISS(node.left.right));
        }
        if (node.right != null) {
            lissCurNodeIncluded += (getLISS(node.right.left) + getLISS(node.right.right));
        }

        int lissCurNode = Math.max(lissCurNodeExcluded, lissCurNodeIncluded);
        cache.put(node, lissCurNode);
        return lissCurNode;
    }
}
