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

    public static int mergeSort(int[] arr) {
        if (arr.length <= 1) return 0;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        int count = 0;
        count += mergeSort(left);
        count += mergeSort(right);
        count += merge(left, right);

        return count;
    }

    private static int merge(int[] first, int[] second) {
        int count = 0;
        int i = 0;
        int j = 0;

        while (i < first.length && j < second.length){
            if (first[i] < second[j]){
                i++;
            }else {
                count += first.length - i;
                j++;
            }
        }

       return count;
    }
}
