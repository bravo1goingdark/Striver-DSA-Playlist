package Bsearch;

public class PartXVIII {
    public static void main(String[] args) {

    }

    public static double median(int[] first , int[] second){
        int[] sorted = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length){
            if (first[i] <= second[j]){
                sorted[k] = first[i];
                i++;
            }else  {
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
        int len = sorted.length;
        return len % 2 == 0
                ? (sorted[len/2 - 1] + sorted[len/2]) / 2.0
                : sorted[len / 2] ;
    }
}
