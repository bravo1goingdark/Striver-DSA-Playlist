package BitManipulation;

public class PartIII {
    public static void main(String[] args) {
        System.out.println(minBitFlips(10,7));
    }


    public static int minBitFlips(int start , int end){
        return countSetBit(start ^ end);
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
