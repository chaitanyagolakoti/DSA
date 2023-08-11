package DynamicProgramming;

public class uniquePaths {
    static int total(int m, int n){
        if(m==1 || n==1){
            return 1;
        }
        int bottom = total(m-1, n);
        int right = total(m, n-1);
        return bottom+right;
    }
    static int totalDP(int m, int n, int dp[][]){
        if(m==1 || n==1){
            return 1;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        return dp[m][n] = totalDP(m-1, n,dp)+totalDP(m, n-1,dp);
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(totalDP(3,4,dp));
    }
}
