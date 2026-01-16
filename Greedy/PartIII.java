package Greedy;

import java.util.Arrays;

public class PartIII {

    public static void main(String[] args) {
        System.out.println(sjf(new int[]{2,3,6,8}));
    }
    public static float sjf(int[] burstTime) {
        Arrays.sort(burstTime);

        float wt = 0;
        int pfs = 0;


        // bt : [2,3,6,8]

        for (int i = 0; i < burstTime.length - 1; i++) {
            // process start time (ps)
            int ps = burstTime[i];
            // process prefix sum (pfs)
            pfs += ps;

            // total waiting time after each process
            wt += pfs ;
        }

        // avg waiting time
        return wt / burstTime.length;
    }
}
