public class PartXXVII {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }


    public static int maxProductBrute(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currMax = nums[i];
            max = Math.max(max, currMax);

            for (int j = i + 1; j < nums.length; j++) {
                currMax *= nums[j];
                max = Math.max(max, currMax);
            }
        }

        return max;
    }
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];

            max = Math.max(max,Math.max(prefix,suffix));
        }

        return max;
    }

}
