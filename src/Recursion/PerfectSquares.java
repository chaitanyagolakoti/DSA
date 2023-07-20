package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    private static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    public static int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        int[] result = new int[squares.size()];
        for (int i = 0; i < squares.size(); i++) {
            result[i] = squares.get(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,result,n,ans,new ArrayList<>());
        int min = Integer.MAX_VALUE;
        for(List<Integer> i : ans){
            if(i.size()<min){
                min = i.size();
            }
        }
//        System.out.println(ans);
        return min;
    }
    public static void main(String[] args) {
        System.out.println(numSquares(227));
    }
}
