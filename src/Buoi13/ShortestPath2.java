package Buoi13;

import java.util.*;

public class ShortestPath2 {
    public static Vertex[] vertices;
    private static double[] distTo;          // distTo[v] = distance  of shortest s->v path
    private static PriorityQueue<Vertex> pq;    // priority queue of vertices

    public static void findShortestPath(int start) {
        pq.remove(vertices[start]);
        vertices[start].shortestPath = 0;
        pq.add(vertices[start]);

        while (!pq.isEmpty()) {
            Vertex v = pq.remove();
            distTo[v.name] = v.shortestPath;
            for (DirectEdge e : v.edgeList) {
                relax(e);
            }
            vertices[v.name].done = true;
        }
    }

    private static void relax(DirectEdge edge) {
        if (!vertices[edge.v2].done) {
            if (vertices[edge.v2].shortestPath > vertices[edge.v1].shortestPath + edge.r) {
                pq.remove(vertices[edge.v2]);
                vertices[edge.v2].shortestPath = vertices[edge.v1].shortestPath + edge.r;
                pq.add(vertices[edge.v2]);
            }
        }
    }

    private static class DirectEdge {
        public int r, v1, v2;
        public DirectEdge(int vertex1, int vertex2, int cost) {
            r = cost;
            v1 = vertex1;
            v2 = vertex2;
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        public boolean done;
        public int name;
        public double shortestPath;
        public List<DirectEdge> edgeList;
        Vertex(int name) {
            edgeList = new ArrayList<>();
            shortestPath = Double.POSITIVE_INFINITY;
            this.name = name;
        }
        public int compareTo(Vertex other) {
            if (this.shortestPath < other.shortestPath) {
                return -1;
            } else if (this.shortestPath > other.shortestPath) {
                return 1;
            } else if (this.name < other.name) {
                return -1;
            } else if (this.name > other.name) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCase = sc.nextInt();
        for (int k = 0; k < numberOfTestCase; k++)
        {
            int numberOfNodes = sc.nextInt();
            int numberOfEdges = sc.nextInt();
            vertices = new Vertex[numberOfNodes + 1];
            pq = new PriorityQueue<>();
            distTo = new double[numberOfNodes + 1];
            for (int i = 1; i < numberOfNodes + 1; i++) {
                vertices[i] = new Vertex(i);
                pq.add(vertices[i]);
            }

            for (int i = 0; i < numberOfEdges; i++) {
                int vertex1 = sc.nextInt();
                int vertex2 = sc.nextInt();
                int weight = sc.nextInt();
                vertices[vertex1].edgeList.add(new DirectEdge(vertex1, vertex2, weight));
                vertices[vertex2].edgeList.add(new DirectEdge(vertex2, vertex1, weight));
            }

            int start = sc.nextInt();
            findShortestPath(start);


            for (int i = 1; i < distTo.length; i++) {
                if (distTo[i] != 0) {
                    if (distTo[i] != Double.POSITIVE_INFINITY) {
                        System.out.print((int) distTo[i] + " ");
                    }
                    else System.out.println(-1 + " ");
                }
            }
            System.out.println();
        }
    }
}
