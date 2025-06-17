package Recursion;

public class PartI {
    public static void main(String[] args) {
//        printNameKTimes(5);
//        printNaturalNo1toN(9,1);
//        printNaturalNoNto1(9);
        printNaturalNoNto1BackTrack(9,0);
        printNaturalNo1toN(5);
    }


    public static void printNameKTimes(int k){
        if (k <= 0) return;

        System.out.println("Ashutosh");
        printNameKTimes(--k);
    }
    public static void printNaturalNo1toN(int n , int curr){
        if (curr > n) return;

        System.out.println(curr);
        printNaturalNo1toN(n,++curr);
    }
    public static void printNaturalNoNto1(int n){
        if (n <= 0) return;

        System.out.println(n);
        printNaturalNoNto1(--n);
    }
    public static void printNaturalNoNto1BackTrack(int n , int curr){
        if (curr > n) return;

        printNaturalNoNto1BackTrack(n,++curr);
        System.out.println(curr);
    }
    public static void printNaturalNo1toN(int n){
        if (n <= 0) return;

        printNaturalNo1toN(n - 1);
        System.out.println(n);
    }

}
