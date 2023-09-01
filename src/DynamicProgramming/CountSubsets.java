package DynamicProgramming;

import java.util.Arrays;

public class CountSubsets {
    static int countSumK(int ind, int target, int arr[]){
        if(ind==arr.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        if(target==0){
            return 1;
        }
        int pick = (arr[ind]<=target)?countSumK(ind+1, target-arr[ind], arr):0;
        int notpick = countSumK(ind+1, target, arr);
        return pick + notpick;
    }
    static int countSumKMemo(int ind, int target, int arr[], int dp[][]){
        if(ind==arr.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        if(target==0){
            return 1;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int pick = (arr[ind]<=target)?countSumKMemo(ind+1, target-arr[ind], arr,dp):0;
        int notpick = countSumKMemo(ind+1, target, arr,dp);
        return dp[ind][target] = pick + notpick;
    }
    static int countTablu(int []arr,int n, int k){
        int dp[][] = new int[n][k+1];
        for(int i=0; i<arr.length; i++){
            dp[i][0] = 1;
        }
        if(arr[0]<=k) {
            dp[0][arr[0]] = 1;
        }
        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(arr[ind]<=target){
                    taken = dp[ind-1][target-arr[ind]];
                }
                dp[ind][target]= notTaken + taken;
            }
        }
        return dp[n-1][k];
    }
    public static void main(String[] args) {
        int arr[] = {5 ,9, 10, 8, 9, 8, 1, 2, 5, 6, 1, 7 };
        int target = 10;
        int dp[][] = new int[arr.length][target+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(countSumKMemo(0,target, arr, dp));
        System.out.println(countTablu(arr,arr.length,target));
    }
}
