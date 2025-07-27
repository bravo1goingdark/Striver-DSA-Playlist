package SlidingWindowTP;

import java.util.Arrays;
import java.util.Map;

public class PartVIII {
    public static void main(String[] args) {
        System.out.println(numberOfSubstringsOpt("abcabc"));
    }

    public static int numberOfSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer[] hash = new Integer[3];
            Arrays.fill(hash, 0);
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                hash[ch - 'a'] = 1;

                if (hash[0] + hash[1] + hash[2] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numberOfSubstringsBetter(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer[] hash = new Integer[3];
            Arrays.fill(hash, 0);
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                hash[ch - 'a'] = 1;

                if (hash[0] + hash[1] + hash[2] == 3) {
                    count += s.length() - j;
                    break;
                }
            }
        }
        return count;
    }

    public static int numberOfSubstringsOpt(String s) {

        int count = 0;
        int[] hash = new int[3];
        Arrays.fill(hash, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hash[ch - 'a'] = i;

            count = count + (1 + Math.min(hash[0], Math.min(hash[1], hash[2])));

        }
        return count;
    }
}
