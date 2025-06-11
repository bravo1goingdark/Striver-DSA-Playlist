package Bsearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PartXVII {
    public static double MinimiseMaxDistance(int[] arr, int K) {
        int[] howMany = new int[arr.length - 1];
        Arrays.fill(howMany, 0);

        for (int i = 1; i <= K; i++) {
            double maxSection = -1;
            int maxIndex = -1;

            for (int j = 0; j < arr.length - 1; j++) {
                double diff = arr[j + 1] - arr[j];
                double sectionLength = diff / (double) (howMany[j] + 1);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxIndex = j;
                }
            }
            howMany[maxIndex]++;
        }

        double maxAns = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    public static double MinimiseMaxDistanceOpt(int[] arr, int K) {
        int[] howMany = new int[arr.length - 1];

        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0])
        );

        for (int i = 0; i < arr.length - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            pq.add(new double[]{diff, i});
        }

        for (int i = 1; i <= K; i++) {
            double[] top = pq.poll();
            int idx = (int) top[1];
            howMany[idx]++;

            double segmentLength = (double) (arr[idx + 1] - arr[idx]) / (howMany[idx] + 1);
            pq.add(new double[]{segmentLength, idx});
        }

        return pq.poll()[0];
    }


}
