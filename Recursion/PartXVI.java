package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Recursion.PartXVI.Main.findSum;


public class PartXVI {
    public static void main(String[] args) {
        List<String> ans = ratMaze();
        Collections.sort(ans);
        System.out.println(ans);

        int[][] path = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(findSum(path, 4));
    }

    public static List<String> ratMaze() {
        List<String> ans = new ArrayList<>();
        boolean[][] maze = new boolean[][]{
                {true, true, false},
                {true, false, true},
                {true, true, true}
        };
        int n = maze.length;

        // no valid starting or destination point
        if (!maze[0][0] || !maze[n - 1][n - 1]) return ans;

        boolean[][] visited = new boolean[n][n];
        ratMaze(0, 0, "", maze, visited, ans);
        return ans;
    }

    private static void ratMaze(int row, int col, String path, boolean[][] maze, boolean[][] visited, List<String> ans) {
        int n = maze.length;

        // Boundary, wall or visited check
        if (row < 0 || col < 0 || row >= n || col >= n) return;
        if (!maze[row][col] || visited[row][col]) return;

        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        visited[row][col] = true;

        // Try all directions - {L,R,U,D}
        ratMaze(row, col - 1, path + 'L', maze, visited, ans); // left
        ratMaze(row, col + 1, path + 'R', maze, visited, ans); // right
        ratMaze(row - 1, col, path + 'U', maze, visited, ans); // up
        ratMaze(row + 1, col, path + 'D', maze, visited, ans); // down

        visited[row][col] = false; // backtrack
    }

    static class Main {

        public static ArrayList<String> findSum(int[][] arr, int n) {
            ArrayList<String> ans = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];

            if (arr[0][0] == 0 || arr[n - 1][n - 1] == 0) return ans;
            solve(0, 0, "", arr, visited, ans, n);
            return ans;
        }

        private static void solve(int row, int col, String path, int[][] arr, boolean[][] visited, ArrayList<String> ans, int n) {
            // base case
            if (row == n - 1 && col == n - 1) {
                ans.add(path);
                return;
            }

            // boundary or blocked or visited
            if (row < 0 || col < 0 || row >= n || col >= n) return;
            if (arr[row][col] == 0 || visited[row][col]) return;

            visited[row][col] = true;

            // move left
            solve(row, col - 1, path + 'L', arr, visited, ans, n);
            // move right
            solve(row, col + 1, path + 'R', arr, visited, ans, n);
            // move up
            solve(row - 1, col, path + 'U', arr, visited, ans, n);
            // move down
            solve(row + 1, col, path + 'D', arr, visited, ans, n);

            visited[row][col] = false; // backtrack
        }
    }

}
