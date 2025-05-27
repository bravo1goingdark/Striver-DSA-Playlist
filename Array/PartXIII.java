import java.util.Arrays;

public class PartXIII {
    public static void main(String[] args) {
        System.out.println(longestConsecutiveBrute(new int[]{102,4,100,1,101,3,2,1,1}));

    }

    public static int longestConsecutiveBrute(int[] nums) {
        int longest = 1;

        for (int e : nums) {
            int num = e;
            int count = 1;

            while (ls(nums, num + 1)) {
                num++;
                count++;
            }

            longest = Math.max(longest, count);
        }
        return longest;

    }

    private static boolean ls(int[] arr , int target){
        for (int e : arr) if (e == target) return true;
        return false;
    }

    public static int longConsecBetter(int[] arr){
        Arrays.sort(arr);
        int longest = 0;
        int smallest_ever = Integer.MIN_VALUE;


    }


}
