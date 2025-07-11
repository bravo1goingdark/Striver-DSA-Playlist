package BitManipulation;

public class PartVIII {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;     // Common set bits
            a = a ^ b;             // Sum without carry
            b = carry << 1;        // Carry shifted left
        }
        return a;
    }
}
