public class PartX {
    public static void main(String[] args) {
        System.out.println(buySell(new int[]{7,1,5,4,6,4}));
    }
    public static int maxProfit(int[] prices) {
        // time comp - O(N2) will hit TLE
        // space comp - O(1)
        int gMx = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i ; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                max = Math.max(max , profit);
            }
            gMx = Math.max(gMx,max);
        }
        return gMx;
    }
    public static int buySell(int[] prices) {

        int min = prices[0];
        int profit = 0;
        for (int e : prices){
            int cost = e - min;
            profit = Math.max(profit , cost);
            min = Math.min(min,e);
        }
        return profit;
    }
}
