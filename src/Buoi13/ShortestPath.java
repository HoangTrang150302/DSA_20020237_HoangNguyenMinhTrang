package Buoi13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPath {
    public static Vertex[] vertices;

    public static void findShortestPath(int start) {
        vertices[start].shortestPath = 0;

        while (!checkDone()) {
            int index;
            if (!vertices[start].done) {
                index = start;
            }
            else index = findMinIndex();

            for (DirectEdge e : vertices[index].edgeList) {
                relax(e);
            }
            vertices[index].done = true;
        }
    }

    private static boolean checkDone() {
        for (int i = 1; i < vertices.length; i++) {
            if (!vertices[i].done) {
                return false;
            }
        }
        return true;
    }

    private static int findMinIndex() {
        double min = 0;
        int minIndex = 1;
        for (int i = 1; i < vertices.length; i++) {
            if (!vertices[i].done) {
                min = vertices[i].shortestPath;
                minIndex = i;
                break;
            }
        }

        for (int i = 1; i < vertices.length; i++) {
            if (!vertices[i].done && vertices[i].shortestPath < min) {
                min = vertices[i].shortestPath;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void relax(DirectEdge edge) {
        if (!vertices[edge.v2].done) {
            if (vertices[edge.v2].shortestPath > vertices[edge.v1].shortestPath + edge.r) {
                vertices[edge.v2].shortestPath = vertices[edge.v1].shortestPath + edge.r;
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

    private static class Vertex {
        public boolean done;
        public double shortestPath;
        public List<DirectEdge> edgeList;
        Vertex(int name) {
            edgeList = new ArrayList<>();
            shortestPath = Double.POSITIVE_INFINITY;
            done = false;
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
            for (int i = 1; i < numberOfNodes + 1; i++) {
                vertices[i] = new Vertex(i);
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


            for (int i = 1; i < vertices.length; i++) {
                if (vertices[i].shortestPath != 0) {
                    if (vertices[i].shortestPath != Double.POSITIVE_INFINITY) {
                        System.out.print((int) vertices[i].shortestPath + " ");
                    }
                    else System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }
    }
}
