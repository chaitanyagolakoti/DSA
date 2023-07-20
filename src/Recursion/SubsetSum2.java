package Recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    static void findCombinations(int ind, int[] arr, List < List < Integer >> ans, List < Integer > ds) {
//        if(ind==arr.length){
//            ans.add(new ArrayList<>(ds));
//            return;
//        }
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            findCombinations(i + 1, arr ,ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates) {
        Arrays.sort(candidates);
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, ans, new ArrayList < > ());
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3};
        List<List<Integer>> ans = combinationSum2(arr);
        System.out.println(ans);
    }
}
