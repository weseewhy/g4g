class Graph {
    int numberOfVertices;
    boolean[][] adj;

    Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adj = new boolean[numberOfVertices][numberOfVertices];
    }

    void addEdge(int src, int dest) {
        if (src >= numberOfVertices || dest >= numberOfVertices) {
            throw new RuntimeException("Invalid src/dest");
        }

        adj[src][dest] = true;
    }
}
