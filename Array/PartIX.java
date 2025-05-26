import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartIX {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArrayOpt(new int[]{3,1,-2,-5,2,-4})));
        System.out.println(Arrays.toString(rearrange(new int[]{-1,2,3,4,-3,1,-6})));

    }
    // here number of positive number == number of negative number like [3,1,-2,-5,2,-4]
    public static int[] rearrangeArray(int[] nums) {
        // time comp - O(N + N/2)
        // space Comp - O(N)
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int e : nums) {
            if (e > 0) pos.add(e);
            else neg.add(e);
        }

        for (int index = 0; index < nums.length / 2; index++) {
            nums[2 * index] = pos.get(index);
            nums[2 * index + 1] = neg.get(index);
        }
        return nums;

    }
    public static int[] rearrangeArrayOpt(int[] arr){
        // time comp - O(N)
        // space comp - O(N)
        int pos = 0;
        int neg = 1;
        int[] ans = new int[arr.length];

        int index = 0;
        while (index < arr.length){
            if (arr[index] > 0) {
                ans[pos] = arr[index];
                pos = pos + 2;
            }else {
                ans[neg] = arr[index];
                neg = neg + 2;
            }
            index++;
        }
        return ans;
    }


    // here number of positive number != number of negative number like [-1,2,3,4,-3,1]
    public static int[] rearrange(int[] arr){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int e : arr) {
            if (e > 0) pos.add(e);
            else neg.add(e);
        }

        if (pos.size() > neg.size()){
            for (int i = 0; i < neg.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int index = 2 * neg.size();
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        }else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int index = 2 * pos.size();
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }

}
