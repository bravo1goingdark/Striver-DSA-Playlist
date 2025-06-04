package Bsearch;

import java.util.Arrays;

public class PartI {
    public static void main(String[] args) {
        System.out.println(upperBound(new int[]{1,2,3,3,5,8,8,10,10,11} , 8));
        System.out.println(floor(new int[]{1,2,3,3,5,8,8,10,10,11} , 8));
        System.out.println(ceil(new int[]{1,2,3,3,5,8,8,10,10,11} , 8));
        System.out.println(searchInsertPos(new int[]{1,2,3,3,5,8,8,10,10,11} , 4));
    }

    public static int lowerBound(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return ans;
    }
    public static int searchInsertPos(int[] arr,int target){
        return lowerBound(arr,target);
    }
    public static int ceil(int[] arr,int target){
        return lowerBound(arr,target) == arr.length ? -1 : arr[lowerBound(arr,target)];
    }

    public static int floor(int[] arr,int target){
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target){
                ans = arr[mid];
                start = mid + 1;
            }
            else end = mid - 1;

        }
        return ans;
    }

    public static int upperBound(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] > target) {
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return ans;
    }

    public static int bs(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}