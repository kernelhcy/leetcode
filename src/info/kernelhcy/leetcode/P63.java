package info.kernelhcy.leetcode;

public class P63
{
    public static void main(String[] args)
    {
        int[][] grid = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 1, 0},
                new int[] {0, 0, 0},
        };
        System.out.println(new Solution().uniquePathsWithObstacles(grid));

        grid = new int[][] {
                new int[] {0},
        };
        System.out.println(new Solution().uniquePathsWithObstacles(grid));

        grid = new int[][] {
                new int[] {1},
        };
        System.out.println(new Solution().uniquePathsWithObstacles(grid));

        grid = new int[][] {
                new int[] {0, 1},
        };
        System.out.println(new Solution().uniquePathsWithObstacles(grid));

        grid = new int[][] {
                new int[] {1, 0},
        };
        System.out.println(new Solution().uniquePathsWithObstacles(grid));

        grid = new int[][] {
                new int[] {0, 0, 0, 0},
                new int[] {0, 0, 0, 1},
                new int[] {0, 0, 1, 0},
                new int[] {0, 1, 0, 0},
        };
        System.out.println(new Solution().uniquePathsWithObstacles(grid));
    }

    public static class Solution
    {
        public int uniquePathsWithObstacles(int[][] obstacleGrid)
        {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] matrix = new int[m][n];
            matrix[m - 1][n - 1] = 1 - obstacleGrid[m - 1][n - 1];
            for (int i = m - 2; i >= 0; i--) {
                matrix[i][n - 1] = obstacleGrid[i][n - 1] == 1 ? 0 : matrix[i + 1][n - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                matrix[m - 1][i] = obstacleGrid[m - 1][i] == 1 ? 0 : matrix[m - 1][i + 1];
            }

            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    matrix[i][j] = (obstacleGrid[i][j] == 1 ? 0 : matrix[i + 1][j])
                            + (obstacleGrid[i][j] == 1 ? 0 : matrix[i][j + 1]);
                    if (obstacleGrid[i][j] == 1) {
                        matrix[i][j] = 0;
                    }
                }
            }
            return matrix[0][0];
        }
    }
}
