package Buoi13;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {
    public static Vertex[] vertices;
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
        public int connected;
        public int name;
        public List<Integer> connectedList;
        Vertex(int name) {
            connected = 0;
            this.name = name;
            connectedList = new ArrayList<>();
        }
    }

    public static void connect(int vertex1, int vertex2) {
        int prev = vertices[vertex1].connected;

        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i].connected == prev) {
                vertices[i].connected = vertices[vertex2].connected;
            }
        }
    }

    public static void main(String []args) {
        PriorityQueue<Edge> minPQ = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        int numberOfEdges = sc.nextInt();
        vertices = new Vertex[numberOfNodes + 1];

        for (int i = 1; i <= numberOfNodes; i++) {
            vertices[i] = new Vertex(i);
            vertices[i].connected = i;
        }

        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int weight = sc.nextInt();
            minPQ.add(new Edge(vertex1, vertex2, weight));
        }

        int totalCost = 0;
        while (!minPQ.isEmpty()) {
            if (vertices[minPQ.peek().v1].connected != vertices[minPQ.peek().v2].connected) {
                connect(minPQ.peek().v1, minPQ.peek().v2);
                totalCost += minPQ.remove().r;
            }
            else minPQ.remove();
        }

        System.out.println(totalCost);
    }
}
