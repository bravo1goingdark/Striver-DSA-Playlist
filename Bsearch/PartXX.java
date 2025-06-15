package Bsearch;

public class PartXX {
    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{3, 4}, new int[]{1, 2}));
    }


    public static double findMedian(int[] first, int[] second) {
        int first_len = first.length;
        int sec_len = second.length;
        if (first_len > sec_len) return findMedian(second, first);

        int start = 0;
        int end = first_len;
        int left = (first_len + sec_len + 1) / 2;

        while (start <= end) {
            int m1 = start + (end - start) / 2;
            int m2 = left - m1;

            int l1 = (m1 > 0) ? first[m1 - 1] : Integer.MIN_VALUE;
            int l2 = (m2 > 0) ? second[m2 - 1] : Integer.MIN_VALUE;
            int r1 = (m1 < first_len) ? first[m1] : Integer.MAX_VALUE;
            int r2 = (m2 < sec_len) ? second[m2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((first_len + sec_len) % 2 == 1) return Math.max(l1, l2);
                else return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) end = m1 - 1;
            else start = m1 + 1;
        }
        return -1.0;
    }

    public static double kthElement(int[] first, int[] second, int k) {
        int first_len = first.length;
        int sec_len = second.length;
        if (first_len > sec_len) return kthElement(second, first, k);

        if (k == 1) {
            return Math.min(first.length > 0 ? first[0] : Integer.MAX_VALUE,
                    second.length > 0 ? second[0] : Integer.MAX_VALUE);
        }

        int start = Math.max(0, k - sec_len);
        int end = Math.min(k, first_len);

        int left = (first_len + sec_len + 1) / 2;

        while (start <= end) {
            int m1 = start + (end - start) / 2;
            int m2 = left - m1;

            int l1 = (m1 > 0) ? first[m1 - 1] : Integer.MIN_VALUE;
            int l2 = (m2 > 0) ? second[m2 - 1] : Integer.MIN_VALUE;
            int r1 = (m1 < first_len) ? first[m1] : Integer.MAX_VALUE;
            int r2 = (m2 < sec_len) ? second[m2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
            else if (l1 > r2) end = m1 - 1;
            else start = m1 + 1;
        }
        return -1.0;
    }
}
