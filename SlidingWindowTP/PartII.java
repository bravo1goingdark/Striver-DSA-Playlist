package SlidingWindowTP;

public class PartII {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{2,1,4,3,5},10));
    }

    public static long countSubarrays(int[] nums, long k) {
        long result = 0;
        long sum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum * (end - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }

            result += (end - start + 1);
        }

        return result;
    }
}
