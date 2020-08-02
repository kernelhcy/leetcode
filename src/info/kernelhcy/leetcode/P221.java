package info.kernelhcy.leetcode;

public class P221
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        }));
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'0'}
        }));
    }

    public static class Solution
    {
        public int maximalSquare(char[][] matrix)
        {
            if (matrix.length <= 0) return 0;
            int maxSize = -1;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if (matrix[i][j] == '1') {
                        maxSize = Math.max(maxSize, findMatrix(matrix, i, j));
                    }
                }
            }

            if (maxSize < 0) return 0;
            return maxSize * maxSize;
        }

        private int findMatrix(char[][] m, int x, int y)
        {
            int size = 1;
            while (true) {
                if (x + size >= m.length || y + size >= m[x].length) {
                    return size;
                }

                for ( int i = 0; i <= size; ++i) {
                    if (m[x + size][y + i] != '1' || m[x + i][y + size] != '1') {
                        return size;
                    }
                }

                ++size;
            }
        }
    }
}
