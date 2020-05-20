package info.kernelhcy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P62
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(7, 3));
        System.out.println(new Solution().uniquePaths(23, 12));
    }

    public static class Solution
    {

        public int uniquePaths(int m, int n)
        {
            Queue<Pair> queue = new LinkedList<>();
            int[][] steps = new int[m][n];
            boolean[][] map = new boolean[m][n];
            for (int[] step : steps) Arrays.fill(step, -1);
            for (boolean[] mm : map) Arrays.fill(mm, true);

            steps[m - 1][n - 1] = 1;
            queue.offer(new Pair(m- 1, n - 1));
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                int step = 0;
                if (p.x + 1 < m) {
                    step += steps[p.x + 1][p.y];
                }
                if (p.y + 1 < n) {
                    step += steps[p.x][p.y + 1];
                }

                if (steps[p.x][p.y] < 0) {
                    steps[p.x][p.y] = step;
                }

                if (p.x - 1 >= 0 && map[p.x - 1][p.y]) {
                    queue.offer(new Pair(p.x -1, p.y));
                    map[p.x - 1][p.y] = false;
                }

                if (p.y - 1 >= 0 && map[p.x][p.y - 1]) {
                    queue.offer(new Pair(p.x, p.y - 1));
                    map[p.x][p.y - 1] = false;
                }
            }

            return steps[0][0];
        }

        private static class Pair
        {
            public Pair(int x, int y)
            {
                this.x = x;
                this.y = y;
            }

            int x, y;
        }

        // Time Limit Exceeded
        public int uniquePaths2(int m, int n)
        {
            if (m <= 0 || n <= 0) return 0;
            tryPath(1, 1, m, n);
            return cnt;
        }

        private void tryPath(int x, int y, int m, int n)
        {
            if (x == m && y == n) {
                ++cnt;
                return;
            }

            if (x < m) {
                tryPath(x + 1, y, m, n);
            }

            if (y < n) {
                tryPath(x, y + 1, m, n);
            }
        }

        private int cnt = 0;
    }
}
