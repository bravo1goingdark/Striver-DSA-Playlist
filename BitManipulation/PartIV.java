package BitManipulation;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class PartIV {
    public static void main(String[] args) {
        System.out.println(pow(new int[]{1,2,3}));
    }

    public static List<List<Integer>> pow(int[] num) {
        List<List<Integer>> power = new ArrayList<>();

        for (int i = 0; i < 1 << num.length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < num.length; j++) {
                boolean isSet = ((i >> j) & 1) == 1;
                if (isSet) list.add(num[j]);
            }

            power.add(list);
        }
        return power;
    }
}
