package Stack_Queue;

public class PartXI {
    public static void main(String[] args) {
        System.out.println(subArrayRangesOpt(new int[]{1,2,3}));
        System.out.println(subArrayRangesOpt(new int[]{10,12,63}));

    }


    public static long subArrayRanges(int[] nums) {
        long total = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                total += (max - min);
            }
        }

        return total;

    }

    public static long subArrayRangesOpt(int[] nums){
        return sumSubarrayMax(nums) - sumSubarrayMinsOpt(nums);
    }
    public static int sumSubarrayMinsOpt(int[] arr) {
        int n = arr.length;
        long res = 0;
        int MOD = 1000000007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // previous last element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        stack.clear();

        // next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            res = (res + contribution) % MOD;
        }

        return (int) res;
    }

    private static int sumSubarrayMax(int[] arr) {
        int n = arr.length;
        long res = 0;
        int MOD = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // previous Greater Element (strictly greater)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        stack.clear();

        // next Greater Element (greater or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            res = (res + contribution) % MOD;
        }

        return (int) res;
    }
}
