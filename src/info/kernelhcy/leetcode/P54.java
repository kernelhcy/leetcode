package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P54
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
        };
        List<Integer> re = new Solution().spiralOrder(matrix);
        System.out.println(re);

        matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
        };
        re = new Solution().spiralOrder(matrix);
        System.out.println(re);

        matrix = new int[][]{
                new int[]{7},
                new int[]{9},
                new int[]{6},
                new int[]{0},
                new int[]{1},
                new int[]{2},
        };
        re = new Solution().spiralOrder(matrix);
        System.out.println(re);

        matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16},
        };
        re = new Solution().spiralOrder(matrix);
        System.out.println(re);
    }

    public static class Solution
    {
        public List<Integer> spiralOrder(int[][] matrix)
        {
            List<Integer> re = new LinkedList<>();
            if (matrix.length <= 0) return re;
            if (matrix[0].length <= 0) return re;

            int w = matrix[0].length;
            int h = matrix.length;

            int cnt = Math.min(w, h);

            for (int i = 0; i < (cnt + 1) / 2; ++i) {
                // top
                for (int j = i; j < w - i; ++j) {
                    re.add(matrix[i][j]);
                }

                // right
                for (int j = i + 1 ; j < h - i - 1; ++j) {
                    re.add(matrix[j][w - i - 1]);
                }

                // bottom
                for (int j = w - i - 1; j >= i && (i != h - i - 1); --j) {
                    re.add(matrix[h - i - 1][j]);
                }

                // left
                for (int j = h - i - 2; j > i && (i != w - i - 1); --j) {
                    re.add(matrix[j][i]);
                }
            }

            return re;
        }
    }
}
