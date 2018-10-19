/*
https://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void allPathsAndMaxSumPath(TreeNode root) {
        Result result = new Result();
        traverse(root, new PathHolder(), result);
        System.out.println("Max path sum = " + result.maxSum);
        System.out.println("Path with max sum = " + result.maxSumPath);
        System.out.println("All paths: ");
        result.allPaths.forEach(System.out::println);
    }

    private void traverse(TreeNode node, PathHolder curPath, Result result) {
        curPath.append(node.val);

        if (node.left != null) {
            traverse(node.left, curPath, result);
        }

        if (node.right != null) {
            traverse(node.right, curPath, result);
        }

        if (node.left == null && node.right == null) {
            List<Integer> pathToLeaf = new ArrayList<>(curPath.path);
            result.allPaths.add(pathToLeaf);

            if (curPath.sum > result.maxSum) {
                result.maxSumPath = pathToLeaf;
                result.maxSum = curPath.sum;
            }
        }

        curPath.remove();
    }

    private class Result {
        int maxSum;
        List<Integer> maxSumPath;
        private List<List<Integer>> allPaths = new ArrayList<>();
    }

    private class PathHolder {
        List<Integer> path;
        int sum;

        PathHolder() {
            this.path = new ArrayList<>();
        }

        void append(int val) {
            this.path.add(val);
            this.sum += val;
        }

        void remove() {
            this.sum -= this.path.get(path.size() - 1);
            this.path.remove(path.size() - 1);
        }
    }
}
