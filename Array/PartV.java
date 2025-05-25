import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartV {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumOpt(new int[]{3,2,4},6)));
        System.out.println(Arrays.toString(twoSum2Point(new int[]{2,5,6,8,11} , 14)));
    }
    
    public static int[] twoSum(int[] arr , int target){
        // time comp - O(N2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumOpt(int[] arr , int target){
        // time comp - O(N)
        // space comp - O(N)
        Map<Integer,Integer> map = new HashMap<>();
        int first = 0;

        while (first < arr.length){
            int t = target - arr[first];

            if (map.containsKey(t)){
                return new int[]{map.get(t),first};
            }
            map.put(arr[first],first);
            first++;
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSum2Point(int[] arr,int target){
        // work only if array is sorted
        // time comp O(N)
        // space comp 0(1)
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int sum = arr[left] + arr[right];

            if (sum == target) return new int[]{left,right};
            else if (sum < target) {
                left++;
            }else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
