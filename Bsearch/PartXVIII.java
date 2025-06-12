package Bsearch;

public class PartXVIII {
    public static void main(String[] args) {
        System.out.println(medianSpaceOpt(new int[]{1,3,4,7,10,12},new int[]{2,6,15}));

    }

    public static double median(int[] first, int[] second) {
        int[] sorted = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                sorted[k] = first[i];
                i++;
            } else {
                sorted[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            sorted[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            sorted[k] = second[j];
            j++;
            k++;
        }
        int len = sorted.length;
        return len % 2 == 0
                ? (sorted[len / 2 - 1] + sorted[len / 2]) / 2.0
                : sorted[len / 2];
    }

    public static double medianSpaceOpt(int[] first, int[] second) {
        int len = first.length + second.length;

        int index1 = len / 2 - 1;
        int index2 = index1 + 1;

        int e1 = -1;
        int e2 = -1;

        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            int val;
            if (first[i] <= second[j]) {
                val = first[i++];
            } else {
                val = second[j++];
            }
            if (k == index1) e1 = val;
            if (k == index2) e2 = val;
            k++;
        }

        while (i < first.length) {
            int val = first[i++];
            if (k == index1) e1 = val;
            if (k == index2) e2 = val;
            k++;
        }

        while (j < second.length) {
            int val = second[j++];
            if (k == index1) e1 = val;
            if (k == index2) e2 = val;
            k++;
        }

        return len % 2 == 0 ? (e1 + e2) / 2.0 : e2;
    }

}
