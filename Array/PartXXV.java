import java.lang.reflect.Array;
import java.util.Arrays;

public class PartXXV {
    public static void main(String[] args) {
        System.out.println(countInvBrute(new int[]{5, 3, 2, 4, 1}));
        System.out.println(mergeSort(new int[]{5, 3, 2, 4, 1}));
    }

    public static int countInvBrute(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) count++;
            }
        }

        return count;
    }

    private static int mergeSort(int[] arr) {
        if (arr.length <= 1) return 0;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        int count = 0;
        count += mergeSort(left);
        count += mergeSort(right);
        count += mergeAndSort(left, right, arr);

        return count;
    }

    private static int mergeAndSort(int[] left, int[] right, int[] merged) {
        int i = 0, j = 0, k = 0, count = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                count += left.length - i;
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

        return count;
    }

}
