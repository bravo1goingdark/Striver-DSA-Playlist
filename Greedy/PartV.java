package Greedy;

public class PartV {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 4, 1, 1, 1, 2}));
    }


    public static int jump(int[] nums) {
//        return jumpRecur(0, 0, nums);
        return jumpGreedy(nums);
    }

    private static int jumpRecur(int index, int jump, int[] nums) {

        if (index >= nums.length - 1) {
            return jump;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {
            min = Math.min(min, jumpRecur(index + i, jump + 1, nums));
        }
        return min;
    }

    private static int jumpGreedy(int[] nums) {
        int l = 0;
        int r = 0;
        int jump = 0;

        while (r < nums.length - 1) {

            int farthest = 0;

            for (int i = l; i <= r ; i++) {
                farthest = Math.max(farthest,i + nums[i]);
            }

            l = r + 1;
            r = farthest;

            jump++;
        }

        return jump;
    }

}
