package Bsearch;

public class PartVIII {

    public static void main(String[] args) {
        System.out.println(root(8));
    }
    
    
    
    public static int root(int number){
        int start = 0;
        int end = number;

        while (start <= end){
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;

            if (square == number) return mid;
            if (square > number) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }
}
