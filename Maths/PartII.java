package Maths;

import java.util.ArrayList;
import java.util.List;

public class PartII {
    public static void main(String[] args) {
        System.out.println(getPrimes(10));
    }

    public static List<Integer> getPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (isPrimeOpt(i)) list.add(i);
        }

        return list;
    }

    public static boolean isPrime(int num) {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }
        return count == 2;
    }

    public static boolean isPrimeOpt(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                if ((num / i) != i) count++;
            }

            if (count > 2) break;
        }
        return count == 2;
    }
}
