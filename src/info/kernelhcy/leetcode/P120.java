package info.kernelhcy.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P120
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public int minimumTotal(List<List<Integer>> triangle)
        {
            if (triangle.size() <= 0) return 0;

//            return recurse(triangle, 0, 0);

            int[][] dp = new int[triangle.size()][triangle.size()];
            for (int i = 0; i < triangle.size(); ++i) {
                dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
            }

            for (int i = triangle.size() - 2; i >= 0; --i) {
                for (int j = i; j >= 0; --j) {
                    int n = triangle.get(i).get(j);
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + n;
                }
            }
            return dp[0][0];
        }


        private Map<String, Integer> memo = new HashMap<>();
        private int recurse(List<List<Integer>> triangle, int i, int j)
        {
            if (i >= triangle.size()) return 0;

            String key = "" + i + "|" + j;
            if (memo.containsKey(key)) return memo.get(key);

            int n = triangle.get(i).get(j);
            int sum = Math.min(recurse(triangle, i + 1, j), recurse(triangle, i + 1, j + 1)) + n;

            memo.put(key, sum);
            return sum;
        }


    }
}
