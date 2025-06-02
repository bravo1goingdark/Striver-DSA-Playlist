import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartXXIII {
    public static void main(String[] args) {
        int[][] inter = new int[][]{
                {2, 6},
                {1, 3},
                {2, 4},
                {8, 9},
                {9, 11},
        };

        for (int[] e : mergeOpt(inter)) {
            System.out.println(Arrays.toString(e));
        }

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]
                ? Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) continue;

            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= end){
                    end = Math.max(end,intervals[j][1]);
                }else {
                    break;
                }
            }

            ans.add(new int[]{start,end});
        }

        return ans.toArray(new int[ans.size()][]);


    }

    public static int[][] mergeOpt(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]
                ? Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
