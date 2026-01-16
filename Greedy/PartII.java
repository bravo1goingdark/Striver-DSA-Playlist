package Greedy;

import java.util.Arrays;

public class PartII {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,20,10}));
    }

    public static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int tens = 0;
        int l = 0;

        while (l < bills.length){
            if (bills[l] == 5) {
                five++;
            } else if (bills[l] == 10){
                tens++;
                if (five > 0) five--;
                else return false;
            } else {
                if (five > 0 && tens > 0){
                    five--;
                    tens--;
                }else if (five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
            l++;
        }
        return true;

    }
}
