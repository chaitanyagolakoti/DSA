package Recursion;
import java.util.*;
public class CombinatioSum {
    private static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind+1, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int target = sc.nextInt();
        int arr[] = {1,1,1};
        int arr2[] = {10,7,9,5,2};
        List<List<Integer>> ans = combinationSum(arr,2);
        System.out.println(ans.size());
    }
}
