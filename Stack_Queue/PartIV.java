package Stack_Queue;

public class PartIV {


    public static String inFixToPostFix(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        for (char ch : input.toCharArray()) {
            if (!isOperator(ch) && ch != '(' && ch != ')') sb.append(ch);
            else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        stack.peek() != '(' &&
                        getPriority(stack.peek()) <= getPriority(ch)
                ) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.toString();
    }


    private static int getPriority(char ch) {
        if (ch == '+' || ch == '-') return 3;
        if (ch == '*' || ch == '/') return 2;
        return 1;
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^';
    }
}
