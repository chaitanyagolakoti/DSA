package Recursion;

import java.util.Stack;
public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(Character.toString(s.charAt(i)));
            } else {
                StringBuilder substr = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    substr.insert(0, stack.pop());
                }
                stack.pop(); // Remove the '[' character.
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }
                int repeat = Integer.parseInt(k.toString());
                StringBuilder repeatedString = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    repeatedString.append(substr);
                }
                stack.push(repeatedString.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }
        return result.toString();
    }
    static void decodeRec(String str, Stack<String> stack) {
        if (str.length() == 0) {
            return;
        }
        char ch = str.charAt(0);
        if (ch != ']') {
            stack.push(Character.toString(ch));
            decodeRec(str.substring(1), stack);
        } else {
            StringBuilder substr = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().equals("[")) {
                substr.insert(0, stack.pop());
            }
            stack.pop(); // Remove the '[' character.

            StringBuilder k = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                k.insert(0, stack.pop());
            }

            int repeat = Integer.parseInt(k.toString());

            StringBuilder repeatedString = new StringBuilder();
            for (int j = 0; j < repeat; j++) {
                repeatedString.append(substr);
            }
            stack.push(repeatedString.toString());

            decodeRec(str.substring(1), stack);
        }
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]10[bc]"));
        Stack<String> stack = new Stack<>();
        decodeRec("3[a]10[bc]",stack);
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }
        System.out.println(result.toString());
    }
}
