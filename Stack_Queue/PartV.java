package Stack_Queue;


public class PartV {
    public static void main(String[] args) {
        System.out.println(infixToPrefix("a*(b+c)/d"));
    }

    public static String infixToPrefix(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : makePostFix(input).toCharArray()) {

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
                                (getPriority(stack.peek()) == getPriority(ch) && ch == '^'))) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }


    private static String makePostFix(String input) {
        char[] str = input.toCharArray();

        int s = 0;
        int e = str.length - 1;

        while (s < e) {
            char temp = str[s];
            str[s] = str[e];
            str[e] = temp;

            if (str[s] == ')') str[s] = '(';
            else if (str[s] == '(') str[s] = ')';

            if (str[e] == '(') str[e] = ')';
            else if (str[e] == ')') str[e] = '(';

            s++;
            e--;

            if (s == e) {
                if (str[s] == ')') str[s] = '(';
                else if (str[s] == '(') str[s] = ')';
            }
        }

        return String.valueOf(str);
    }

    public static int getPriority(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '^') return 3;
        return -1;
    }


}
