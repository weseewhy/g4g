/*
https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

Given two binary trees, check if the first tree is subtree of the second one.
A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.
The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.

For example, in the following case, tree S is a subtree of tree T.

        Tree 2
          10
        /    \
      4       6
       \
        30


        Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30
*/

class Solution {
    public boolean isSubTree(TreeNode tree, TreeNode sub) {
        if (sub == null) {
            return true;
        } else if (tree == null) {
            return false;
        }

        return areSame(tree, sub)
                || isSubTree(tree.left, sub)
                || isSubTree(tree.right, sub);
    }

    private boolean areSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val
                && areSame(t1.left, t2.left)
                && areSame(t1.right, t2.right);
    }
}
