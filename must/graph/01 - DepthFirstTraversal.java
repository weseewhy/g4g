/*
https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
https://www.geeksforgeeks.org/iterative-depth-first-traversal/

Given N edges of a graph. The task is to do depth first traversal of the graph.
*/

import java.util.Stack;

class GfG {
    public String dfs_recursive(Graph graph) {
        boolean[] visited = new boolean[graph.numberOfVertices];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < graph.numberOfVertices; i++) {
            dfs_recursive(graph, i, visited, sb);
        }

        return sb.toString();
    }

    private void dfs_recursive(Graph graph, int curNode, boolean[] visited, StringBuilder path) {
        if (visited[curNode]) {
            return;
        }

        path.append(curNode);
        visited[curNode] = true;
        for (int i = 0; i < graph.numberOfVertices; i++) {
            if (graph.adj[curNode][i] && !visited[i]) {
                dfs_recursive(graph, i, visited, path);
            }
        }
    }

    public String dfs_iterative(Graph graph) {
        boolean[] visited = new boolean[graph.numberOfVertices];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < graph.numberOfVertices; i++) {
            dfs_iterative(graph, i, visited, sb);
        }

        return sb.toString();
    }

    private void dfs_iterative(Graph graph, int i, boolean[] visited, StringBuilder sb) {
        if (visited[i]) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        visited[i] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            sb.append(cur);
            for (int j = 0; j < graph.numberOfVertices; j++) {
                if (graph.adj[cur][j] && !visited[j]) {
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }
}
