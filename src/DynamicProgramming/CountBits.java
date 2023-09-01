package DynamicProgramming;

import java.util.Arrays;

public class CountBits {
    private static int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
    static int[] bits(int n){
        int [] ans = new int[n+1];
        int dp[] = new int[10001];
        Arrays.fill(dp,-1);
        dp[0]=0;dp[1]=1;dp[2]=1;
        for (int i = 0; i <=n ; i++) {
            for (int j = i; j >=0; j--) {
                if(dp[j]==-1){
                    dp[j] = countOnes(j);
                }
                else{
                    ans[j] = dp[j];
                }
            }
        }
        for (int i = 0; i <=n; i++) {
            ans[i] = dp[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bits(5)));
    }
}
