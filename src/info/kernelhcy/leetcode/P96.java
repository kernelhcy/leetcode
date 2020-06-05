package info.kernelhcy.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class P96
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numTrees(3));
        System.out.println(new Solution().numTrees(4));
        System.out.println(new Solution().numTrees(5));
        System.out.println(new Solution().numTrees(17));
    }

    public static class Solution
    {
        public int numTrees(int n)
        {
            int[][] map = new int[n + 1][n + 1];
            for (int[] m : map) Arrays.fill(m, -1);
            return numTrees(1, n, map);
        }

        public int numTrees(int start, int end, int[][] map)
        {
            if (start > end) return 1;

            if (map[start][end] > 0) return map[start][end];

            int cnt = 0;
            for (int i = start; i <= end; ++i) {
                int l = numTrees(start, i - 1, map);
                int r = numTrees(i + 1, end, map);
                cnt += (l * r);
            }

            map[start][end] = cnt;
            return cnt;
        }
    }
}
