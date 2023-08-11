package DynamicProgramming;

import java.util.Arrays;

public class FrogJumpsWithK {
    static int frogRec(int ind, int k, int arr[]){
        if(ind==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if(ind-i>=0){
                int jumps = frogRec(ind-i,k,arr) + Math.abs(arr[ind]-arr[ind-i]);
                min = Math.min(min,jumps);
            }
        }
        return min;
    }
    static int frogRecMemo(int ind, int k, int arr[], int dp[]){
        if(ind==0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if(ind-i>=0){
                int jumps = frogRecMemo(ind-i,k,arr,dp) + Math.abs(arr[ind]-arr[ind-i]);
                min = Math.min(min,jumps);
            }
        }
        return dp[ind] = min;
    }
    public static void main(String[] args) {
        int arr[] = {10 ,40 ,50 ,20 ,60};
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(frogRecMemo(arr.length-1, 3, arr,dp));
    }
}
