package Stack_Queue;

public class PartVI {
    public static void main(String[] args) {
        System.out.println(postFixToPrefix("ab+cde+**"));
    }
    public static String postFixToPrefix(String input){
        Stack<String> stack = new Stack<>();

        for (char ch : input.toCharArray()){
            if (Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String expr = ch + op1 + op2;
                stack.push(expr);
            }
        }
        return stack.peek();
    }
}
