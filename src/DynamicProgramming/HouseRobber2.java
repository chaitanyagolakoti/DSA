package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
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
        int arr[] = {1, 2, 3, 1};
        int a[] = Arrays.copyOfRange(arr,1,arr.length);
        int dp1[] = new int[a.length];
        Arrays.fill(dp1,-1);
        int c = functionDp(a.length-1,a,dp1);


        int b[] = Arrays.copyOfRange(arr,0,arr.length-1);
        int dp2[] = new int[b.length];
        Arrays.fill(dp2,-1);
        int d = functionDp(b.length-1,b,dp2);
        System.out.println(c+" "+d);
        System.out.println(Math.max(c,d));
    }
}
