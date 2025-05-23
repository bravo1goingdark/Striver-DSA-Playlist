import java.util.*;

public class PartII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRotBy1(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(leftRotByKOpt(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(moveZeroesOpt(new int[]{1, 0, 2, 3, 2, 0, 0, 4, 5, 1})));
        System.out.println(Arrays.toString(union(new int[]{1,1,2,3,4,5} , new int[]{2,3,4,4,5,6})));
        System.out.println(Arrays.toString(intersection(new int[]{1,1,2,3,4,5} , new int[]{2,3,4,4,5,6})));
        System.out.println(Arrays.toString(intersectionOpt(new int[]{2,3,4,5} , new int[]{1,4})));
    }

    public static int[] leftRotBy1(int[] arr) {
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;

        return arr;
    }

    public static int[] leftRotByK(int[] arr, int k) {
        k = k % arr.length;
        int[] temp = new int[k];
        System.arraycopy(arr, 0, temp, 0, k);

        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = 0; i < k; i++) {
            arr[arr.length - k + i] = temp[i];
        }

        return arr;
    }

    public static int[] leftRotByKOpt(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k);
        reverse(arr, arr.length - k - 1, arr.length);
        reverse(arr, 0, arr.length);
        return arr;

    }

    private static void rightRotByKOpt(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - k);
        reverse(arr, arr.length - k, arr.length);
        reverse(arr, 0, arr.length);
    }

    private static void reverse(int[] arr, int f, int s) {
        while (f < s) {
            int temp = arr[f];
            arr[f] = arr[s - 1];
            arr[s - 1] = temp;
            f++;
            s--;
        }
    }

    public static int[] moveZeroes(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int e : arr) if (e != 0) list.add(e);
        int nz = arr.length - list.size();

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        for (int i = arr.length - nz; i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public static int[] moveZeroesOpt(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    public static int[] union(int[] f, int[] s) {
        Set<Integer> set = new TreeSet<>();
        for (int e : f) set.add(e);
        for (int e : s) set.add(e);

        int[] union = new int[set.size()];
        int i = 0;
        for (int it : set) union[i++] = it;
        return union;
    }

    public static int[] unionOpt(int[] f, int[] s) {
        List<Integer> list = new ArrayList<>();
        int first = 0;
        int second = 0;

        while (first < f.length && second < s.length) {
            if (f[first] <= s[second]) {
                if (list.isEmpty() || list.get(list.size() - 1) != f[first]) {
                    list.add(f[first]);
                }
                first++;
            } else {

                if (list.isEmpty() || list.get(list.size() - 1) != s[second]) {
                    list.add(s[second]);
                }
                second++;

            }
        }

        while (first < f.length){
            if (list.isEmpty() || list.get(list.size() - 1) != f[first]) {
                list.add(f[first]);
            }
            first++;
        }
        while (second < s.length){
            if (list.isEmpty() || list.get(list.size() - 1) != s[second]) {
                list.add(s[second]);
            }
            second++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersection(int[] f , int[] s){
        int[] vis = new int[s.length];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(vis,0);
        for (int k : f) {
            for (int j = 0; j < s.length; j++) {
                if (k == s[j] && vis[j] == 0) {
                    list.add(k);
                    break;
                }
                if (k < s[j]) break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static int[] intersectionOpt(int[] f , int[] s){
        int first = 0;
        int second = 0;
        List<Integer> list = new ArrayList<>();

        while (first < f.length && second < s.length){
            if (f[first] == s[second]){
                list.add(f[first]);
                first++;
                second++;
            }else if (f[first] < s[second]){
                first++;
            } else {
                second++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
