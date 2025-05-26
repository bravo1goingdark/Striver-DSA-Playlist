import java.util.Arrays;

public class PartVIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kadaneSub(new int[]{-2,1,-3,4,-1,2,1,-5,4})));

    }
    public static int maxSubArrSum(int[] arr){
        // time comp - O(N2)
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr += arr[j];
                maxSum = Math.max(maxSum , curr);
            }
        }
        return maxSum;
    }
    public static int kadane(int[] arr){
       int maxSum = Integer.MIN_VALUE;
       int sum = 0;

       for (int e : arr){
           sum += e;
           maxSum = Math.max(maxSum,sum);
           if (sum < 0) sum = 0;
       }
       return maxSum;
    }
    public static int[] kadaneSub(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;        // start of current best subarray
        int end = 0;          // end of current best subarray
        int tempStart = 0;    // candidate start of the next subarray

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                start = tempStart;  // confirm this is the new best start
                end = i;            // update end as current index
            }

            if (sum < 0) {
                sum = 0;            // reset sum
                tempStart = i + 1;  // next index could be new start
            }
        }

        return Arrays.copyOfRange(arr, start, end + 1);
    }


}
