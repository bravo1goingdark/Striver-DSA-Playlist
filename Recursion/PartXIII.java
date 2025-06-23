package Recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PartXIII {
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"01", "10"}));
    }

    public static String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, nums);
        return uniq("", nums.length, set);

    }

    private static String uniq(String ans, int length, Set<String> set) {
        if (ans.length() == length) {
            if (set.contains(ans)) {
                return null;
            }
            return ans;
        }
        // zero try
        String zt = uniq(ans + '0', length, set);
        if (zt != null) return zt;

        // one try
        return uniq(ans + '1', length, set);

    }

    public int totalNQueens(int n) {
        boolean[] r = new boolean[n];
        boolean[] tlbr = new boolean[2 * n];
        boolean[] trbl = new boolean[2 * n];
        return nQueenOpt(0, r, tlbr, trbl);
    }

    public static int nQueenOpt(int col, boolean[] r, boolean[] tlbr, boolean[] trbl) {

        if (r.length == col) {
            return 1;
        }
        int count = 0;

        for (int row = 0; row < r.length; row++) {
            int topLeftBR = row + col;
            int topRightBL = row - col + r.length;

            if (r[row] || tlbr[topLeftBR] || trbl[topRightBL]) continue;

            r[row] = true;
            tlbr[topLeftBR] = true;
            trbl[topRightBL] = true;

            count += nQueenOpt(col + 1, r, tlbr, trbl);

            r[row] = false;
            tlbr[topLeftBR] = false;
            trbl[topRightBL] = false;
        }
        return count;

    }
}
