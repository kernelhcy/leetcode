package info.kernelhcy.leetcode;

public class P72
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minDistanceDp("ros", "ros"));
        System.out.println(new Solution().minDistanceDp("horse", "ros"));
        System.out.println(new Solution().minDistanceDp("", "a"));
    }

    public static class Solution
    {
        public int minDistance(String word1, String word2)
        {
            return minDistance(word1, 0, word2, 0);
        }

        private int minDistance(String w1, int idx1, String w2, int idx2)
        {
            if (idx1 >= w1.length() && idx2 >= w2.length()) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int cnt;

            if (idx2 < w2.length() && idx1 < w1.length() && w1.charAt(idx1) == w2.charAt(idx2)) {
                cnt = minDistance(w1, idx1 + 1, w2, idx2 + 1);
                if (cnt >= 0 && min > cnt) min = cnt;
            }

            if (idx2 < w2.length()) {
                // insert
                cnt = minDistance(w1, idx1, w2, idx2 + 1) + 1;
                if (cnt >= 0 && min > cnt) min = cnt;
            }

            if (idx1 < w1.length()) {
                // delete
                cnt = minDistance(w1, idx1 + 1, w2, idx2) + 1;
                if (cnt >= 0 && min > cnt) min = cnt;
            }

            if (idx2 < w2.length() && idx1 < w1.length() && w1.charAt(idx1) != w2.charAt(idx2)) {
                // replace
                cnt = minDistance(w1, idx1 + 1, w2, idx2 + 1) + 1;
                if (cnt >= 0 && min > cnt) min = cnt;
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }

        private int minDistanceDp(String word1, String word2)
        {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            dp[word1.length()][word2.length()] = 0;
            for (int i = 0; i < word1.length(); ++i) dp[i][word2.length()] = word1.length() - i;
            for (int i = 0; i < word2.length(); ++i) dp[word1.length()][i] = word2.length() - i;

//            Utils.printMatrix(dp);

            for (int i = word1.length() - 1; i >= 0; --i) {
                for (int j = word2.length() - 1; j >= 0; --j) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                    }
                }
            }

            return dp[0][0];
        }
    }
}
