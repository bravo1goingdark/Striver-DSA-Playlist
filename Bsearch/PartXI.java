package Bsearch;

public class PartXI {

    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = getMax(nums);

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (isFeasible(nums,threshold,mid)){
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return start;

    }

    private static boolean isFeasible(int[] arr, int threshold, int divisor) {
        double sum = 0;

        for (int e : arr) {
            double ce = ((double) e) / ((double) divisor);
            sum += Math.ceil(ce);
        }
        return sum <= threshold;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int e : arr) {
            max = Math.max(max, e);
        };
        return max;
    }
}
