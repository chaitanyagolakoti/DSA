package DynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static int minimumTotal(int i, int j, int[][] triangle, int n, int dp[][]) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (i == n - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = triangle[i][j] + minimumTotal(i + 1, j, triangle, n, dp);
        int diaR = (j + 1 < n) ? triangle[i][j] + minimumTotal(i + 1, j + 1, triangle, n, dp) : Integer.MAX_VALUE;
        int diaL = (j - 1 >= 0) ? triangle[i][j] + minimumTotal(i + 1, j - 1, triangle, n, dp) : Integer.MAX_VALUE;
        return dp[i][j] = Math.min(down, Math.min(diaL, diaR));
    }

    public static void main(String[] args) {
//        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int[][] matrix = {{-19, 57}, {-40,-5}};
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, minimumTotal(0, j, matrix, n, dp));
        }
        System.out.println(ans);
    }
}
