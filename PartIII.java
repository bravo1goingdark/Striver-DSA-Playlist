public class PartIII {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];


        for (char c : s1.toCharArray()) {
            s1Map[c - 'a']++;
        }

        int window = s1.length();

        for (int i = 0; i < window; i++) {
            s2Map[s2.charAt(i) - 'a']++;
        }


        if (matches(s1Map, s2Map)) return true;

        for (int i = window; i < s2.length(); i++) {
            s2Map[s2.charAt(i) - 'a']++;
            s2Map[s2.charAt(i - window) - 'a']--;

            if (matches(s1Map, s2Map)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }


}
