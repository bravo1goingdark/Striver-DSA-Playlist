// https://leetcode.com/problems/largest-odd-number-in-string/description/

package Strings;

public class PartIII {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("7542351162"));
    }

    public static String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {
            int val = num.charAt(i) - '0';

            if (val % 2 != 0) return num.substring(0, i + 1);
        }
        return "";
    }
}
