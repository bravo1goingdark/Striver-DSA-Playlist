package SlidingWindowTP;

public class PartI {
    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{-1, 2, 3, 3, 4, 5, -1}, 4));
    }

    public static int maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k <= 0) return 0;

        int currentSum = 0;

        // initial window sum
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
