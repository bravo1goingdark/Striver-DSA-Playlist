package Stack_Queue;

public class PartIV {
    public static void main(String[] args) {
        System.out.println(inFixToPostFix("A^B^C"));
    }


    public static String inFixToPostFix(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) sb.append(ch);
            else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        (getPriority(stack.peek()) > getPriority(ch) ||
                                (getPriority(stack.peek()) == getPriority(ch)
                                        && ch != '^')))
                {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.toString();
    }


    private static int getPriority(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '^') return 3;
        return -1;
    }

}
