import java.util.*;

import static java.util.Collections.swap;

public class PartIII {
    public static void main(String[] args) {
        System.out.println(missingHash(new int[]{1,2,3,4,5} , 5));
        System.out.println(missing(new int[]{5,4,3,2,1} , 5));
        System.out.println(missing(new int[]{5,4,3,1}));
        System.out.println(findDisappearedNumber(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findAllDuplicate(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,4,2,2})));
        System.out.println(singleNumber(new int[]{1,1,2,3,3,4,4}));
        System.out.println(findMaxConsecOnes(new int[]{1,1,0,1,1,1}));
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

    public static int missing(int[] arr){
        int f = 0;

        // cyclic sort
        while (f < arr.length){
            int correctIndex = arr[f]; // from 0 to N
            if (correctIndex < arr.length && arr[correctIndex] != arr[f]){
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[f];
                arr[f] = temp;
            }else {
                f++;
            }
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index){
                return index;
            }
        }

        return -1;
    }
    public static List<Integer> findDisappearedNumber(int[] arr){
        int f = 0;

        while (f < arr.length){
            int correct = arr[f] - 1;
            if (arr[f] != arr[correct]){
                int temp = arr[f];
                arr[f] = arr[correct];
                arr[correct] = temp;
            }else {
                f++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length ; index++) {
            if (arr[index] != index + 1){
                ans.add(index+1);
            }
        }

        return ans;
    }
    public static int findDuplicate(int[] arr) {
        int f = 0;

        while (f < arr.length){
            int correct = arr[f] - 1;
            if (arr[f] != arr[correct]){
                int temp = arr[f];
                arr[f] = arr[correct];
                arr[correct] = temp;
            }else {
                f++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1){
                return arr[i];
            }
        }
        return -1;

    }
    public static List<Integer> findAllDuplicate(int[] arr) {
        int f = 0;

        while (f < arr.length){
            int correct = arr[f] - 1;
            if (arr[f] != arr[correct]){
                int temp = arr[f];
                arr[f] = arr[correct];
                arr[correct] = temp;
            }else {
                f++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1){
                list.add(arr[i]);
            }
        }
        return list;

    }
    public static int[] findErrorNums(int[] arr) {
        int f = 0;

        while (f < arr.length){
            int correct = arr[f] - 1;
            if (arr[f] != arr[correct]){
                int temp = arr[f];
                arr[f] = arr[correct];
                arr[correct] = temp;
            }else {
                f++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1){
                return new int[]{arr[i] , i + 1};
            }
        }
        return new int[]{-1,-1};

    }
    public static int firstMissingPositive(int[] arr) {
        int f = 0;

        while (f < arr.length){
            int correct = arr[f] - 1;

            if (arr[f] > 0 && arr[f] <= arr.length && arr[f] != arr[correct]){
                int temp = arr[f];
                arr[f] = arr[correct];
                arr[correct] = temp;
            }else {
                f++;
            }
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1){
                return index + 1;
            }
        }
        // case 2 : if all element are present in the range of [1,n]
        return arr.length + 1;

    }

    public static int findMaxConsecOnes(int[] arr){
        int max = 0;
        int count = 0;

        for (int e : arr){
            if (e == 1){
                count++;
                max = Math.max(max,count);
            }else {
                count = 0;
            }
        }
        return max;
    }

    // find the number that appears once and the other twice
    public static int singleNumber(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();

        for (int e : arr) {
            if (!map.containsKey(e)){
                map.put(e , map.getOrDefault(e ,0) + 1);
            }else {
                map.put(e , map.getOrDefault(e,0) + 1);
            }
        }
        for (int e : arr){
            if (map.get(e) == 1){
                return e;
            }
        }
        return -1;
    }

    public static int singleNumberOpt(int[] arr) {
        int ans = 0;
        for (int e : arr)  ans ^= e;
        return ans;
    }

}
