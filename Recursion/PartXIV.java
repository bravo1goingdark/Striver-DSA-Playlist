package Recursion;

import java.util.Arrays;

public class PartXIV {
    public static void main(String[] args) {
        int[][] path = new int[][]{{1, 2}, {2, 3}, {3, 4}};

        System.out.println("Valid Coloring Exists: " + solve(4, 2, path));
    }

    public static boolean solve(int vertices, int m, int[][] path) {
        boolean[][] graph = buildGraph(vertices, path);
        int[] color = new int[vertices];

        boolean result = mColoring(0, graph, color, m, vertices);

        System.out.println("Coloring: " + Arrays.toString(color));
        return result;
    }

    private static boolean mColoring(int node, boolean[][] graph, int[] color, int m, int vertices) {
        if (node == vertices) return true; // base case: all nodes colored

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, color, c)) {
                color[node] = c;
                if (mColoring(node + 1, graph, color, m, vertices)) return true;
                color[node] = 0; // backtrack
            }
        }

        return false;
    }

    private static boolean isSafe(int node, boolean[][] graph, int[] color, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] && color[i] == c) return false;
        }
        return true;
    }

    private static boolean[][] buildGraph(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            graph[u][v] = true;
            graph[v][u] = true;
        }
        return graph;
    }
}
