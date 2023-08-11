package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class Maximumsumofnonadjacentelements {
    public static int rob(ArrayList<Integer> nums) {
        if (nums.size() == 0) return 0;
        if (nums.size() == 1) return nums.get(0);

        int[] purse = new int[nums.size()];

        purse[0] = nums.get(0);
        purse[1] = Math.max(purse[0], nums.get(1));

        for (int i = 2; i < purse.length; i++) {
            purse[i] = Math.max(purse[i - 1], nums.get(i) + purse[i - 2]);
        }
        return purse[nums.size() - 1];
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        return rob(nums);
    }
    public static int functionRec(int ind, int arr[]){
        if(ind==0){
            return arr[ind];
        }
        if(ind<0){
            return 0;
        }
        int pick = arr[ind] + functionRec(ind-2, arr);
        int notpick = 0 + functionRec(ind-1,arr);
        return Math.max(pick, notpick);
    }
    // This question is itself an house robber question
    public static int functionDp(int ind, int arr[], int dp[]){
        if(ind==0){
            return arr[ind];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick = arr[ind] + functionDp(ind-2, arr,dp);
        int notpick = 0 + functionDp(ind-1,arr,dp);
        return dp[ind] = Math.max(pick, notpick);
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 1};
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(functionDp(arr.length-1, arr, dp));
    }
}
