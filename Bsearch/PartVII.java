package Bsearch;

public class PartVII {
    public static void main(String[] args) {

        System.out.println(findPeak(new int[]{1,2,1,3,5,6,4}));
    }


    public static int findPeak(int[] arr) {
        int len = arr.length;
        if (len == 1) return 0;

        if (arr[0] > arr[1]) return 0;
        if (arr[len - 1] > arr[len - 2]) return len - 1;

        int start = 1;
        int end = len - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;

            if (arr[mid] < arr[mid + 1]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
