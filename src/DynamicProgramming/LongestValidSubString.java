package DynamicProgramming;

import java.util.Stack;

public class LongestValidSubString {
        public static int longestValidParentheses(String str) {
            Stack<Integer> stack = new Stack<>();
            int maxLen = 0;

            stack.push(-1); // Start with an initial index in the stack

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(') {
                    stack.push(i); // Push the index of '(' onto the stack
                } else { // ch == ')'
                    stack.pop(); // Pop the matching '(' index

                    if (!stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - stack.peek()); // Calculate the current valid length
                    } else {
                        stack.push(i); // No matching '(', so push the current index
                    }
                }
            }

            return maxLen;
        }
    public static int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "(()))";
        System.out.println(longestValidParentheses(str));
    }
}
