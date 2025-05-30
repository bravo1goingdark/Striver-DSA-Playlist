import java.util.*;

public class PartXX {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


    public static List<List<Integer>> threeSumBrute(int[] nums) {
        //  Time Comp - O(n* n * n * logn(no of triplet))
        //  space comp - O(2 * no of triplet)
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> curr = new ArrayList<>();
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // avoid permutation duplicate
                        set.add(triplet); // store only unique triplet
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSumBetter(int[] nums) {
        //  Time Comp - O(n * n * logn(no of triplet))
        //  space comp - O(n + 2 * no of triplet)
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> curr = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);

                if (curr.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet); // avoid permutation duplicate
                    set.add(triplet); // store only unique triplet
                }

                curr.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //  Time Comp - O(n * n * logn(no of triplet))
        //  space comp - O(n + 2 * no of triplet)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;


            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> curr = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(curr);
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;

                }
            }
        }

        return ans;

    }

}
