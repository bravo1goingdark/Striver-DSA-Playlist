import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PartVI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2,0,1}) ));
        System.out.println(Arrays.toString(dutchNationalFlag(new int[]{1,0,2,1,0,1,0,2,1})));
    }

    // sort an array which consist of 0,1,2
    public static int[] sortZOT(int[] arr){

        // first solution is to directly sort the array
        // which takes O(nlogn) time comp
        Arrays.sort(arr);
        return arr;
    }
    public static int[] sort(int[] arr){

        // the better solution involve counting number of 0's 1's & 2
        // after counting we iterate the org arr
        // and directly put the counted number of 0,1,2
        // int the order
        // time comp - O(2N) space comp - O(1)
        int zeroes = 0;
        int ones = 0;
        int twos = 0;

        for (int e : arr){
            if (e == 0) zeroes++;
            else if (e == 1) ones++;
            else twos++;
        }

        for (int i = 0; i < zeroes; i++) arr[i] = 0;
        for (int i = 0; i < ones; i++) arr[zeroes + i] = 1;
        for (int i = 0; i < twos; i++) arr[zeroes + ones + i] = 2;
        return arr;
    }
    public static int[] dutchNationalFlag(int[] arr){
        // time comp -> O(N)
        // space comp -> O(1)
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high){
            if (arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            }else {
                swap(arr,mid,high);
                high--;
            }
        }
        return arr;

    }
    public static void swap(int[] arr , int f , int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
