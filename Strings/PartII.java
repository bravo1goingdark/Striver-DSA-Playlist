// https://leetcode.com/problems/reverse-words-in-a-string/description/

package Strings;

import java.util.Arrays;

public class PartII {
    public static void main(String[] args) {
        System.out.println(reverseWordsOpt("a good   example"));
    }


    public static String reverseWords(String str) {

        String[] data = str.split(" ");

        int s = 0;
        int e = data.length - 1;

        while (s < e) {
            String temp = data[s];
            data[s] = data[e];
            data[e] = temp;
            s++;
            e--;
        }

        System.out.println(Arrays.toString(data));

        StringBuilder ans = new StringBuilder();
        for (String st : data) {
            if (!st.isEmpty()) {
                if (!ans.isEmpty()) ans.append(" ");
                ans.append(st);
            }
        }

        return ans.toString();
    }

    public static String reverseWordsOpt(String str) {


        StringBuilder ans = new StringBuilder();
        int  i = str.length() - 1;

        while (i >= 0){

            // skip whitespaces
            while (i >= 0 && str.charAt(i) == ' ') i--;

            // word may only contain whitespaces
            if (i < 0) break;

            // start of our word from end
            int j = i;

            // we iterate backwards until we find whitespace
            while (i >= 0 && str.charAt(i) != ' '){
                i--;
            }

            // we append the collected substring
            ans.append(str, i + 1, j + 1).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }




}
