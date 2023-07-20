package Recursion;

import java.util.ArrayList;
import java.util.List;
public class CombinationSum3 {
    private static void findCombinations(int ind, int k, int[] arr, int target, List <List< Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0 && ds.size()==k) {
                ans.add(new ArrayList< >(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind+1, k,arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, k,arr, target, ans, ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target,int k) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0,k, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        return combinationSum(arr,n,k);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(combinationSum(arr,7, 2));
    }
}
