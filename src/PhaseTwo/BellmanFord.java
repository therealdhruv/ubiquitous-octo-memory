package PhaseTwo;
import java.util.*;

public class BellmanFord {
    static class createGraph {

        class createEdge {
            int src, dst, weigth;
            createEdge(int src, int dst, int weigth) {
                this.src = src;
                this.dst = dst;
                this.weigth = weigth;
            }
        }

        int V, E;
        createEdge[] edge;

        createGraph(int v, int e) {
            V = v;
            E = e;
            edge = new createEdge[e];
        }

        void printSolution(int[] arr) {
            System.out.println("Vertex Distance From Source");
            for (int i = 0; i < V; ++i) System.out.println(i + "\t\t" + arr[i]);
        }

        void bellmanAlgo(int src) {

            int[] dist = new int[V];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            for (int i = 1; i < V; ++i) {
                for (int j = 0; j < E; ++j) {

                    int u = edge[j].src;
                    int v = edge[j].dst;
                    int w = edge[j].weigth;

                    if (u != Integer.MAX_VALUE && dist[u] + w < dist[v]) dist[v] = dist[u] + w;

                }
            }

            for (int j = 0; j < E; ++j) {

                int u = edge[j].src;
                int v = edge[j].dst;
                int w = edge[j].weigth;

                if (u != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }

            }

            printSolution(dist);


        }

        public static void main(String[] args) {
            int V = 8;
            int E = 10;
            createGraph graph = new createGraph(V, E);

            graph.edge[0] = graph.new createEdge(1, 2, 6);
            graph.edge[1] = graph.new createEdge(1, 3, 5);
            graph.edge[2] = graph.new createEdge(1, 4, 5);
            graph.edge[3] = graph.new createEdge(2, 5, -1);
            graph.edge[4] = graph.new createEdge(3, 2, -2);
            graph.edge[5] = graph.new createEdge(3, 5, 1);
            graph.edge[6] = graph.new createEdge(4, 3, -2);
            graph.edge[7] = graph.new createEdge(4, 6, -1);
            graph.edge[8] = graph.new createEdge(5, 7, 3);
            graph.edge[9] = graph.new createEdge(6, 7, 3);

            graph.bellmanAlgo(0);
        }

    }
}
