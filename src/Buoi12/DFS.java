package Buoi12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//4 4
//        1 1 0 0
//        0 1 1 0
//        0 0 1 0
//        1 0 0 0

public class Solution {

    static int[][] grid;
    static boolean[][] visited;
    static int N, M;

    static boolean validate(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M && grid[row][col] == 1;
    }

    static Iterable<Cell> adj(Cell v) {
        List<Cell> adjList = new ArrayList<>();
        int row = v.r;
        int col = v.c;
        int a = row - 1;
        int b = row;
        int c = row + 1;

        int d = col - 1;
        int e = col;
        int f = col + 1;

        if (validate(a, d)) adjList.add(new Cell(a, d));
        if (validate(a, e)) adjList.add(new Cell(a, e));
        if (validate(a, f)) adjList.add(new Cell(a, f));
        if (validate(b, d)) adjList.add(new Cell(b, d));
        if (validate(b, f)) adjList.add(new Cell(b, f));
        if (validate(c, d)) adjList.add(new Cell(c, d));
        if (validate(c, e)) adjList.add(new Cell(c, e));
        if (validate(c, f)) adjList.add(new Cell(c, f));
        return adjList;
    }

    static int dfs(Cell cell)
    {
        cell.countAdj++;
        visited[cell.r][cell.c] = true;
        for (Cell v : adj(cell)) {
            if (!visited[v.r][v.c]) {
                cell.countAdj += dfs(new Cell(v.r, v.c));
            }
        }
        return cell.countAdj;
    }

    static int count_connected(int row, int col) {
        return dfs(new Cell(row, col));
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}
