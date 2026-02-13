// https://leetcode.com/problems/next-greater-element-i/description/
// https://leetcode.com/problems/next-greater-element-ii/description/
package Stack_Queue;

import java.util.Arrays;

public class PartVIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElementI(new int[]{4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6})));
    }

    public static int[] nextGreaterElementI(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];


            if (!stack.isEmpty() && stack.peek() <= curr) {
                while (!stack.isEmpty() && stack.peek() <= curr) {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) nge[i] = -1;
            else nge[i] = stack.peek();

            stack.push(curr);
        }
        return nge;
    }

    public int[] nextGreaterElementsII(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int curr = nums[i % nums.length];


            if (!stack.isEmpty() && stack.peek() <= curr) {
                while (!stack.isEmpty() && stack.peek() <= curr) {
                    stack.pop();
                }
            }

            if (i < nums.length) {
                if (stack.isEmpty()) nge[i] = -1;
                else nge[i] = stack.peek();
            }

            stack.push(curr);
        }
        return nge;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
