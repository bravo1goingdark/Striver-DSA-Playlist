package Bsearch;

import java.util.Arrays;

public class PartXVI {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{10,20,30,40},2));
    }

    // same as painters partition problem and split array largest sum
    public static int splitArray(int[] nums, int k) {
        return allocateBooks(nums,k);

    }
    public static int allocateBooks(int[] books , int noOfStudent){
        int start = getMax(books);
        int end = Arrays.stream(books).sum();

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (canWeAllocate(books,mid) > noOfStudent) start = mid + 1;
            else end = mid - 1 ;
        }
        return start;
    }

    private static int canWeAllocate(int[] books , int pages){
        int countStudent = 1;
        int noOfPages = 0;

        for (int e : books){
            if (noOfPages + e <= pages) noOfPages += e;
            else {
                countStudent++;
                noOfPages = e;
            }
        }
        return countStudent;
    }

    private static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int e : arr){
            max = Math.max(max,e);
        }
        return max;
    }
}
