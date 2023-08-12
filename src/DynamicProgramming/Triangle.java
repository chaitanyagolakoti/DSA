package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal(int i, int j, List<List<Integer>> triangle, int n, int dp[][]) {
        if(i==n-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = triangle.get(i).get(j) + minimumTotal(i+1,j,triangle,n,dp);
        int dia = triangle.get(i).get(j) + minimumTotal(i+1,j+1,triangle,n,dp);
        return dp[i][j] = Math.min(down, dia);
    }
    static int tabulation(List<List<Integer>> triangle, int n, int dp[][]){
        for(int m=0;m<n;m++){
            dp[n-1][m] = triangle.get(n-1).get(m);
        }
        for (int k = n-2; k >=0 ; k--) {
            for (int col = k; col >=0 ; col--) {
                int d = triangle.get(k).get(col) + dp[k+1][col];
                int dg = triangle.get(k).get(col) + dp[k+1][col+1];
                dp[k][col] = Math.min(d,dg);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(2));
        matrix.add(Arrays.asList(3, 4));
        matrix.add(Arrays.asList(6, 5, 7));
        matrix.add(Arrays.asList(4, 1, 8, 3));
        int n = matrix.size();
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(minimumTotal(0,0,matrix,n,dp));
    }
}
