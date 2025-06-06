package Bsearch;

public class PartVI {

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 2, 2, 3, 3, 4,4, 5, 5, 6, 6}));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];

        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        int start = 1;
        int end = nums.length - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            // Check if mid is in the left (well-formed) part where pairs are starting at even indices.
            // For even mid: nums[mid] == nums[mid + 1]
            // For odd mid:  nums[mid] == nums[mid - 1]
            // If this pattern holds, the single element is on the right.


            if (mid % 2 == 1 && nums[mid - 1] == nums[mid] ||
                    mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                start = mid + 1; // eliminate left half
            }
            else {
                end = mid - 1; // eliminate right half
            }
        }

        return -1;

    }
}
