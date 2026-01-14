// https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

package Strings;

public class PartI {

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(beautySum(str));


    }

    public static int beautySum(String str) {

        int ans = 0;


        for (int i = 0; i < str.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < str.length(); j++) {
                freq[str.charAt(j) - 'a']++;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                ans += (max - min);
            }
        }
        return ans;
    }
}
