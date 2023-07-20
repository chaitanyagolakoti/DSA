package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhonePad {
    static void pad(String proc, String unp, List<String> ds, Map<Character, String> map) {
        if (unp.isEmpty()) {
            ds.add(proc);
            return;
        }
        char digit = unp.charAt(0);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            pad(proc + ch, unp.substring(1), ds, map);
        }
    }
    static List<String> allPat(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty())
            return ans;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        pad("", digits, ans, map);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(allPat("234"));
    }
}
