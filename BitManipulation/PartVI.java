package BitManipulation;

public class PartVI {
    public static void main(String[] args) {
        System.out.println(XorRange(3,5));

    }
    public static int findXOR(int L, int R) {
        int xor = 0;

        for (int i = L; i <= R; i++) {
            xor = xor ^ i;
        }
        return xor;
    }

    public static int XorRange(int L , int R){
        return findXOROpt(L - 1) ^ findXOROpt(R);
    }

    private static int findXOROpt(int num) {
        if (num % 4 == 0) return num;
        else if (num % 4 == 1) return 1;
        else if (num % 4 == 2) return num + 1;
        else return 0; // num % 4 == 3
    }

}
