import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartIII {
    public static void main(String[] args) {
        System.out.println(missingHash(new int[]{1,2,3,4,5} , 5));
        System.out.println(missingXor(new int[]{9,6,4,2,3,5,7,0,1} , 9));
    }

    public static int missing(int[] arr , int n){
        for (int i = 1; i < n; i++) {
            boolean found = false;
            for (int k : arr) {
                if (i == k) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }
    public static int missingHash(int[] arr , int n){
        int[] hash = new int[n+1];
        Arrays.fill(hash,0);
        for (int e : arr) hash[e] = 1;
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] != 1) return i;
        }
        return -1;
    }

    public static int missingSum(int[] arr , int n){
        int actual_sum = Arrays.stream(arr).sum();
        int expect_sum = n * (n + 1) / 2;
        return expect_sum - actual_sum;
    }
    public static int missingXor(int[] arr , int n){
        int f = 0;
        int s = 0;
        for (int i = 1; i <= n; i++)  f ^= i;
        for (int e : arr) s ^= e;

        return f ^ s;
    }
}
