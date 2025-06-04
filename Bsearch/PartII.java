package Bsearch;

import java.util.Arrays;

import static Bsearch.PartI.lowerBound;
import static Bsearch.PartI.upperBound;

public class PartII {
    public static void main(String[] args) {
        System.out.print(firstOccurrence(new int[]{1,2,3,3,5,8,8,8,10,10,11} , 8) + " ");
        System.out.print(lastOccurrence(new int[]{1,2,3,3,5,8,8,8,10,10,11} , 8));
        System.out.println(Arrays.toString(firstAndLast(new int[]{1,2,3,3,5,8,8,8,10,10,11} , 8)));
    }
    public static int ceil(int[] arr,int target){
        return lowerBound(arr,target) == arr.length ? -1 : arr[lowerBound(arr,target)];
    }
    public static int[] firstAndLast(int[] arr,int target){
        int lb = lowerBound(arr, target);

        if (lb == arr.length || target != arr[lb]) return new int[]{-1,-1};

        int ub = upperBound(arr, target);

        return new int[]{lb , ub - 1};
    }

    public static int firstOccurrence(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int first = -1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target) {
                first = mid;
                end = mid - 1;
            }
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int last = -1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target) {
                last = mid;
                start = mid + 1;
            }
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return last;
    }
}
