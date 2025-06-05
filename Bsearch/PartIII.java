package Bsearch;

public class PartIII {
    public static void main(String[] args) {
        System.out.println(rotatedSearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int rotatedSearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
    public static boolean rotatedSearchDuplicate(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;

            if (nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }
            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }


}
