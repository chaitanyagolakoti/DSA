package DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    public static int ninjaTraining(int day, int last, int points[][]) {
        if(day==0){
            int maxP = 0;
            for (int i = 0; i < 3; i++) {
                if(i!=last){
                    maxP = Math.max(maxP, points[day][i]);
                }
            }
            return maxP;
        }
        int maxP = 0;
        for (int i = 0; i < 3; i++) {
            if(i!=last){
                int point = points[day][i]+ninjaTraining(day-1, i, points);
                maxP = Math.max(maxP, point);
            }
        }
        return maxP;
    }
    public static int NinjaDp(int day, int last, int points[][], int dp[][]){
        if(day==0){
            int maxP = 0;
            for (int i = 0; i < 3; i++) {
                if(i!=last){
                    maxP = Math.max(maxP, points[day][i]);
                }
            }
            return maxP;
        }
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        int maxP = 0;
        for (int i = 0; i < 3; i++) {
            if(i!=last){
                int point = points[day][i]+NinjaDp(day-1, i, points,dp);
                maxP = Math.max(maxP, point);
            }
        }
        return dp[day][last] = maxP;
    }
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        Arrays.fill(dp,-1);
        return NinjaDp(n-1,3, points, dp);
//        return ninjaTraining(n-1,3, points);

    }
    public static void main(String[] args) {

    }
}
