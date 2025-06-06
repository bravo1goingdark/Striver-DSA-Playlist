package Bsearch;

public class PartV {
    public static void main(String[] args) {
        System.out.println(findKRotation(new int[]{3,4,5,1,2}));
    }


    public static int findKRotation(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]){
                if (nums[start] < ans){
                    ans = Math.min(ans,nums[start]);
                    index = start;
                }
                start = mid + 1;
            }else {
                if (nums[mid] < ans){
                    ans = Math.min(ans,nums[mid]);
                    index = mid;
                }
                end = mid - 1;
            }
        }
        return index;

    }
}
