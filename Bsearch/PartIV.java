package Bsearch;

public class PartIV {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,1,2,3,4}));
    }
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]){
                ans = Math.min(ans,nums[start]);
                start = mid + 1;
            }else {
                end = mid - 1;
                ans = Math.min(ans,nums[mid]);
            }
        }
        return ans;

    }
}
