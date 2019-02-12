/*
https://www.geeksforgeeks.org/detect-cycle-in-a-graph/

Given a directed graph, check whether the graph contains a cycle or not.
*/

import java.util.HashSet;
import java.util.Set;

class GFG {
    public boolean hasCycle(Graph graph) {
        boolean[] visited = new boolean[graph.numberOfVertices];
        Set<Integer> path = new HashSet<>();

        for (int i = 0; i < graph.numberOfVertices; i++) {
            if (hasCycle(graph, i, visited, path)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Graph graph, int i, boolean[] visited, Set<Integer> path) {
        if (path.contains(i)) {
            return true;
        } else if (visited[i]) {
            return false;
        }

        visited[i] = true;
        path.add(i);

        for (int j = 0; j < graph.numberOfVertices; j++) {
            if (graph.adj[i][j] && hasCycle(graph, j, visited, path)) {
                return true;
            }
        }
        path.remove(i);
        return false;
    }
}
