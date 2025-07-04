package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartXVIII {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);

        allPathsSourceTarget(0, graph, curr, ans);
        return ans;

    }

    private static void allPathsSourceTarget(int node, int[][] graph, List<Integer> curr, List<List<Integer>> ans) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int e : graph[node]) {
            curr.add(e);
            allPathsSourceTarget(e, graph, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
