import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartXIII {
    public static void main(String[] args) {
        System.out.println(longestConsecutiveBrute(new int[]{102,4,100,1,101,3,2,1,1}));
        System.out.println(longConsecBetter(new int[]{102,101,4,2,3,3,100,100,101,1,101,3,2,2,1,1}));
        System.out.println(longestConsecutive(new int[]{102,101,4,2,3,3,100,100,101,1,101,3,2,2,1,1}));


    }


    // time comp - O(n*n)
    // space comp - O(1)
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

    // time comp -> O(nlogn)
    public static int longConsecBetter(int[] arr){
        Arrays.sort(arr); // O(nlogn)
        int longest = 1;
        int last_smallest = Integer.MIN_VALUE;
        int currCount = 0;

        for (int e : arr) { // O(n)
            if (e - 1 == last_smallest) {
                currCount++;
                last_smallest = e;
            } else if (e != last_smallest) {
                currCount = 1;
                last_smallest = e;
            }
            longest = Math.max(longest, currCount);
        }

        return longest;
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 1;
        for (int e : nums) set.add(e);


        for (int it : set){
            if (!set.contains(it - 1)){
                int smallest = it;
                int currCount = 1;

                while (set.contains(smallest + 1)){
                    smallest++;
                    currCount++;
                }
                longest = Math.max(longest,currCount);
            }
        }
        return longest;
    }


}
