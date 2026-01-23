package Greedy;

import java.util.Arrays;



public class PartVI {

    public static int jobSequencing(Job[] jobs) {

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find max deadline
        int maxDeadline = 0;
        for (Job j : jobs)
            maxDeadline = Math.max(maxDeadline, j.deadline);

        boolean[] slots = new boolean[maxDeadline + 1];

        int totalProfit = 0;

        // Try to schedule each job
        for (Job job : jobs) {
            for (int t = job.deadline; t > 0; t--) {
                if (!slots[t]) {
                    slots[t] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        return totalProfit;
    }

    static class Job {
        int deadline, profit;
        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }
}
