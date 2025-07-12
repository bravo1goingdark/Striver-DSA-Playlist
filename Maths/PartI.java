package Maths;

import java.util.ArrayList;
import java.util.List;

public class PartI {
    public static void main(String[] args) {
        extractDigit(9876);
        System.out.println(reverse(3897));
        System.out.println(isPalindrome(121));
        System.out.println(getAllArmstrongBetweenRange(400,10000));
        getDivisors(36);



    }


    public static void extractDigit(int num) {

        while (num != 0) {
            int rem = num % 10;
            System.out.print(rem + " ");
            num = num / 10;
        }
        System.out.println();
    }

    public static int reverse(int num) {

        int rev = 0;

        while (num != 0) {
            int rem = num % 10;
            rev = (rev * 10) + rem;
            num = num / 10;
        }
        return rev;
    }

    public static boolean isPalindrome(int num) {
        return num == reverse(num);
    }

    public static boolean isArmstrong(int num) {
        int sum = 0;
        int dup = num;

        while (num != 0) {
            int rem = num % 10;
            sum += (int) Math.pow(rem,3);
            num = num / 10;
        }
        return dup == sum;
    }
    public static List<Integer> getAllArmstrongBetweenRange(int low , int high){
        List<Integer> list = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            if (isArmstrong(i)) list.add(i);
        }
        return list;
    }

    public static void getDivisors(int num){

        for (int i = 1; i * i <= num ; i++) {
            if (num % i == 0){
                System.out.print(i + " ");

                if ((num / i) != i){
                    System.out.print(num / i + " ");
                }
            }
        }
    }
}
