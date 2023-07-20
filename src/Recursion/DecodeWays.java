package Recursion;
//
//public class DecodeWays {
//    static int countDecodings(String s, int index) {
//        if (index == s.length()) {
//            return 1; // Base case: a valid decoding is found
//        }
//        if (s.charAt(index) == '0' && s.charAt(index+1)!=0 && index<s.length()) {
//            return 1;
//        }
//        int count = 0;
//        // Consider a single digit as a valid decoding
//        int singleDigit = s.charAt(index) - '0';
//        if (singleDigit > 0 && singleDigit <= 9) {
//            count += countDecodings(s, index + 1);
//        }
//        // Consider two digits as a valid decoding if the number is between 10 and 26 (inclusive)
//        if (index < s.length() - 1) {
//            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
//            if (twoDigits >= 10 && twoDigits <= 26) {
//                count += countDecodings(s, index + 2);
//            }
//        }
//        return count;
//    }
//
//    static int numDecodings(String s) {
//        if (s == null || s.isEmpty()) {
//            return 0;
//        }
//
//        return countDecodings(s, 0);
//    }
//
//    public static void main(String[] args) {
//        int ways = numDecodings("111111111111111111111111111111111111111111111");
//        System.out.println("Total number of ways to decode the string: " + ways);
//    }
//}
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    static Map<Integer, Integer> memo;
    static int countDecodings(String s, int index) {
        if (index == s.length()) {
            return 1; // Base case: a valid decoding is found
        }
        // If the result is already memoized, return it directly
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int count = 0;
        // Consider a single digit as a valid decoding
        int singleDigit = s.charAt(index) - '0';
        if (singleDigit > 0 && singleDigit <= 9) {
            count += countDecodings(s, index + 1);
        }
        // Consider two digits as a valid decoding if the number is between 10 and 26 (inclusive)
        if (index < s.length() - 1) {
            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                count += countDecodings(s, index + 2);
            }
        }
        // Memoize the result before returning
        memo.put(index, count);
        return count;
    }
    static int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        memo = new HashMap<>();
        return countDecodings(s, 0);
    }
    public static void main(String[] args) {
        int ways = numDecodings("209");
        System.out.println("Total number of ways to decode the string: " + ways);
    }
}
