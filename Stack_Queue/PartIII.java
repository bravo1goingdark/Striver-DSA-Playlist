// https://leetcode.com/problems/valid-parentheses/

package Stack_Queue;

import java.util.Stack;

public class PartIII {

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {

                if (stack.isEmpty()) return false;
                char top = stack.peek();

                if (ch == ')' && top == '(') {
                    stack.pop();
                } else if (ch == '}' && top == '{') {
                    stack.pop();
                } else if (ch == ']' && top == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
