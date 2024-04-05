package PhaseTwo;

// Assuming you have a graph represented as an adjacency list and the nodes are labeled from 0 to n-1
import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; //Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Returns the shortest distance between s and d
    int shortestDistance(int s, int d) {
        int[] distance = new int[V];
        Arrays.fill(distance, -1); // Fill distance array with -1
        Queue<Integer> queue = new LinkedList<>();

        distance[s] = 0; // Distance of source to itself is always 0
        queue.add(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int n : adj[current]) {
                if (distance[n] == -1) { // If not visited
                    queue.add(n);
                    distance[n] = distance[current] + 1;
                    if (n == d) return distance[n]; // Return distance when destination is found
                }
            }
        }
        return -1; // Return -1 if destination cannot be reached
    }

    public static void main(String args[]) {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int source = 1, destination = 3;
        System.out.println("Shortest distance: " + g.shortestDistance(source, destination));

    }
}

