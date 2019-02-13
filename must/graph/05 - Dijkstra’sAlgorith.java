/*
https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

Given a graph and a source vertex in the graph, find shortest paths from source to all vertices in the given graph.
*/

import java.util.HashSet;
import java.util.Set;

class GFG {
    public void dijkstra(WeightedGraph graph, int src) {
        boolean[] visited = new boolean[graph.numberOfVertices];

        // Holds the shortest path from source node
        int[] distance = initializeDistanceMatrix(graph.numberOfVertices);
        distance[src] = 0;

        // Holds the previous vertex in the shortest path to current node
        int[] previousVertexInPath = new int[graph.numberOfVertices];

        // Use priority to eliminate the need for 'findMinWeightIndex' method
        // That will reduce time complexity from O(V^2) --> O(E logV)
        Set<Integer> possibleNext = new HashSet<>();
        possibleNext.add(src);

        while (possibleNext.size() > 0) {
            int cur = findMinWeightIndex(possibleNext, distance);
            visited[cur] = true;
            possibleNext.remove(cur);
            for (int i = 0; i < graph.numberOfVertices; i++) {
                if (graph.adj[cur][i] > 0 && !visited[i]) {
                    possibleNext.add(i);

                    int distanceFromCurVertex = distance[cur] + graph.adj[cur][i];
                    if (distanceFromCurVertex < distance[i]) {
                        distance[i] = distanceFromCurVertex;
                        previousVertexInPath[i] = cur;
                    }
                }
            }
        }

        for (int i = 0; i < graph.numberOfVertices; i++) {
            System.out.println(String.format("%d: %2d, %d", i, distance[i], previousVertexInPath[i]));
        }
    }

    private int findMinWeightIndex(Set<Integer> next, int[] distance) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;

        for (int index : next) {
            if (distance[index] <= min) {
                min = distance[index];
                minIndex = index;
            }
        }

        return minIndex;
    }

    private int[] initializeDistanceMatrix(int size) {
        int[] distance = new int[size];
        for (int i = 0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        return distance;
    }
}

class WeightedGraph {
    int numberOfVertices;
    int[][] adj;

    WeightedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adj = new int[numberOfVertices][numberOfVertices];
    }

    void addEdge(int src, int dest, int weight) {
        if (src >= numberOfVertices || dest >= numberOfVertices) {
            throw new RuntimeException("Invalid src/dest");
        }

        adj[src][dest] = weight;
        adj[dest][src] = weight;
    }
}
