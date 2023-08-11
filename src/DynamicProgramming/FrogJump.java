package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    static int frogJumpRec(int ind, int arr[]) {
        if (ind == 0) {
            return 0;
        }
        int oneStep = frogJumpRec(ind - 1, arr) + Math.abs(arr[ind] - arr[ind - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (ind > 1) {
            twoStep = frogJumpRec(ind - 2, arr) + Math.abs(arr[ind] - arr[ind - 2]) ;
        }
        return Math.min(oneStep, twoStep);
    }
    static int frogJumDP(int n,int arr[], int dp[]){
        dp[0] = 0;
        for (int i = 1; i < n ; i++) {
            int oneStep = dp[i-1]+Math.abs(arr[i] - arr[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if(i>1){
                twoStep = dp[i-2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[n-1];
    }
    static int frogJumpdp(int ind, int arr[], int dp[]){
        if (ind <= 0) {
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int oneStep = frogJumpdp(ind - 1, arr, dp) + Math.abs(arr[ind] - arr[ind - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (ind > 1) {
            twoStep = frogJumpdp(ind - 2, arr, dp) + Math.abs(arr[ind] - arr[ind - 2]) ;
        }
        dp[ind] = Math.min(oneStep, twoStep);
        return dp[ind];
    }
    public static void main(String[] args) {
        int arr[] = {7,4,4,2,6,6,3,4};
        System.out.println(frogJumpRec(arr.length-1, arr));
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
//        System.out.println(frogJumpdp(arr.length-1, arr, dp));
        System.out.println(frogJumDP(arr.length,arr,dp));
    }
}
