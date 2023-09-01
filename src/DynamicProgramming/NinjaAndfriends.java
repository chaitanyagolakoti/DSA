package DynamicProgramming;

public class NinjaAndfriends {
    static int maxSum(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp){
        if(j1<0 || j2<0 || j1>=c || j2>= c){
            return (int) -1e9;
        }
        if(i==r-1){
            if(j1==j2){
                return grid[i][j1];
            }
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        int max = Integer.MIN_VALUE;
        for (int dj = -1; dj <=1 ; dj++) {
            for (int dj2 = -1; dj2 <= 1 ; dj2++) {
                int value = 0;
                if(j1==j2){
                    value = grid[i][j1];
                }
                else{
                    value = grid[i][j1]+grid[i][j2];
                }
                value += maxSum(i+1,j1+dj,j2+dj2,r,c,grid,dp);
                max = Math.max(value, max);
            }
        }
        return dp[i][j1][j2] = max;
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int dp[][][] = new int[r][c][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < c; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return maxSum(0, 0, c-1, r, c, grid,dp);
    }
    public static void main(String[] args) {
        int mat[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maximumChocolates(mat.length,mat[0].length,mat));
    }
}
