package Recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = generatePermutations(str);
//        for (String permutation : permutations) {
//            System.out.println(permutation);
//        }
        System.out.println(permutations);
    }

    public static List<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper("", str, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String proc, String unproc, List<String> permutations) {
        if (unproc.isEmpty()) {
            permutations.add(proc);
        } else {
            char ch = unproc.charAt(0);
            for (int i = 0; i <= proc.length(); i++) {
                String f = proc.substring(0,i);
                String s = proc.substring(i,proc.length());
                generatePermutationsHelper(f+ch+s,unproc.substring(1),permutations);
            }
        }
    }
}
