package Greedy;

public class PartIV {

    public static boolean canJump(int[] nums) {

        // farthest represents the maximum index we can reach so far
        // using jumps from indices we have already visited
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index i is beyond the farthest reachable index,
            // it means this index is unreachable by any previous jump
            // hence reaching the end is impossible
            if (i > farthest) return false;

            // Update the farthest reachable index
            // From index i, we can reach up to (i + nums[i])
            // Take the maximum because we want the best possible reach
            farthest = Math.max(farthest, i + nums[i]);
        }

        // If we never encountered an unreachable index,
        // then the last index is reachable
        return true;
    }
}
