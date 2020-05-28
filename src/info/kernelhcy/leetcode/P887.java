package info.kernelhcy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P887
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().superEggDrop(1, 2));
        System.out.println(new Solution().superEggDrop(2, 6));
        System.out.println(new Solution().superEggDrop(3, 14));
        System.out.println(new Solution().superEggDrop(4, 5000));
    }

    public static class Solution
    {
        public int superEggDrop(int k, int n)
        {
            int[][] dp = new int[k + 1][n + 1];
            for (int i = 0; i <= k; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);

            for (int i = 0; i <= n; ++i) {
                dp[0][i] = 0;
                dp[1][i] = i;
            }
            for (int i = 0; i <= k; ++i) dp[i][0] = 0;

            for (int i = 2; i <= k; ++i) {
                for (int j = 1; j <= n; ++j) {
                    for (int l = 1; l <= j; ++l) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][l - 1], dp[i][j - l]) + 1);
                    }
                }
            }
            return dp[k][n];
        }

        private Map<String, Integer> memo = new HashMap<>();

        public int superEggDrop2(int k, int n)
        {
            if (k == 1) return n;
            if (n == 0) return 0;

            String key = "" + k + "|" + n;
            if (memo.containsKey(key)) return memo.get(key);

            int re = Integer.MAX_VALUE;
            for (int i = 1; i <= n; ++i) {
                re = Math.min(re, Math.max(superEggDrop(k - 1, i - 1), superEggDrop(k, n - i)) + 1);
            }
            memo.put(key, re);
            return re;
        }

        private int superEggDrop(int k, int start, int end)
        {
            if (k == 1) return end - start;
            if (start == end) return 0;
            if (start + 1 == end) return 2;

            int mid = (start + end) / 2;
            // broken
            int c1 = superEggDrop(k - 1, start, mid) + 1;
            // no broken
            int c2 = superEggDrop(k, mid, end) + 1;
            return Math.min(c1, c2);
        }
    }
}
