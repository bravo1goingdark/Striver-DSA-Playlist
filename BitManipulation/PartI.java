package BitManipulation;

public class PartI {
    public static void main(String[] args) {
        System.out.println(toDecimal(toBinary(18)));
    }


    public static String toBinary(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num = num / 2;
        }

        return sb.reverse().toString();
    }
    public static int toDecimal(String binary){
        int res = 0;
        int power = 1;

        for (int i = binary.length() - 1; i >= 0; i--) {
            char ch = binary.charAt(i);

            if (ch != '0'){
                res += power;
            }
            power = power * 2;
        }
        return res;
    }
}
