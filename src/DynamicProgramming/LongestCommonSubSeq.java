package DynamicProgramming;

public class LongestCommonSubSeq {
    public static int LongestSub(String text1,String text2){

        int dp[][] = new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "abc";
        int distance = LongestSub(word1, word2);
        System.out.println("Levenshtein distance between \"" + word1 + "\" and \"" + word2 + "\" is: " + distance);
    }
}
