package info.kernelhcy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P115
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));
        System.out.println(new Solution().numDistinct("babgbag", "bag"));
    }

    public static class Solution
    {
        public int numDistinct(String s, String t)
        {
            return numDistinct(s, 0, t, 0);
        }

        private Map<String, Integer> memo = new HashMap<>();
        private int numDistinct(String s, int sidx, String t, int tidx)
        {
            if (tidx >= t.length()) {
                return 1;
            }
            if (sidx >= s.length()) return 0;

            String key = "" + sidx + "|" + tidx;
            if (memo.containsKey(key)) return memo.get(key);

            int cnt = 0;
            if (s.charAt(sidx) == t.charAt(tidx)) {
                cnt = numDistinct(s, sidx + 1, t, tidx + 1) + numDistinct(s, sidx + 1, t, tidx);
            } else {
                cnt = numDistinct(s, sidx + 1, t, tidx);
            }

            memo.put(key, cnt);
            return cnt;
        }

        public int numDistinct2(String s, String t)
        {
            if (s.length() <= 0) return 0;
            if (t.length() <= 0) return 0;


            int[][] dp = new int[t.length() + 1][s.length() + 1];

            for (int i = 0; i <= s.length(); ++i) {
                dp[0][i] = 1;
            }

            for (int i = 1; i <= t.length(); ++i) {
                for (int j = 1; j <= s.length(); ++j) {
                    if (t.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[t.length()][s.length()];
        }
    }
}
