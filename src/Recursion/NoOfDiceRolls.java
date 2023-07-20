package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NoOfDiceRolls {
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
    public static int numRollsToTarget(int n, int k, int target) {
        int arr[] = new int[k+1];
        for (int i = 1; i <= k; i++) {
            arr[i] = i;
        }
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0,n, arr, target, ans, new ArrayList < > ());
        System.out.println(ans);
        return ans.size();
    }
    static int count = 0;
    static void dice(String p, int n,int target){
        if(target==0){
            if(p.length() == n) {
//                System.out.println(p);
                count++;
            }
            return;
        }
        for (int i = 1; i <=6 && i<=target ; i++) {
            dice(p+i,n,target-i);
        }
    }
    public static void main(String[] args) {
//        System.out.println(numRollsToTarget(2,6,7));
        dice("",30,500);
        System.out.println(count);
    }
}
