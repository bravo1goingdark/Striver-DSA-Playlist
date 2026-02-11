package Stack_Queue;

public class PartVI {
    public static void main(String[] args) {

        System.out.println(postfixToPrefix("ab+cde+**"));
        System.out.println(postfixToInFix("ab+c+"));
        System.out.println(prefixToInfix("+A*BC"));
        System.out.println(prefixToPostfix("/-AB*+DEF"));
    }

    public static String prefixToPostfix(String input) {
        Stack<String> stack = new Stack<>();

        for (int i = input.length() - 1; i >= 0; i--) {
            char ch = input.charAt(i);
            if (Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String expr = op1 + op2 + ch;

                stack.push(expr);
            }
        }
        return stack.pop();

    }

    public static String prefixToInfix(String input) {
        Stack<String> stack = new Stack<>();

        for (int i = input.length() - 1; i >= 0; i--) {
            char ch = input.charAt(i);
            if (Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String expr = "(" + op1 + ch + op2 + ")";

                stack.push(expr);
            }
        }
        return stack.pop();
    }


    public static String postfixToInFix(String input) {
        Stack<String> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            }
        }
        return stack.pop();
    }

    public static String postfixToPrefix(String input) {
        Stack<String> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String expr = ch + op1 + op2;
                stack.push(expr);
            }
        }
        return stack.pop();
    }
}
