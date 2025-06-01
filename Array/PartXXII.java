import java.util.HashMap;
import java.util.Map;

public class PartXXII {


    public static void main(String[] args) {
        System.out.println(subarraysWithXorK(new int[]{4, 2, 2, 6, 4}, 6));

    }

    public static int subarraysWithXorKBrute(int[] arr, int k) {
        // time comp -> O(n*n*n)
        // space comp -> O(1)
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int xor = 0;
                for (int l = i; l <= j; l++) {
                    xor ^= arr[l];
                }
                if (xor == k) count++;

            }
        }

        return count;
    }

    public static int subarraysWithXorKBetter(int[] arr, int k) {

        // time comp -> O(n*n)
        // space comp -> O(1)
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) count++;
            }
        }

        return count;
    }
    public static int subarraysWithXorK(int[] arr, int k) {

        // time comp -> O(n)
        // space comp -> O(n)
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int xor = 0;
        int count = 0;

        for (int e : arr){
            xor = xor ^ e;
            int req = xor ^ k;

            count += map.getOrDefault(req,0);
            map.put(xor,map.getOrDefault(xor,0) + 1);
        }

        return count;
    }
}
