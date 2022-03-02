package com.arsatapathy.dimanic;

public class LongestCommonSubstring {
    public static void main(String... args) {
        System.out.println(longestCommonSubstr("ashish_ranjan_satapathy", "ashish_satapathy", "ashish_ranjan_satapathy".length(), "ashish_satapathy".length()));
    }

    static int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                max = Math.max(dp[i][j],max);
            }
        }

        return max;
    }
}
