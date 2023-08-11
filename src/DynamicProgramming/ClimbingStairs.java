package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs {
    // this is not optimised as it follows fibonacci series, it has exponential time complexity
    static int climbing(int n){
        if(n<=2){
            return n;
        }
        return climbing(n-1)+climbing(n-2);
    }
    public static int climbStairs(int n, int dp[]){
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(climbing(n));
        System.out.println(climbStairs(n, new int[n+1]));
    }
}
