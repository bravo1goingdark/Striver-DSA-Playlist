package Recursion;

public class PartII {
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(rev("ashutosh","",7));
        System.out.println(rev("ashutosh"));
        System.out.println(digitSum(12345));
    }

    public static int sum(int n){
        if (n == 1) return 1;

        return n + sum(n - 1);
    }
    public static int sum(int n , int curr){
        if (n <= 0) return curr;
        return sum(n - 1 , curr + n);
    }

    public static String rev(String org , String r , int index){
        if (index < 0) return r;
        char ch = org.charAt(index);
        return rev(org,r += ch ,index - 1);
    }
    public static String rev(String org){
        if (org.isEmpty()) return "";

        return org.charAt(org.length() - 1) + rev(org.substring(0,org.length() - 1));
    }
    public static int digitSum(int num){
        if (num == 0) return 0;

        return num % 10 + digitSum(num / 10);
    }

}
