package SlidingWindowTP;

public class PartV {

    public static int longestOnesBrute(int[] nums, int k) {

        int maxlen = 0;

        for (int i = 0; i < nums.length; i++) {
            int noOfZero = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    noOfZero++;
                }

                if (noOfZero <= k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }

                if (noOfZero > k) {
                    break;
                }
            }
        }
        return maxlen;

    }

    public static int longestOnesBetter(int[] nums, int k) {

        int maxlen = 0;
        int left = 0;
        int right = 0;
        int noOfZero = 0;

        while (right < nums.length) {
            if (nums[right] == 0) noOfZero++;

            while (noOfZero > k) {
                if (nums[left] == 0) noOfZero--;
                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;

    }

    public static int longestOnesOpt(int[] nums, int k) {

        int maxlen = 0;
        int left = 0;
        int right = 0;
        int noOfZero = 0;

        while (right < nums.length) {
            if (nums[right] == 0) noOfZero++;

            if (noOfZero > k) {
                if (nums[left] == 0) noOfZero--;
                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;

    }
}
