package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P174
{
    public static void main(String[] args)
    {
        int[][] dungeon = new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5},
        };

        System.out.println(new Solution().calculateMinimumHP(dungeon));

        dungeon = new int[][]{
                {-2,-5,3},
                {-5,-10,1},
                {10,30,-5},
        };

        System.out.println(new Solution().calculateMinimumHP(dungeon));

        dungeon = new int[][]{
                {100},
        };

        System.out.println(new Solution().calculateMinimumHP(dungeon));
    }

    private static class Solution
    {

        public int calculateMinimumHP(int[][] dungeon)
        {
            int[][] dp = new int[dungeon.length][dungeon[0].length];

            dp[dungeon.length - 1][dungeon[0].length - 1] = dungeon[dungeon.length - 1][dungeon[0].length - 1];
            for (int j = dungeon[0].length - 1; j >= 0; --j) {
                for (int i = dungeon.length - 1; i >= 0; --i) {
                    int vj = Integer.MIN_VALUE, vi = Integer.MIN_VALUE;
                    if (j + 1 < dungeon[0].length) {
                        vj = Math.min(dungeon[i][j], dp[i][j + 1] + dungeon[i][j]);
                    }

                    if (i + 1 < dungeon.length) {
                        vi = Math.min(dungeon[i][j], dp[i + 1][j] + dungeon[i][j]);
                    }

                    if (vi == Integer.MIN_VALUE && vj == Integer.MIN_VALUE) {
                        continue;
                    }

                    dp[i][j] = Math.max(vi, vj);
                }
            }

            int re = -dp[0][0] + 1;
            if (re <= 0) {
                return 1;
            } else {
                return re;
            }
        }

        public int calculateMinimumHP2(int[][] dungeon)
        {
            calculateMinimumHP(dungeon, 0, 0, new LinkedList<>(), 0);
            int re = -max + 1;
            if (re <= 0) {
                return 1;
            } else {
                return re;
            }
        }

        private void calculateMinimumHP(int[][] dungeon, int x, int y, List<Integer> path, int curr)
        {
            if (x == dungeon.length - 1 && y == dungeon[x].length - 1) {
                int min = curr + dungeon[x][y];
                for (int i = 0; i < path.size(); ++i) min = Math.min(min, path.get(i));
                this.max = Math.max(this.max, min);
                return;
            }

            if (x < dungeon.length - 1) {
                List<Integer> p = new LinkedList<>(path);
                p.add(curr + dungeon[x][y]);
                calculateMinimumHP(dungeon, x + 1, y, p, curr + dungeon[x][y]);
            }

            if (y < dungeon[x].length - 1) {
                List<Integer> p = new LinkedList<>(path);
                p.add(curr + dungeon[x][y]);
                calculateMinimumHP(dungeon, x, y + 1, p, curr + dungeon[x][y]);
            }
        }

        private int max = Integer.MIN_VALUE;
    }
}
