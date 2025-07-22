package SlidingWindowTP;

public class PartI {
    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{-1, 2, 3, 3, 4, 5, -1}, 4));
    }

    public static int maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k <= 0) return 0;

        int currentSum = 0;
        int left = 0;
        int right = k - 1;

        // initial window sum
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int max = currentSum;

        while (right < nums.length - 1) {
            currentSum = currentSum - nums[left];
            left++;
            right++;
            currentSum = currentSum + nums[right];

            max = Math.max(currentSum, max);
        }

        return max;
    }

}
