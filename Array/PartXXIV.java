import java.util.Arrays;

public class PartXXIV {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1,3,5,7},new int[]{0,2,6,8,9})));
        mergeOptGap(new int[]{1,3,5,7},new int[]{0,2,6,8,9});
    }


    public static int[] merge(int[] first, int[] second) {
        int[] sorted = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length){
            if (first[i] <= second[j]){
                sorted[k] = first[i];
                i++;
            }else {
                sorted[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length){
            sorted[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length){
            sorted[k] = second[j];
            j++;
            k++;
        }

        return sorted;
    }
    public static void mergeOpt(int[] first, int[] second) {

        int f = first.length - 1;
        int s = 0;

        while (f >= 0 && s < second.length){
            if (first[f] > second[s]){
                int temp = first[f];
                first[f] = second[s];
                second[s] = temp;
                f--;
                s++;
            }else {
                break;
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);
    }
    public static void mergeOptGap(int[] first, int[] second) {
        int n = first.length;
        int m = second.length;
        int len = n + m;

        int gap = len / 2 + len % 2;

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // Case 1: both in first[]
                if (left < n && right < n) {
                    swapIfGreater(first, first, left, right);
                }

                // Case 2: left in first[], right in second[]
                else if (left < n && right >= n) {
                    swapIfGreater(first, second, left, right - n);
                }

                // Case 3: both in second[]
                else if (left >= n && right >= n) {
                    swapIfGreater(second, second, left - n, right - n);
                }

                left++;
                right++;
            }

            if (gap == 1) break;

            gap = gap / 2 + gap % 2;
        }

        System.out.println("First:  " + Arrays.toString(first));
        System.out.println("Second: " + Arrays.toString(second));
    }
    private static void swapIfGreater(int[] f , int[] s , int first , int sec){
        if (f[first] > s[sec]){
            int temp = f[first];
            f[first] = s[sec];
            s[sec] = temp;
        }
    }
}
