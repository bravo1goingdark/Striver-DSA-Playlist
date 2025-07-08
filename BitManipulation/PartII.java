package BitManipulation;

public class PartII {

    public static void main(String[] args) {
        swap(7, 8);
        System.out.println(toggleIthBit(34, 2));
        System.out.println(removeRightSetBit(40));
        System.out.println(isPowerOf2(32));
        System.out.println(countSetBit(54));
    }

    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    public static boolean isIthBitSet(int num, int i) {
        return ((num >> i) & 1) == 1;
    }

    public static int setIthBit(int num, int i) {
        return isIthBitSet(num, i) ? num : num | (1 << i);
    }

    public static int clearIthBit(int num, int i) {
        return num & (~(1 << i));
    }

    public static int toggleIthBit(int num, int i) {
        return num ^ (1 << i);
    }

    public static int removeRightSetBit(int num) {
        return num & (num - 1);
    }

    public static boolean isPowerOf2(int num) {
        return (num & (num - 1)) == 0;
    }
    public static int countSetBit(int num){
        int count = 0;

        while (num > 0){
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }

}
