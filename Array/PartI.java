import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartI {
    public static void main(String[] args) {
        System.out.println(getSecondMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(isSorted(new int[]{1,4,3,4,8}));
        System.out.println(removeDuplicateSet(new int[]{1,1,1,2,2,3,3}));
        System.out.println(removeDuplicate(new int[]{1,1,1,2,2,3,3,3}));

    }

    public static int getMax(int[] arr){
        int max = arr[0];
        for (int val : arr){
            max = Math.max(max , val);
        }
        return max;
    }
    public static int getSecondMax(int[] arr){
        int firstMax = arr[0];
        int secondMax = Integer.MIN_VALUE;

        for (int each : arr){
            if (each > firstMax){
                secondMax = firstMax;
                firstMax = each;
            } else if (each < firstMax && each > secondMax) {
                secondMax = each;
            }
        }
        return secondMax;

    }
    public static String isSorted(int[] arr){
        int i = 0;
        while (i < arr.length && (i + 1) < arr.length) {
            if (arr[i] > arr[i + 1] ){
                return "not_sorted";
            }
            i++;
        }
        return "sorted";
    }
    public static int removeDuplicateSet(int[] arr){
        // O(nlogn + n)
        Set<Integer> set = new HashSet<>();
        for (int each : arr){
            set.add(each);
        }
        int i = 0;
        for (int it : set){
            arr[i] = it;
            i++;
        }
        return i;
    }
    public static int removeDuplicate(int[] arr){
        int f = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[f] != arr[i]){
                arr[f+1] = arr[i];
                f++;
            }
        }
        return f + 1;
    }
}