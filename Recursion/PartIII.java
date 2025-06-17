package Recursion;

import java.util.Arrays;

public class PartIII {
    public static void main(String[] args) {
        reverse(new int[]{1,2,3,4,5},0,4);
        System.out.println(isPalindrome("madam" , 0,4));
        System.out.println(fibIter(5));
        System.out.println(gcd(48,18));
    }

    public static void reverse(int[] arr , int s , int e){
        if (s > e) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        reverse(arr,s + 1 , e - 1);
    }
    public static boolean isPalindrome(String org , int s , int e){
        if (s >= e){
            return true;
        }

        char fch = org.charAt(s);
        char ech = org.charAt(e);

        if (fch != ech) return false;

        return isPalindrome(org , s + 1 , e - 1);
    }

    public static int fib(int n){
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
    public static int fibIter(int n){
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static int gcd(int a , int b){
        if (b == 0) return a;
        return gcd(b , a % b);
    }
}
