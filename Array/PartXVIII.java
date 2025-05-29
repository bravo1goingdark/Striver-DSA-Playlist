import java.util.ArrayList;
import java.util.List;

public class PartXVIII {
    public static void main(String[] args) {
        System.out.println(getRowsOpt(5));
        System.out.println(generate(6));
    }


    // given rows and column we have to return the value at that index in pascal triangle
    public static long nCr(int rows , int col){
        if (rows == col) return 1;
        long ans = 1;

        for (int i = 0; i < col ; i++) {
            ans = ans * (rows - i);
            ans = ans / (i + 1);
        }

        return ans;
    }

    // given rows we have to return all value in that row in pascal triangle

    public static List<Long> getRowsBrute(int row){
        // bruteforce
        // time comp - O(n*n)
        List<Long> ans = new ArrayList<>(row);

        for (int i = 1; i <= row ; i++) {
            ans.add(nCr(row - 1,i - 1));
        }
        return ans;
    }

    public static List<Integer> getRowsOpt(int row){
        // time comp - O(n)
        List<Integer> ans = new ArrayList<>(row);
        int res = 1;
        ans.add(res);

        for (int i = 1; i < row ; i++) {
            res = res * (row - i);
            res = res / i;
            ans.add(res);
        }
        return ans;
    }


    // given number of rows we have to generate full pascal triangle
    public static List<List<Integer>> generate(int numRows) {
        // time comp -> O(n * n)
        // space comp -> O(1)
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows ; i++) {
            List<Integer> temp = getRowsOpt(i);
            ans.add(temp);
        }
        return ans;
    }


}
