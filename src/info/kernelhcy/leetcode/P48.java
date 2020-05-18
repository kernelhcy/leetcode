package info.kernelhcy.leetcode;

public class P48
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        new Solution().rotate(matrix);

        matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16},
        };
        new Solution().rotate(matrix);
    }

    public static class Solution
    {
        /*
            0, 0 -> 0, 3
            0, 1 -> 1, 3
            0, 2 -> 2, 3
            0, 3 -> 3, 3
            i, j -> j, n - i

            1, 3 -> 3, 2
            2, 3 -> 3, 1
            3, 3 -> 3, 0
            i, j -> j, n - i

            3, 2 -> 2, 0
            3, 1 -> 1, 0
            3, 0 -> 0, 0
            i, j -> j, n - i

            2, 0 -> 0, 1
            1, 0 -> 0, 2
            0, 0 -> 0, 3
            i, j -> j, n - i

            1, 1 -> 1, 2
            1, 2 -> 2, 2
            i, j -> j, n - i
        */

        public void rotate(int[][] matrix)
        {
            if (matrix.length <= 1) return;
            /*
             1,  2,  3,  4
             5,  6,  7,  8
             9, 10, 11, 12
            13, 14, 15, 16

            13,  9, 5, 1
            14, 10, 6, 2
            15, 11, 7, 3
            16, 12, 8, 4
            */
            int n = matrix.length - 1;
            for (int i = 0; i < matrix.length / 2; ++i) {
                for (int j = i, cnt = 0; cnt < matrix.length - i * 2 - 1; ++j, ++cnt) {
                    int x = i;
                    int y = j;

                    int t1 = matrix[x][y], t2, tmp;
                    for (int k = 0; k < 4; ++k) {
                        t2 = matrix[y][n - x];
                        matrix[y][n - x] = t1;
                        t1 = t2;
                        tmp = y;
                        y = n - x;
                        x = tmp;
                    }
                }
            }

            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= n; ++j) {
                    System.out.print("" + matrix[i][j] + ",");
                }
                System.out.println();
            }
        }
    }
}
