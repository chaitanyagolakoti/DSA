package StackandQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnigmaSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String pattern = scanner.nextLine();
        scanner.close();

        long uniqueNumber = findUniqueNumber(str, pattern);
        System.out.println(uniqueNumber);
    }

    private static long findUniqueNumber(String str, String pattern) {
        List<Integer> uniqueIndices = new ArrayList<>();
        int strLength = str.length();
        int patternLength = pattern.length();
        for (int i = 0; i <= strLength - patternLength; i++) {
            if (matchPattern(str, i, pattern)) {
                uniqueIndices.add(i + 1); // Adding 1 to convert 0-based index to 1-based index
            }
        }
        return constructUniqueNumber(uniqueIndices);
    }
    private static boolean matchPattern(String str, int startIndex, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == '#' && pattern.charAt(i) != str.charAt(startIndex + i)){
                return true;
            }
            if(pattern.charAt(i) == str.charAt(startIndex + i)){
                return true;
            }
            if (pattern.charAt(i) != '#' && pattern.charAt(i) != str.charAt(startIndex + i)) {
                return false;
            }
        }
        return true;
    }
    private static long constructUniqueNumber(List<Integer> uniqueIndices) {
        if (uniqueIndices.isEmpty()) {
            return 0;
        } else {
            long result = 0;
            for (int num : uniqueIndices) {
                result = result * 10 + num;
            }
            return result;
        }
    }
}
