import java.util.*;

public class PartXXI {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSumBrute(int[] nums, int target) {
        // time comp -> O(n*n*n*n * nlogn)
        // space comp -> O(no of quads + 4 )
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        // time comp -> O(n*n*n * nlogn)
        // space comp -> O(no of quads + 4 + max_size(curr))
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> curr = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int l = target - sum;

                    if (curr.contains(l)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], l);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    curr.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(set);

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // time comp -> O(n*n*n + nlogn)
        // space comp -> O(1)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }

            }
        }

        return ans;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);

        Map<Integer, Integer> sumCount = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                count += sumCount.getOrDefault(target, 0);
            }
        }

        return count;
    }
}
