import java.util.Arrays;

public class PartXXVI {
    public static void main(String[] args) {
        System.out.println(reversePair(new int[]{40,25,19,12,9,6,2}));
        System.out.println(reversePairs(new int[]{40,25,19,12,9,6,2}));
    }

    public static int reversePairs(int[] nums) {
        int countRevPairs = 0;


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]){
                    countRevPairs++;
                }
            }
        }
        return countRevPairs;

    }

    public static int reversePair(int[] nums) {
        return mergeSort(nums);
    }
    private static int mergeSort(int[] arr) {
        int count = 0;
        if (arr.length <= 1) return count;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        count += mergeSort(left);
        count += mergeSort(right);
        count += countPair(left,right);
        mergeAndSort(left, right, arr);

        return count;
    }

    private static int countPair(int[] l, int[] r) {
        int count = 0;
        int low = 0;
        int mid = l.length - 1;
        int right = 0;
        int high = r.length - 1;

        for (int i = low; i <= mid ; i++) {

            while (right <= high && l[i] > 2 * r[right]){
                right++;
            }
            count += right;

        }
        return count;
    }

    private static void mergeAndSort(int[] left, int[] right, int[] merged) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            merged[k] = right[j];
            k++;
            j++;
        }

    }
}
