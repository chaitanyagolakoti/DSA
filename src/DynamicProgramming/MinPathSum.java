package DynamicProgramming;

import java.util.Arrays;

public class MinPathSum {
    static int sumRec(int m,int n,int grid[][]){
        if(m==0 && n==0) {
            return grid[m][n];
        }
        if(m<0||n<0) {
            return (int)1e9;
        }
        int up = grid[m][n]+sumRec(m-1,n,grid);
        int down = grid[m][n]+sumRec(m,n-1,grid);
        return Math.min(up,down);
    }
    static int SumDp(int m,int n,int dp[][],int grid[][]){
        if(m==0 && n==0) {
            return grid[m][n];
        }
        if(m<0||n<0) {
            return (int)1e9;
        }
        if(dp[m][n]!=-1) {
            return dp[m][n];
        }
        int up = grid[m][n]+SumDp(m-1,n,dp,grid);
        int down = grid[m][n]+SumDp(m,n-1,dp,grid);
        return dp[m][n] = Math.min(up,down);
    }
    public static void main(String[] args) {
        int mat[][] = {{1,3,1},{1,5,1},{4,2,1}};
        int m = mat.length;
        int n = mat[0].length;
        int dp[][] = new int[m][n];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        System.out.println(SumDp(m-1,n-1,dp, mat));
        System.out.println(sumRec(m-1,n-1, mat));
    }
}
