package Bsearch;

public class PartVIII {

    public static void main(String[] args) {
        System.out.println(root(8));
        System.out.println(nroot(27,3));
    }
    
    
    
    public static int root(int number){
        int start = 0;
        int end = number;

        while (start <= end){
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;

            if (square == number) return mid;
            else if (square > number) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }

    public static int nroot(int number , int n){
        int start = 0;
        int end = number / n;

        while (start <= end){
            int mid = start + (end - start) / 2;

            long square = (long) Math.pow(mid,n);

            if (square == number) return mid;
            else if (square > number) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }
}
