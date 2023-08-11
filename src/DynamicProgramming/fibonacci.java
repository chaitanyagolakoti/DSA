package DynamicProgramming;

public class fibonacci {
    static int fibo(int n, int dp[]){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = fibo(n-1, dp)+fibo(n-2,dp);
    }
    static int tabulation(int n, int dp[]){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    static int optimisation(int n){
        if(n==0){
            return 0;
        }
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <=n ; i++) {
            int curri = prev+prev2;
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
//        Arrays.fill(dp,-1);
//        System.out.println(fibo(n,dp));
//        System.out.println(tabulation(n,dp));
        System.out.println(optimisation(3));
    }

}
