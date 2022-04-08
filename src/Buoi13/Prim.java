package Buoi13;

import java.util.*;

public class Prim {
    private static class Edge implements Comparable<Edge> {
        public int r, v1, v2;
        public Edge(int vertex1, int vertex2, int cost) {
            r = cost;
            v1 = vertex1;
            v2 = vertex2;
        }
        @Override
        public int compareTo(Edge c) {
            if (this.v1 == c.v1 && this.v2 == c.v2 && this.r == c.r) {
                return 0;
            }
            if (this.r < c.r) {
                return -1;
            }
            if (this.r > c.r) {
                return 1;
            }
            if (this.v1 > c.v1) {
                return 1;
            }
            if (this.v1 < c.v1) {
                return -1;
            }
            if (this.v2 > c.v2) {
                return 1;
            }
            return -1;
        }
    }

    private static class Vertex {
        public int name;
        public boolean visited;
        public List<Edge> edgeList;
        Vertex(int name) {
            this.name = name;
            visited = false;
            edgeList = new ArrayList<>();
        }
    }

    public static void main(String []args) {
        PriorityQueue<Edge> minPQ = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        int numberOfEdges = sc.nextInt();
        Vertex[] vertices = new Vertex[numberOfNodes + 1];
        for (int i = 1; i < numberOfNodes + 1; i++) {
            vertices[i] = new Vertex(i);
        }

        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int weight = sc.nextInt();
            vertices[vertex1].edgeList.add(new Edge(vertex1, vertex2, weight));
            vertices[vertex2].edgeList.add(new Edge(vertex1, vertex2, weight));
        }
        int startNode = sc.nextInt();
        int totalCost = 0;
        for (int i = 1; i < numberOfNodes; i++) {
            vertices[startNode].visited = true;
            for (int j = 0; j < vertices[startNode].edgeList.size(); j++) {
                Edge edge = vertices[startNode].edgeList.get(j);
                if (!minPQ.contains(edge) && (!vertices[edge.v1].visited || !vertices[edge.v2].visited)) {
                    minPQ.add(edge);
                }
            }

            while (!minPQ.isEmpty() && vertices[minPQ.peek().v1].visited && vertices[minPQ.peek().v2].visited) {
                minPQ.remove();
            }
            if (!minPQ.isEmpty())
            {
                totalCost += minPQ.peek().r;
                if (!vertices[minPQ.peek().v1].visited) {
                    startNode = minPQ.peek().v1;
                }
                else {
                    startNode = minPQ.peek().v2;
                }
            }
            minPQ.remove();
        }
        System.out.println(totalCost);
    }

}
