/*
https://www.geeksforgeeks.org/topological-sorting/

Given a directed graph returns an array having the topologically sorted elements of the array and takes two arguments
*/

class GFG {
    public String topologicalSort(Graph graph) {
        boolean[] visited = new boolean[graph.numberOfVertices];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < graph.numberOfVertices; i++) {
            topologicalTraverse(graph, i, visited, sb);
        }

        return sb.reverse().toString();
    }

    private void topologicalTraverse(Graph graph, int i, boolean[] visited, StringBuilder path) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int j = 0; j < graph.numberOfVertices; j++) {
            if (graph.adj[i][j] && !visited[j]) {
                topologicalTraverse(graph, j, visited, path);
            }
        }

        path.append(i);
    }
}
