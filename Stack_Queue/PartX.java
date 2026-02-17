package Stack_Queue;

public class PartX {


    // TC : O(N)
    // SC : O(1)
    public static int trapOptMax(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    total += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    total += rightMax - height[right];
                }
                right--;
            }
        }

        return total;
    }


    // TC : O(2N)
    // SC : O(N)
    public static int trapOpt(int[] height) {

        int prefMax = Integer.MIN_VALUE;
        int[] suff = suffMax(height);
        int total = 0;

        for (int i = 0; i < height.length; i++) {
            prefMax = Math.max(prefMax, height[i]);
            if (height[i] < prefMax && height[i] < suff[i]) {
                total += Math.min(prefMax, suff[i]) - height[i];
            }
        }
        return total;
    }

    // TC : O(3N)
    // SC : O(2N)
    public static int trap(int[] height) {

        int[] pref = prefMax(height);
        int[] suff = suffMax(height);
        int total = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] < pref[i] && height[i] < suff[i]) {
                total += Math.min(pref[i], suff[i]) - height[i];
            }
        }
        return total;
    }

    private static int[] prefMax(int[] arr) {
        int[] pref = new int[arr.length];
        pref[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            pref[i] = Math.max(pref[i - 1], arr[i]);
        }
        return pref;
    }

    private static int[] suffMax(int[] arr) {
        int[] suff = new int[arr.length];
        suff[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            suff[i] = Math.max(suff[i + 1], arr[i]);
        }
        return suff;
    }
}
