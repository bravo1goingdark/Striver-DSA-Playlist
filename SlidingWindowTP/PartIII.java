package SlidingWindowTP;

public class PartIII {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{6,2,3,4,7,2,1,7,1} , 4));
    }

    public static int maxScore(int[] cardPoints, int k) {

        int lsum = 0;
        int rsum = 0;

        for (int i = 0; i < k; i++) lsum += cardPoints[i];
        int max = lsum;


        int rIndex = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rIndex];
            rIndex--;
            max = Math.max(max, lsum + rsum);
        }
        return max;
    }
}
