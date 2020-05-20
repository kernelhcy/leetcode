package info.kernelhcy.leetcode;

public class P64
{
    public static void main(String[] args)
    {
        int[][] grid = new int[][] {
                new int[] {1, 3, 1},
                new int[] {1, 5, 1},
                new int[] {4, 2, 1},
        };
        System.out.println(new Solution().minPathSum(grid));
    }

    public static class Solution
    {
        public int minPathSum(int[][] grid)
        {
            int m = grid.length;
            int n = grid[0].length;

            int[][] matrix = new int[m][n];
            matrix[m - 1][n - 1] = grid[m - 1][n - 1];
            for (int i = m - 2; i >= 0; --i) matrix[i][n - 1] = matrix[i + 1][n - 1] + grid[i][n - 1];
            for (int i = n - 2; i >= 0; --i) matrix[m - 1][i] = matrix[m - 1][i + 1] + grid[m - 1][i];

            for (int i = m - 2; i >= 0; --i) {
                for (int j = n - 2; j >= 0; --j) {
                    matrix[i][j] = Math.min(matrix[i + 1][j], matrix[i][j + 1]) + grid[i][j];
                }
            }
            return matrix[0][0];
        }
    }
}
