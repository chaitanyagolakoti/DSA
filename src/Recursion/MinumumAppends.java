package Recursion;

import java.util.Scanner;

public class MinumumAppends {
    static boolean palin_string(String str){
        if(str.length()==1){
            return true;
        }
        String reverseStr = "";
        int strLength = str.length();
        for (int i = (strLength - 1); i >=0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }
        if (str.equals(reverseStr)) {
            return true;
        }
        return false;
    }
    static int palin(String str){
        if (palin_string(str)) {
            return 0;
        }
        str = str.substring(1);
        return 1+palin(str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(palin(str));
    }
}
