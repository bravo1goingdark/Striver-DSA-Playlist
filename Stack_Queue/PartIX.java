package Stack_Queue;

public class PartIX {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMinsOpt(new int[]{3, 1, 2, 4}));
    }

    public static int sumSubarrayMins(int[] arr) {

        long sum = 0;
        int MOD = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % MOD;
            }
        }
        return (int) sum;

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
}
