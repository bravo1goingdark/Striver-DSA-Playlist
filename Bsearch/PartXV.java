package Bsearch;

import java.util.Arrays;

public class PartXV {
    public static void main(String[] args) {
        System.out.println(allocateBooks(new int[]{25,46,28,49,24},4));
    }


    public static int allocateBooks(int[] books , int noOfStudent){
        int start = getMax(books);
        int end = Arrays.stream(books).sum();

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (canWeAllocate(books,mid) >= noOfStudent) start = mid + 1;
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
