package BitManipulation;

public class PartVII {
    public static void main(String[] args) {
        System.out.println(divideOpt(22,3));
    }
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if (dividend == divisor) return 1;
        boolean isNegative = dividend < 0 && divisor > 0 || divisor < 0 && dividend > 0;

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int sum = 0;
        int count = 0;

        while (sum + b <= a){
            sum += b;
            count++;
        }
        return isNegative ? -count : count;
    }
    public static int divideOpt(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == divisor) return 1;

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int quotient = 0;

        while (n >= d) {
            int cnt = 0;

            // Double the divisor until it exceeds the remaining dividend
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            quotient += 1 << cnt;  // Add 2^cnt times to result
            n -= d << cnt;         // Subtract d * 2^cnt from dividend
        }

        return isNegative ? -quotient : quotient;
    }


}
