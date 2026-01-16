// https://leetcode.com/problems/assign-cookies/

package Greedy;

import java.util.Arrays;

public class PartI {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 5, 3, 3, 4}, new int[]{4, 2, 1, 2, 1, 3}));
    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;

        while (l < g.length && r < s.length) {
            if (s[r] >= g[l]) l++;
            r++;
        }

        return l; // l index would be no of children content with cookies distribution
    }
}
