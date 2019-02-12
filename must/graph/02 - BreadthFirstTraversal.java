/*
https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

Given N, number of edges for a graph. The task is to do Breadth First Search of this graph.
*/

import java.util.LinkedList;
import java.util.Queue;

class GFG {

    public String bfs(Graph graph) {
        boolean[] visited = new boolean[graph.numberOfVertices];
        StringBuilder path = new StringBuilder();

        for (int i = 0; i < graph.numberOfVertices; i++) {
            bfs(graph, i, visited, path);
        }

        return path.toString();
    }

    private void bfs(Graph graph, int i, boolean[] visited, StringBuilder path) {
        if (visited[i]) {
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            path.append(cur);

            for (int j = 0; j < graph.numberOfVertices; j++) {
                if (graph.adj[cur][j] && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}

