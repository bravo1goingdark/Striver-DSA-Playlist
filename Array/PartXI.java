import java.util.Arrays;

public class PartXI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(next(new int[]{2,1,5,4,3,0,0})));

    }

    public static void nextPermuteBruteForce(int[] arr){
        // the bruteforce solution to this question can be generated using these steps:
        // 1 -> generate all permutation of the given array - > O(n!)
        // 2 -> iterate and find the given permutation index -> O(n)
        // 3 -> return the permutation[index+1]
        // 4 -> if index == arr.length , then return permutation[0] <- this would be the first permutation
        // time comp -> O(n! * n)
    }

    public static int[] next(int[] arr){
        // Find the pivot: Traverse from right to left and find the first index i where arr[i] < arr[i + 1].
        // If none found, reverse the entire array and return (last permutation → first).
        // Find the successor and swap: From the right, find the first element arr[j] > arr[i] and swap them.
        //Reverse the suffix: Reverse the subarray from i + 1 to the end to get the next smallest lexicographic order.
        int index = -1;

        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }

        if (index == -1) return reverse(arr,0,arr.length - 1);

        for (int i = arr.length - 1; i >= index ; i--) {
            if (arr[i] > arr[index]){
                swap(arr,i,index);
                break;
            }
        }

        return reverse(arr,index + 1,arr.length-1);

    }
    public static void swap(int[] arr , int f ,int s){
        PartVI.swap(arr, f, s);
    }
    public static int[] reverse(int[] arr,int f,int s){
        int start = f;
        int end = s;

        while (start < end){
            PartVI.swap(arr,start,end);
            start++;
            end--;
        }
        return arr;
    }

}
