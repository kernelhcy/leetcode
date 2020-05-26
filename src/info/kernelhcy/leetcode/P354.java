package info.kernelhcy.leetcode;

import java.util.Arrays;

public class P354
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                new int[]{5, 4},
                new int[]{6, 4},
                new int[]{6, 7},
                new int[]{2, 3},
        }));
    }

    public static class Solution
    {
        public int maxEnvelopes(int[][] envelopes)
        {
            if (envelopes.length <= 0) return 0;

            for (int i = 0; i < envelopes.length; ++i) {
                for (int j = i + 1; j < envelopes.length; ++j) {
                    if ((envelopes[j][0] == envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                            || envelopes[j][0] < envelopes[i][0]) {
                        int tmp = envelopes[i][0];
                        envelopes[i][0] = envelopes[j][0];
                        envelopes[j][0] = tmp;

                        tmp = envelopes[i][1];
                        envelopes[i][1] = envelopes[j][1];
                        envelopes[j][1] = tmp;
                    }
                }
            }

            int[] dp = new int[envelopes.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < envelopes.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 0;
            for (int n : dp) max = Math.max(max, n);
            return max;
        }
    }
}
