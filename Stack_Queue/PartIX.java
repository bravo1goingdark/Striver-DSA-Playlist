package Stack_Queue;

public class PartIX {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMinsOpt(new int[]{3,1,2,4}));
    }

    public static int sumSubarrayMins(int[] arr) {

        long sum = 0;
        int MOD = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min,arr[j]);
                sum = (sum + min) % MOD;
            }
        }
        return (int) sum;

    }
    public static int sumSubarrayMinsOpt(int[] arr) {

        long sum = 0;
        int MOD = 1000000007;
        Stack<Integer> stack = new Stack<>();
        int last_min = Integer.MAX_VALUE;

        for (int num : arr){
            sum = (sum + num) % MOD;
            stack.push(num);

            if (!stack.isEmpty()){
                last_min = Math.min(last_min,stack.pop());
            }

            sum = (sum + last_min ) % MOD;
        }

        return (int) sum;

    }
}
