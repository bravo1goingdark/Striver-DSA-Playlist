import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartXII {
    public static void main(String[] args) {
        System.out.println(leadersOpt(new int[]{6,7,4,2,5,3}));
    }

    public static List<Integer> leaders(int[] arr){
        List<Integer> ans = new ArrayList<>();

        for (int j = 0, arrLength = arr.length; j < arrLength; j++) {
            boolean isLeader = true;
            for (int i = j+1; i < arr.length; i++) {
                if (arr[i] > arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) ans.add(arr[j]);
        }
        return ans;
    }
    public static List<Integer> leadersOpt(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int index = arr.length - 1; index >= 0 ; index--) {
            if (arr[index] > max){
                max = arr[index];
                ans.add(arr[index]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
